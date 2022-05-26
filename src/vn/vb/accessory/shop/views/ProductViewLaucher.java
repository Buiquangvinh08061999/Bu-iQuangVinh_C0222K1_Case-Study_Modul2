package vn.vb.accessory.shop.views;

import java.util.Scanner;

import vn.vb.accessory.shop.model.Product;
import vn.vb.accessory.shop.utils.AppUtils;
public class ProductViewLaucher {
    static Scanner scanner = new Scanner(System.in);
    static ProductView productView = new ProductView();
    public static void run(){
        int choice;
        do {
            menuAccessories();
            try {
                System.out.println("Chọn chức năng");
                System.out.print(" ⭆ ");
                choice= Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        productView.addProduct();
                        break;
                    case 2:
                        productView.updateProduct();
                        break;
                    case 3:
                        productView.remove();
                        break;
                    case 4:
                        productView.displayProduct(InputOption.SHOW);
                        break;
                    case 5:
                        break;
                    case 6:
                        productView.sortByPriceByASC();
                        break;
                    case 7:
                        productView.sortByPriceByDESC();
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



    public static void menuAccessories() {
        System.out.println();
        System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ MENU ACCESORIE ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
        System.out.println("\tஐ                                                                  ஐ");
        System.out.println("\tஐ                     1. Thêm sản phẩm phụ kiện                    ஐ");
        System.out.println("\tஐ                     2. Sửa thông tin sản phẩm theo ID            ஐ");
        System.out.println("\tஐ                     3. Xóa sản phẩm theo ID                      ஐ");
        System.out.println("\tஐ                     4. Hiển thị danh sách sản phẩm               ஐ");
        System.out.println("\tஐ                     5. Tìm kiếm sản phẩm theo tên                ஐ");
        System.out.println("\tஐ                     6. Hiển thị giá tiền tăng dần                ஐ");
        System.out.println("\tஐ                     7. Hiển thị giá tiền giảm dần                ஐ");
        System.out.println("\tஐ                                                                  ஐ");
        System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
        System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛");
        System.out.println("\t⊛                    Nhấn '8' để quay lại MAIN MENU                 ⊛ ");
        System.out.println("\t⊛                    Nhấn '0' để thoát chương trình                 ⊛ ");
        System.out.println("\t⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ⊛ ");
    }
}
