package com.java.basics;

import com.java.basics.database.DbConnection;
import org.junit.Assert;
import org.junit.Test;

public class DbConnectionTest {

    DbConnection dbConnection = new DbConnection();

    @Test
    public void FetchData() throws Exception{
        Assert.assertNotNull(dbConnection.getConnection());
    }

    //1 -) List size greater then 1
    // 2 check values at first index




}
