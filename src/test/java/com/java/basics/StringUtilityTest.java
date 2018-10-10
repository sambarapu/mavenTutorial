package com.java.basics;

import com.java.basics.exception.InvalidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StringUtilityTest {


    StringUtility utility = new StringUtility();


    @Test
    public void testGetWordListSize() throws Exception{
        Assert.assertEquals(2,utility.getWordList("Riyansh Chandra").size());

    }

    @Test
    public void testGetWordListData() throws Exception{
        List<String> stringList = utility.getWordList("Riyansh Chandra");
        Assert.assertEquals("Riyansh",stringList.get(0));
        Assert.assertEquals("Chandra",stringList.get(1));
    }

    @Test
    public void testNullGetWordListData() throws  Exception{
        try {
            List<String> stringList = utility.getWordList("");
        }catch (Exception exception){
            Assert.assertEquals("Please provide correct input",exception.getMessage());
        }

    }

    @Test(expected = InvalidInputException.class)
    public void testNullInputGetWordListData() throws Exception{
        List<String> stringList = utility.getWordList(null);
    }

    @Test
    public void testStringLength(){

        Assert.assertEquals(6,utility.stringLength("Riyansh"));
    }

    @Test
    public void testForInputValueSize() throws Exception{
        //List<String> expectedResult = utility.getFilteredNameList("riyansh latha cherry sree chandra riyu", 'c');
        Assert.assertEquals(2, utility.getFilteredNameList("riyansh latha cherry sree chandra riyu", 'c').size());
    }

    @Test
    public void testForInputValues() throws Exception{
        List<String> expectedResult = utility.getFilteredNameList("riyansh latha cherry sree chandra riyu", 'c');
        Assert.assertEquals("cherry", expectedResult.get(0));
        Assert.assertEquals("chandra", expectedResult.get(1));
    }

     @Test(expected = InvalidInputException.class)
     public void testCaseForNullInput() throws Exception {
        List<String> nullInputResult = utility.getFilteredNameList(null, ' ');
     }

    @Test
     public void invalidInputDate()  {
        try {
            List<String> invalidInput = utility.getFilteredNameList("      ", 'v');
        }catch (InvalidInputException exception){
            Assert.assertEquals("Please enter valid input",exception.getMessage());
        }
     }


}
