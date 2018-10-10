package com.java.basics.dao;

import com.java.basics.database.model.User;
import com.java.basics.database.model.UserDetails;
import com.java.basics.requestobject.UserDetailRO;

import java.util.List;

public interface UserDAO {
    public List<User> getUserList() throws Exception;
    public UserDetails getUserInfoDetails(int userId) throws Exception;
    public boolean deleteUser(int userId) throws Exception;
    public int doUserUpdate() throws Exception;

}
