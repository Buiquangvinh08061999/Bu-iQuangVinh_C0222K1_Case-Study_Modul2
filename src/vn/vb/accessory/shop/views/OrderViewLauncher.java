package vn.vb.accessory.shop.views;

import vn.vb.accessory.shop.utils.AppUtils;

import java.util.Scanner;

public class OrderViewLauncher {


    static Scanner scanner = new Scanner(System.in);
    static OrderView orderView = new OrderView();
    public static void run(){
        int choice;
        do {
            menuOrder();
            try {
                System.out.println("Chọn chức năng");
                System.out.print(" ⭆ ");
                choice= Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        orderView.addOder();
                        break;
                    case 2:
                        orderView.showAllOrder();
                        break;
                    case 3:
                        break;
                    case 8:
                        MainLauncher.menuOption();
                        break;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            }catch (Exception e){
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        }while (true);
    }

    public static void menuOrder() {
        System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ORDER MENU ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ");
        System.out.println("\tஐ                                                         ஐ");
        System.out.println("\tஐ                   1. Tạo order                          ஐ");
        System.out.println("\tஐ                   2. Xem danh sách order                ஐ");
        System.out.println("\tஐ                                                         ஐ");
        System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ  ஐ");
        System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ");
        System.out.println("\t⊛              Nhấn '8' để quay lại MAIN MENU             ⊛ ");
        System.out.println("\t⊛              Nhấn '0' để thoát chương trình             ⊛");
        System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛");
    }
}
