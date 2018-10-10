package com.java.basics;


import com.java.basics.dao.ProductDAO;
import com.java.basics.dao.UserDAO;
import com.java.basics.database.daoimpl.UserDAOImpl;
import com.java.basics.database.model.User;
import com.java.basics.database.model.UserDetails;
import com.java.basics.exception.InvalidInputException;
import com.java.basics.database.daoimpl.ProductDAOImpl;
import com.java.basics.database.model.Product;
import com.java.basics.requestobject.UserDetailRO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
// this is the service class which will give you differeent services
public class Operations {

    /**
     * @param input1
     * @param input2
     * @return
     */
    public int addition(int input1, int input2) {

        return MathUtility.addition(input1, input2);
    }

    public List<String> getWordList(String input) throws InvalidInputException {
        List<String> resultList = new ArrayList<>();
        StringUtility utility = new StringUtility();
        resultList = utility.getWordList(input);
        return resultList;
    }

    public List<User> getUserList() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.getUserList();

    }

    public UserDetails getUserDetail(int input) throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.getUserInfoDetails(input);
    }

    public boolean deleteUser(int userId) throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.deleteUser(userId);
    }

    public List<Product> getProductList() throws Exception {
        ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.getProductList();
    }

    public Product getProductDetails(int productId) throws Exception {
        ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.getProductDetails(productId);
    }

    public int doUserUpdate() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.doUserUpdate();
    }
}