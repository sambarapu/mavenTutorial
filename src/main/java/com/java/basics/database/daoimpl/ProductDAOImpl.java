package com.java.basics.database.daoimpl;

import com.java.basics.dao.ProductDAO;
import com.java.basics.database.DbConnection;
import com.java.basics.database.model.Product;
import com.java.basics.exception.InvalidInputException;
import com.java.basics.exception.UserNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> getProductList() throws Exception{
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        try {
            DbConnection dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT_DETAILS_M");
            while (resultSet.next()) {
                Product product = new Product();
                product.setpId(resultSet.getInt("p_id"));
                product.setpName(resultSet.getString("p_name"));
                product.setpDetails(resultSet.getString("p_details"));
                product.setVersion(resultSet.getInt("p_version"));
                productList.add(product);
            }
            return productList;
        } catch(Exception exception){
                throw new InvalidInputException("Input vales of product are unavailable");
        } finally {
            connection.close();
        }
    }

    @Override
    public Product getProductDetails(int productId) throws Exception {
        Product product = null;
        Connection connection = null;
        boolean userExists = false;
        try {
            DbConnection dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT_DETAILS_M WHERE P_ID=" + productId);
            while (resultSet.next()) {
                userExists = true;
                product = new Product();
                product.setpId(resultSet.getInt("p_id"));
                product.setpName(resultSet.getString("p_name"));
                product.setpDetails(resultSet.getString("p_details"));
                product.setVersion(resultSet.getInt("p_version"));

            }
            if (!userExists) {
                throw new UserNotFoundException("User not found");
            } return product;

        } catch(Exception exception){
            throw new InvalidInputException("Input vales of product are unavailable");
        } finally {
            connection.close();
        }
    }

}
