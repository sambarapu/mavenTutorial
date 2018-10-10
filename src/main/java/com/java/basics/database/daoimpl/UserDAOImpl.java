package com.java.basics.database.daoimpl;

import com.java.basics.dao.UserDAO;
import com.java.basics.database.DbConnection;
import com.java.basics.database.model.User;
import com.java.basics.database.model.UserDetails;
import com.java.basics.exception.UserNotFoundException;
import com.java.basics.requestobject.UserDetailRO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getUserList() throws Exception{
        List<User> userList = new ArrayList<>();
        Connection connection=null;
        try {
            DbConnection dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT user_id,user_name FROM USER_M");
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                userList.add(user);
            }
            return userList;
        } catch(Exception exception){
            throw exception;
        }
        finally {
            connection.close();
        }
    }

    @Override
    public UserDetails getUserInfoDetails(int userId) throws Exception {
        UserDetails userDetails = null;
        Connection connection=null;
        boolean isUserExists = false;
        try{
            DbConnection dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER_DETAIL_M WHERE user_id = "+userId );
            while(resultSet.next()){
                isUserExists = true;
                userDetails = new UserDetails();
                userDetails.setUserId(resultSet.getInt("user_id"));
                userDetails.setUserFirstName(resultSet.getString("u_first_name"));
                userDetails.setUserLastName(resultSet.getString("u_last_name"));
                userDetails.setUserAddress(resultSet.getString("u_street_name"));
                userDetails.setUserSsn(resultSet.getString("u_ssn_number"));
                userDetails.setUserPhonenumber(resultSet.getString("u_phone_number"));

            }
            if(!isUserExists){
                throw new UserNotFoundException("User Not Available");
            }
            return userDetails;
        } catch(Exception exception){
            throw exception;
        } finally {
            connection.close();
        }
    }

    @Override
    public boolean deleteUser(int userId) throws Exception {

        Connection connection = null;
        try {
            DbConnection dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("DELETE FROM USER_DETAIL_M WHERE user_id =" + userId);
            if (result == 1) {
                return true;
            }
            return false;
        } catch (Exception exception) {
            throw exception;
        } finally {
            connection.close();
        }
    }

    @Override
    public int doUserUpdate() throws Exception {
        boolean userUpdate = false;
        int updateStatus;
        Connection connection = null;
        try {

            DbConnection dbConnection = new DbConnection();
            connection = dbConnection.getConnection();
            String query = "UPDATE USER_DETAIL_M SET u_first_name = ? WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Chandra");
            preparedStatement.setInt(2, 5);
            updateStatus = preparedStatement.executeUpdate();
            return updateStatus;
        } catch(Exception exception){
            throw exception;
        } finally {
            connection.close();
        }
    }

}
