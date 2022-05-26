package vn.vb.accessory.shop.views;
import vn.vb.accessory.shop.services.IUserService;
import vn.vb.accessory.shop.services.UserService;
import vn.vb.accessory.shop.utils.AppUtils;

import java.util.Scanner;

public class AdminView {
    private  final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);


    public AdminView() {
        userService = UserService.getInstance();
    }


    public  void loginAdmin(){
        boolean isRetry;
        System.out.println("✽ ✽ ✽ ✽ ✽ ✽ ✽ ✽ ĐĂNG NHẬP HỆ THỐNG ✽ ✽ ✽ ✽ ✽ ✽ ✽ ✽ ");
        do {
            System.out.println("Username");
            String username = AppUtils.retryString("Username");
            System.out.println("PassWord");
            String password = AppUtils.retryString("Password");
            System.out.println("Enter phone number to confirm ");
            String phone = AppUtils.retryString("Phone");
            if (userService.adminLogin(username,password,phone) == null){
                System.out.println("Tài khoản không hợp lệ!");
                isRetry = menuSmall();
            }else {
                System.out.println("Bạn đã đăng nhập thành công!");
                MainLauncher.menuOption();
                isRetry = false;

            }

        }while (isRetry);
    }

    private boolean menuSmall() {
        do {
            try {
                System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ");
                System.out.println("\t⊛     Nhấn 'q' để đăng nhập lại                   ⊛ ");
                System.out.println("\t⊛     Nhấn 'r' để thoát chương trình              ⊛");
                System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        loginAdmin();
                        break;
                    case "r":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại ");
                        break;
                }
            }catch (Exception e){
                System.out.println("Nhập sai");
            }
        }while (true);
    }
}
