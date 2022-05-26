package vn.vb.accessory.shop.views;

import java.util.InputMismatchException;
import java.util.Scanner;
import vn.vb.accessory.shop.utils.AppUtils;

public class MainLauncher {

    public static void launch() {
        AdminView adminView = new AdminView();
        adminView.loginAdmin();
        menuOption();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("⭆ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        UserViewLauncher.run();
                        break;
                    case 2:
                        ProductViewLaucher.run();
                        break;
                    case 3:
                        OrderViewLauncher.run();
                        break;
                    case 0:
                        AppUtils.exit();
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    public static void mainMenu() {
        System.out.println("\t ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
        System.out.println("\t ஐ                  CHÀO MỪNG BẠN ĐẾN VỚI            ஐ");
        System.out.println("\t ஐ            SHOP-PHỤ KIỆN TELEPHONE VINH BÙI       ஐ");
        System.out.println("\t ஐ                        (^.^)                      ஐ");
        System.out.println("\t ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
        System.out.println("\t ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ MAIN MENU ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
        System.out.println("\t ஐ                                                   ஐ");
        System.out.println("\t ஐ                1. Quản lí người dùng              ஐ");
        System.out.println("\t ஐ                2. Quản lí phụ kiện                ஐ");
        System.out.println("\t ஐ                3. Quản lí đơn đặt hàng            ஐ");
        System.out.println("\t ஐ                                                   ஐ");
        System.out.println("\t ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
        System.out.println("\t ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛");
        System.out.println("\t ⊛             Nhấn '0' để thoát chương trình        ⊛ ");
        System.out.println("\t ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛");
    }
}
