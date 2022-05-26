package vn.vb.accessory.shop.services;

import vn.vb.accessory.shop.model.OrderItem;
import java.util.*;
public interface IOrderItemService {

    List<OrderItem> findAll();

    void add(OrderItem newOrderItem);

    void update(OrderItem newOrderItem);

    OrderItem getOrderItemById(int id);
}
