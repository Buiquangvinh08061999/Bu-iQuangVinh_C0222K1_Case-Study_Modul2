package vn.vb.accessory.shop.services;

import vn.vb.accessory.shop.model.OrderItem;
import  vn.vb.accessory.shop.utils.CSVUtils;
import java.util.*;
public class OrderItemService implements IOrderItemService{


    private final static String PATH ="data/order-item.csv";
    private static OrderItemService instance;

    private OrderItemService(){

    }
    public static OrderItemService getInstance(){
        if(instance == null){
            instance= new OrderItemService();
        }
        return instance;
    }




    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for (String record : records){
            orderItems.add(new OrderItem(record));
        }
        return orderItems;
    }

    @Override
    public void add(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        orderItems.add(newOrderItem);
        CSVUtils.writeFile(PATH,orderItems);
    }

    @Override
    public void update(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        CSVUtils.writeFile(PATH,orderItems);
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getId() == id)
                return orderItem;
        }
        return null;
    }
}
