package vn.vb.accessory.shop.views;
import vn.vb.accessory.shop.model.User;
import vn.vb.accessory.shop.model.Role;
import vn.vb.accessory.shop.services.IUserService;
import vn.vb.accessory.shop.services.UserService;
import vn.vb.accessory.shop.utils.AppUtils;
import vn.vb.accessory.shop.utils.InstanUtils;
import vn.vb.accessory.shop.utils.ValidateUtils;

import java.util.*;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);

    private final IUserService userService;

    public UserView() {
        userService = UserService.getInstance();
    }


    public void addUser() {
        do {
            try {
                long id = System.currentTimeMillis() / 1000;
                String username = inputUsername();
                String password = inputPassword();
                String fullName = inputFullName(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String email = inputEmail();
                String address = inputAddress(InputOption.ADD);
                User user = new User(id, username, password, fullName, phone, email, address, Role.USER);
                setRole(user);
                userService.add(user);
                System.out.println("Đã thêm thành công!");
            }catch (Exception e){
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        }while (AppUtils.isRestry(InputOption.ADD));
    }

    public void setRole(User user){
        System.out.println("= = SET ROLE = =");
        System.out.println("∥   1. USER    ∥");
        System.out.println("∥   2. ADMIN   ∥");
        System.out.println("= = = =  = = = = ");
        System.out.println("Chọn Role: ");
        System.out.print(" ⭆ ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    user.setRole(Role.USER);
                    break;
                case 2:
                    user.setRole(Role.ADMIN);
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    setRole(user);
            }
    }

    public void updateUser(){
        boolean isRetry;
        showUsers(InputOption.UPDATE);
        do {
            long id = inputId(InputOption.UPDATE);
            System.out.println("┌ - - - - - - - - - - SỬA - - - - - - - - - -┐");
            System.out.println("︲        1. Sửa tên                         ︲");
            System.out.println("︲        2. Sửa số điện thoại               ︲");
            System.out.println("︲        3. Sửa địa chỉ                     ︲");
            System.out.println("︲        4. Sửa tên, số điện thoại, địa chỉ ︲");
            System.out.println("︲        5. Quay lại                        ︲");
            System.out.println("└ - - - - - - - - - - - - - - - - - - - - - -┘");

            int option =AppUtils.retryChoose(1,5);
            User newUser = new User();
            newUser.setId(id);
            switch (option){
                case 1:
                    String name = inputFullName(InputOption.UPDATE);
                    newUser.setFullName(name);
                    userService.update(newUser);
                    System.out.println("Bạn đã đổi tên thành công!");
                    break;
                case 2:
                    String mobile = inputPhone(InputOption.UPDATE);
                    newUser.setMobile(mobile);
                    userService.update(newUser);
                    System.out.println("Bạn đã đổi số điện thoại thành công!");
                    break;
                case 3:
                    String address =inputAddress(InputOption.UPDATE);
                    newUser.setAddress(address);
                    userService.update(newUser);
                    System.out.println("Bạn đã đổi địa chỉ thành công!");
                    break;
                case 4:
                    String name_1 = inputFullName(InputOption.UPDATE);
                    String mobile_1 = inputPhone(InputOption.UPDATE);
                    String address_1 =inputAddress(InputOption.UPDATE);

                    newUser.setFullName(name_1);
                    newUser.setMobile(mobile_1);
                    newUser.setAddress(address_1);
                    userService.update(newUser);
                    System.out.println("Bạn đã đổi thành công!");
                    break;
            }
            isRetry = option !=4 && AppUtils.isRestry(InputOption.UPDATE);
        }while (isRetry);
    }

    public void showUsers(InputOption inputOption) {
        System.out.println("----------------------------------------- DANH SÁCH NGƯỜI DÙNG--------------------------------------- ");
        System.out.printf("%-15s %-22s %-20s %-30s %-20s %-20s %-20s %-20s\n", "Id", "Tên", "Số điện thoại", "Email", "Địa chỉ", "Người dùng", "Ngày tạo", "Ngày cập nhật");
        List<User> users = userService.finAll();
        for (User user : users) {
            System.out.printf("%-15d %-22s %-20s %-30s %-20s %-20s %-20s %-20s\n",
                    user.getId(),
                    user.getFullName(),
                    user.getMobile(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getRole(),
                    InstanUtils.instantToString(user.getCreatedAt()),
                    user.getUpdatedAt() == null ? "" : InstanUtils.instantToString(user.getUpdatedAt())
            );
        }
        System.out.println("-----------------------------------------------------------------------------------------------------  ");
        if (inputOption == InputOption.SHOW)
            AppUtils.isRestry(InputOption.SHOW);
    }



    private int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id");
                break;
            case UPDATE:
                System.out.println("Nhập Id bạn muốn sửa");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = userService.exitsById(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;
    }


    public String inputUsername() {
        System.out.println("Nhập Username (không bao gồm dấu cách, kí tự đặc biệt)");
        System.out.print(" ⭆ ");
        String username;

        do {
            if (!ValidateUtils.isUsernameValid(username = AppUtils.retryString("Username"))) {
                System.out.println(username + " của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.print(" ⭆ ");
                continue;
            }
            if (userService.exitsByUsername(username)) {
                System.out.println("Username này đã tồn tại. Vui lòng nhập lại");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    private String inputFullName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập họ và tên (vd: Ho Thi Thuan) ");
                break;
            case UPDATE:
                System.out.println("Nhập tên mà bạn muốn sửa đổi");
                break;
        }
        System.out.print(" ⭆ ");
        String fullName;
        while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
            System.out.println("Tên " + fullName + "không đúng định dạng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
            System.out.println("Nhập tên (vd: Ho Thuan) ");
            System.out.print(" ⭆ ");
        }
        return fullName;
    }

    public String inputPhone(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số điện thoại (vd: 0345129876): ");
                break;
            case UPDATE:
                System.out.println("Nhập số điện thoại mà bạn muốn đổi");
                break;
        }
        System.out.print(" ⭆ ");
        String phone;
        do {
            phone = scanner.nextLine();
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                System.out.println("Nhập số điện thoại (vd: 0345129876)");
                System.out.print(" ⭆ ");
                continue;
            }
            if (userService.exitsByPhone(phone)) {
                System.out.println("Số này đã tồn tại! Mời bạn nhập lại");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (true);
        return phone;
    }

    private String inputEmail() {
        System.out.println("Nhập email (vd: thuan@gmail.com)");
        System.out.print(" ⭆ ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("Email " + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.println("Nhập email (vd: thuan@gmail.com)");
                System.out.print(" ⭆ ");
                continue;
            }
            if (userService.exitsByEmail(email)) {
                System.out.println("Email " + email + "của bạn đã tồn tại! vui lòng kiểm tra lại");
                System.out.println("Nhập email (vd: thuan@gmail.com)");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputPassword() {
        System.out.println("Nhập mật khẩu( mật khẩu phải > 8 kí tự )");
        System.out.print(" ⭆ ");
        String password;
        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
            System.out.println("Mật khẩu yếu! Vui lòng nhập lại ");
            System.out.print(" ⭆ ");
        }
        return password;
    }


    private String inputAddress(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập địa chỉ (vd: Huế)");
                break;
            case UPDATE:
                System.out.println("Nhập địa chỉ mà bạn muốn đổi");
                break;
        }
        System.out.print(" ⭆ ");
        return scanner.nextLine();
    }
}
