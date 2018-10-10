package com.java.basics.dao;

import com.java.basics.database.model.Product;
import com.java.basics.exception.InvalidInputException;
import java.util.List;

public interface ProductDAO {

    public List<Product> getProductList() throws Exception;
    public Product getProductDetails(int productId) throws Exception;
}
