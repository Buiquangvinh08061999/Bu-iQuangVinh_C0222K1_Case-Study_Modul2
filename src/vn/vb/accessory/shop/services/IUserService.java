package vn.vb.accessory.shop.services;
import vn.vb.accessory.shop.model.User;

import java.util.List;

public interface IUserService {
    List<User> finAll();

    User adminLogin(String username,String password,String mobiphone);

    void add(User newUser);

    void update(User newUser);

    boolean exitsById(int id);

    boolean exitsByEmail(String email);

    boolean exitsByPhone(String mobile);

    boolean exitsByUsername(String userName);

    User finById(int id);



}
