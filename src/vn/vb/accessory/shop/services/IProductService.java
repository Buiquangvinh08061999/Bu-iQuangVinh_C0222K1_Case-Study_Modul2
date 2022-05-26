package vn.vb.accessory.shop.services;
import vn.vb.accessory.shop.model.Product;

import java.util.*;

public interface IProductService {
    List<Product> findAll();

    void add(Product newProduct);

    void update(Product newProduct);

    void deleteById(int id);

    Product findById(int id);

    boolean existID(int id);

    boolean existByName(String name);

    boolean existsById(int id);

//    List<Product> searchProductByName(String name);

    List<Product> findAllOrderByPriceASC();

    List<Product> findAllOrderByPriceDESC();

    void updateQuantity(long id, int quantity);
}
