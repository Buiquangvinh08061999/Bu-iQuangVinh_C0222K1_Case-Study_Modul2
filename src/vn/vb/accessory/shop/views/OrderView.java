package vn.vb.accessory.shop.views;
import vn.vb.accessory.shop.model.*;
import vn.vb.accessory.shop.services.*;
import vn.vb.accessory.shop.utils.AppUtils;
import vn.vb.accessory.shop.utils.ValidateUtils;

import java.util.*;
public class OrderView {
    private final Scanner scanner= new Scanner(System.in);

    private final IProductService productService;

    private final IOrderService orderService;

    private final IOrderItemService orderItemService;

    public OrderView(){
        productService = ProductService.getInstance();
        orderService = OrderService.getInstance();
        orderItemService = OrderItemService.getInstance();
    }

    public OrderItem addOrderItems(long orderId) {
        orderItemService.findAll();
        long id = System.currentTimeMillis() / 1000;
        System.out.println("Nhập Id phụ kiện bạn muốn mua: ");
        System.out.print(" ⭆ ");
        int idAcs = Integer.parseInt(scanner.nextLine());
        while (!productService.existsById(idAcs)){
            System.out.println("Id phụ kiện không tồn tại");
            System.out.println("Nhập Id phụ kiện: ");
            System.out.print(" ⭆ ");
            idAcs = scanner.nextInt();
        }
        Product product = productService.findById(idAcs);
        double price = product.getPrice();
        int oldQuantity= product.getQuantity();
        System.out.println("Nhập số lượng muốn mua");
        System.out.print(" ⭆ ");
        int quantity = Integer.parseInt(scanner.nextLine());
        while (!checkQualityBakery(product , quantity)){
            System.out.println("Vượt quá số lượng trong kho! Vui lòng nhập lại");
            System.out.println("Nhập số lượng");
            System.out.print(" ⭆ ");
            quantity = scanner.nextInt();
        }
        String nameAcs = product.getTitle();
        double total = quantity * price;
        int currentQuantity = oldQuantity - quantity;
        product.setQuantity(currentQuantity);

        OrderItem orderItem = new OrderItem(id,price,quantity, orderId, idAcs, nameAcs, total);
        productService.updateQuantity(idAcs, quantity);
        return orderItem;
    }

    public boolean checkQualityBakery(Product product, int quantity) {
        if (quantity <= product.getQuantity())
            return true;
        else
            return false;
    }



