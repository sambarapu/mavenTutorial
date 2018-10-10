package com.java.basics.database;

import com.java.basics.Operations;
import com.java.basics.database.model.Product;
import com.java.basics.database.model.User;
import com.java.basics.database.model.UserDetails;
import com.java.basics.requestobject.UserDetailRO;

import java.util.List;
import java.util.Scanner;

public class ConnectionMain {
    public static void main(String []a) throws Exception {
        Scanner input =  new Scanner(System.in);
        System.out.println("Enter What Operation");
        Operations operations = new Operations();
        String inputType = input.next();
        if("fetchAll".equalsIgnoreCase(inputType)){
            List<User> userList=operations.getUserList();
            System.out.println("userList:::"+userList.size());
        }else if("userDetails".equalsIgnoreCase(inputType)){
            System.out.println("Enter User Id for details ");
            Scanner userIdInput = new Scanner(System.in);
            int userId = userIdInput.nextInt();
           UserDetails userDetails= operations.getUserDetail(userId);
           System.out.println("User Details :"+ userDetails.getUserFirstName());
        }else if("updateUser".equalsIgnoreCase(inputType)){


        }else if("insertUser".equalsIgnoreCase(inputType)){

        } else if("deleteUser".equalsIgnoreCase(inputType)){
            System.out.println("Enter User Id to delete ");
            Scanner userIdInput = new Scanner(System.in);
            int userId = userIdInput.nextInt();
           boolean result= operations.deleteUser(userId);
           if(result){
               System.out.println("Delete Success");
           }else{
               System.out.println("No user Exists ");
           }
        } else if ("productList".equalsIgnoreCase(inputType)){
            List<Product> productList=operations.getProductList();
            System.out.println("List of products ::"+productList.size());
        } else if ("productDetail".equalsIgnoreCase(inputType)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter UserId");
            int productId = scanner.nextInt();
            Product product = operations.getProductDetails(productId);
            System.out.println("Product Details::" + product.getpName());
        } else if ("updateRequest".equalsIgnoreCase(inputType)){
            int updateStatus = operations.doUserUpdate();
            if (updateStatus == 1){
                System.out.println("User Details are Updated");
            } else {
                System.out.println("User update failed");
            }
        }
    }

}
