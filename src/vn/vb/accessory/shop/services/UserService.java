package vn.vb.accessory.shop.services;

import vn.vb.accessory.shop.model.User;
import vn.vb.accessory.shop.model.Role;
import  vn.vb.accessory.shop.utils.CSVUtils;
import java.time.Instant;
import java.util.*;



public class UserService implements IUserService{
    public static final String path="data/users.csv";

    private static UserService instance;

    private UserService(){
    }

    public static UserService getInstance(){
        if(instance == null)
            instance = new UserService();
        return instance;
    }

    @Override
    public List<User> finAll() {
       List<User> users = new ArrayList<>();
       List<String> records = CSVUtils.readFile(path);
       for (String record : records){
           users.add(User.parseUser(record));
       }
       return users;
    }

    @Override
    public User adminLogin(String username, String password,String mobiphone) {
        List<User> users = finAll();
        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password) &&user.getMobile().equals(mobiphone)
                    && user.getRole().equals(Role.ADMIN)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User newUser) {
        List<User> users = finAll();
        newUser.setCreatedAt(Instant.now());
        users.add(newUser);
        CSVUtils.writeFile(path, users);

    }

    @Override
    public void update(User newUser) {
        List<User> users = finAll();
        for (User user : users) {
            if (user.getId() == newUser.getId()) {

                String fullName = newUser.getFullName();
                if (fullName != null && !fullName.isEmpty())
                    user.setFullName(fullName);

                String phone = newUser.getMobile();
                if (phone != null && !phone.isEmpty())
                    user.setMobile(newUser.getMobile());

                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());

                user.setUpdatedAt(Instant.now());
                CSVUtils.writeFile(path, users);
                break;
            }
        }

    }
    @Override
    public User finById(int id) {
        List<User> users = finAll();
        for (User user : users){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean exitsById(int id) {
        return finById(id) != null;
    }

    @Override
    public boolean exitsByEmail(String email) {
        List<User> users = finAll();
        for (User user : users){
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean exitsByPhone(String mobile) {
        List<User> users = finAll();
        for(User user : users){
            if(user.getMobile().equals(mobile)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean exitsByUsername(String userName) {
        List<User> users = finAll();
        for (User user : users){
            if(user.getUsername().equals(userName)){
                return true;
            }
        }
        return false;
    }
}