    public void addOder(){
        try {
            orderService.findAll();
            long orderId = System.currentTimeMillis() / 1000;
            ProductView productView = new ProductView();
            productView.displayProduct(InputOption.ADD);
            System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
            System.out.println("\tஐ                  Chức năng              ஐ");
            System.out.println("\tஐ            1.Tạo order mua sản phẩm     ஐ");
            System.out.println("\tஐ            2.Quay lại                   ஐ");
            System.out.println("\tஐ            3.Thoát chương trình         ஐ");
            System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
            System.out.print(" ⭆ ");
            int choiceA =-1;
            try {
                 choiceA = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Nhập sai yêu cầu nhập lại");
                addOder();
            }
               if (choiceA == 1) {
                   System.out.println("Nhập họ và tên (vd: Bui Quang Vinh) ");
                   System.out.print(" ⭆ ");
                   String name = scanner.nextLine();
                   while (!ValidateUtils.isNameValid(name)) {
                       System.out.println("Tên " + name + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
                       System.out.println("Nhập tên (vd: Quang Vinh) ");
                       System.out.print(" ⭆ ");
                       name = scanner.nextLine();
                   }

                   System.out.println("Nhập số điên thoại");
                   System.out.print(" ⭆ ");
                   String phone = scanner.nextLine();
                   while (!ValidateUtils.isPhoneValid(phone)) {
                       System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                       System.out.println("Nhập số điện thoại (vd: 0345129876)");
                       System.out.print(" ⭆ ");
                       phone = scanner.nextLine();
                   }

                   System.out.println("Nhập địa chỉ");
                   System.out.print(" ⭆ ");
                   String address = scanner.nextLine();
                   OrderItem orderItem = addOrderItems(orderId);
                   Order order = new Order(orderId, name, phone, address);
                   orderItemService.add(orderItem);
                   orderService.add(order);
                   System.out.println("Tạo đơn hàng thành công");
                   do {
                       System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
                       System.out.println("\tஐ    1.Nhấn 'y' để tạo tiếp đơn hàng     ஐ");
                       System.out.println("\tஐ    2.Nhấn 'q' để trở lại                ஐ");
                       System.out.println("\tஐ    3.Nhấn 'p' để in hoá đơn             ஐ");
                       System.out.println("\tஐ    4.Nhấn 't' để thoát                  ஐ");
                       System.out.println("\tஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ ஐ");
                       System.out.print(" ⭆ ");
                       String choice = scanner.nextLine();
                       switch (choice) {
                           case "y":
                               addOder();
                               break;
                           case "q":
                               OrderViewLauncher.run();
                               break;
                           case "p":
                               showPaymentInfo(orderItem, order);
                               break;
                           case "t":
                               AppUtils.exit();
                               break;
                           default:
                               System.out.println("Nhập không hợp lệ! Vui lòng nhập lại");
                       }
                   } while (true);
               } else if (choiceA == 2) {
                   OrderViewLauncher.run();
               } else if (choiceA == 3){
                   AppUtils.exit();
               }
        }catch (Exception e){
            System.out.println("Nhập sai. vui lòng nhập lại!");
            e.printStackTrace();
        }
    }

    public void showPaymentInfo(OrderItem orderItem, Order order) {
        try {
            System.out.println("----------------------------------------------------------HOÁ ĐƠN---------------------------------------------------------------------");
            System.out.printf("%-15s %-20s %-15s %-15s %-30s %-15s %-15s\n", "   Id", "Tên khách hàng", "  SĐT", "Địa chỉ", "Tên phụ kiện", "Số lượng", "Giá");
            System.out.printf("%-15d %-20s %-15s %-15s %-30s %-15d %-15s \n",
                    order.getId(),
                    order.getFullName(),
                    order.getMobile(),
                    order.getAddress(),
                    orderItem.getProductName(),
                    orderItem.getQuantity(),
                    AppUtils.doubleToVND(orderItem.getPrice())
            );

            System.out.println("\n\nTổng tiền cần thanh toán là:" +  AppUtils.doubleToVND(orderItem.getPrice_tong()));
            System.out.println("----------------------------------------------------------SHOP-PHỤ KIỆN----------------------------------------------------------------");
            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.println("Nhấn ");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        is = false;
                }
            } while (!is);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showAllOrder(){
        List<Order> orders = orderService.findAll();
        List<OrderItem> orderItems = orderItemService.findAll();
        OrderItem newOrderItem = new OrderItem();
        try {
            System.out.println("----------------------------------------------------------LIST ORDER----------------------------------------------------------------------------");
            System.out.println("                                                                                                                                      ");
            System.out.printf("%-15s %-20s %-25s %-15s %-30s %-15s %-15s %-15s\n", "   Id", "Tên khách hàng", " SĐT", "Địa chỉ", "Tên phụ kiện", "Số lượng", "Giá", "Tổng");
            for (Order order : orders) {
                for (OrderItem orderItem : orderItems) {
                    if (orderItem.getOrderId() == order.getId()) {
                        newOrderItem = orderItem;
                        break;
                    }
                }
                System.out.printf("%-15d %-20s %-25s %-15s %-30s %-15d %-15s %-15s \n",
                        order.getId(),
                        order.getFullName(),
                        order.getMobile(),
                        order.getAddress(),
                        newOrderItem.getProductName(),
                        newOrderItem.getQuantity(),
                        AppUtils.doubleToVND(newOrderItem.getPrice()),
                        AppUtils.doubleToVND(newOrderItem.getPrice_tong())
                        );
            }
            System.out.println("");
            System.out.println("----------------------------------------------------------SHOP-PHU KIEN----------------------------------------------------------------------------");
            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        is = false;
                }
            } while (!is);
        }catch (Exception e){
            System.out.println("Nhập sai");
        }
    }

}


