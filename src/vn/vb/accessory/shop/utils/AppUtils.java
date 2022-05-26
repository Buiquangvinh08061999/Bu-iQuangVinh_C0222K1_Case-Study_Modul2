package vn.vb.accessory.shop.utils;

import vn.vb.accessory.shop.views.InputOption;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static int retryChoose(int min, int max){
        int option;
        do {
            try {
                System.out.print(" ⭆ ");
                option = Integer.parseInt(scanner.nextLine());
                if(option > max || option < min){
                    System.out.println("Chọn chức năng sai! vui lòng chọn lại");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Nhập sai vui lòng nhập lại");
            }
        }while (true);
        return option;
    }

    public static int retryParseInt(){
        int result;
        do {
            try {
                System.out.print(" ⭆ ");
                result = Integer.parseInt(scanner.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Nhập sai vui lòng nhập lại");
            }
        }while (true);
    }
    public static double retryParseDoubtle(){
        double result;
        do {
            try {
                System.out.print(" ⭆ ");
                result = Double.parseDouble(scanner.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Nhập sai vui lòng nhập lại");
            }
        }while (true);
    }

    public static String retryString(String fieldName){
        String result;
        System.out.print(" ⭆ ");
        while ((result = scanner.nextLine()).isEmpty()){
            System.out.printf("%s Không được để trống\n" + fieldName);
            System.out.print(" ⭆ ");
        }
        return result;
    }

    public static String doubleToVND(double value){
        String patternVND =",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }
    public static boolean isRestry(InputOption inputOption){
       do {
           switch (inputOption){
               case ADD:
                   System.out.println("Nhấn 'y' để thêm tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                   break;
               case UPDATE:
                   System.out.println("Nhấn 'y' để sửa tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                   break;
               case DELETE:
                   System.out.println("Nhấn 'q' để quay lại\t|\t 't' để thoát chương trình");
                   break;
               case SHOW:
                   System.out.println("Nhấn 'q' để quay lại\t|\t 't' để thoát chương trình");
                   break;
               default:
                    throw new IllegalStateException("Unexpected value" + inputOption);
           }
           System.out.print(" ⭆ ");
           String option = scanner.nextLine();
           switch (option){
               case "y":
                   return true;
               case "q":
                   return false;
               case "t":
                   exit();
                   break;
               default:
                   System.out.println("Chọn sai vui lòng nhập lại");
                   break;
           }
       }while (true);
    }

    public static void exit(){
        System.out.println("\t See you again!");
        System.exit(0);
    }



}
