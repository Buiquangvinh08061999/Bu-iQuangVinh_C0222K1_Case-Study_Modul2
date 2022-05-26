package vn.vb.accessory.shop.services;
import vn.vb.accessory.shop.model.Order;
import  vn.vb.accessory.shop.utils.CSVUtils;
import java.util.*;
public class OrderService implements IOrderService{

    private final static String PATH ="data/orders.csv";

    private static OrderService instance;

    private OrderService(){
    }

    public static OrderService getInstance(){
        if(instance == null){
            instance = new OrderService();
        }
        return instance;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for (String record : records){
            orders.add(Order.parse(record));
        }
        return orders;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orders = findAll();
        orders.add(newOrder);
        CSVUtils.writeFile(PATH,orders);

    }

    @Override
    public void update() {
        List<Order> orders = findAll();
        CSVUtils.writeFile(PATH, orders);
    }

    @Override
    public Order findById(long id) {
        List<Order> orders = findAll();
        for (Order order : orders) {
            if (id == order.getId())
                return order;
        }
        return null;
    }

    @Override
    public List<Order> findByUserId(long id) {
        List<Order> newOrders = new ArrayList<>();
        for (Order order : findAll()){
            if (id==order.getId()){
                newOrders.add(order);
            }
        }
        return newOrders;
    }

    @Override
    public boolean existById(long id) {
        return findById(id) !=null;
    }
}
