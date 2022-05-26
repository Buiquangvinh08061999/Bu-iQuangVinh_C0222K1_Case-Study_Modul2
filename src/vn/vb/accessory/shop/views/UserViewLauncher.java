package vn.vb.accessory.shop.views;

import vn.vb.accessory.shop.utils.AppUtils;

import java.util.Scanner;

public class UserViewLauncher {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        int option = -1;
        do {
            menuUser();
            try {
                do {//Khong thich hien lại cả menu
                    System.out.println("Chọn chức năng:");
                    System.out.print(" ⭆ ");
                    option = Integer.parseInt(scanner.nextLine());
                    if (option > 4 || option < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (option > 4 || option < 0);

                switch (option) {
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.updateUser();
                        break;
                    case 3:
                        userView.showUsers(InputOption.SHOW);
                        break;
                    case 4:
                        break;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (option != 4);

    }

    public static void menuUser() {
        System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ USERS MANAGER ஐ ஐ ஐ ஐ ஐ ஐ  ஐஐ");
        System.out.println("\tஐ                                                  ஐ");
        System.out.println("\tஐ               1. Thêm người dùng                 ஐ");
        System.out.println("\tஐ               2. Sửa thông tin người dùng        ஐ");
        System.out.println("\tஐ               3. Hiện danh sách người dùng       ஐ");
        System.out.println("\tஐ                                                  ஐ");
        System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐஐ");
        System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ");
        System.out.println("\t⊛           Nhấn '4' để quay lại MAIN MENU          ⊛ ");
        System.out.println("\t⊛           Nhấn '0' để thoát chương trình          ⊛ ");
        System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ");
    }
}
