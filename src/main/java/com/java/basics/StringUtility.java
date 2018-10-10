package com.java.basics;

import com.java.basics.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class StringUtility {

    /**
     *
     * @param name
     * @return
     */
   public int stringLength(String name){
     return name.length();
   }

    /**
     *  inout  "Chandra Shekhar"
     * @return ArrayList
     *
     *
     */
    public List<String> getWordList(String inputString) throws InvalidInputException {
        if(inputString == null || "".equalsIgnoreCase(inputString)){
            throw new InvalidInputException("Please provide corret input");
        }
        List<String> stringList = new ArrayList<>();
            try {
            String[] wordsArray = inputString.split(" ");
            for (int i = 0; i < wordsArray.length; i++) {
                stringList.add(wordsArray[i]);
                }
             } catch (Exception exception){
            throw exception;
        }
       return  stringList;

    }

    /**
     *  inout  "Chandra Shekhar Cheryy Latha" , 'l'
     * @return ArrayList
     *
     *
     */

   public List<String> getFilteredNameList(String inputStringA, char filterChar) throws InvalidInputException{
       if(inputStringA == null || "".equalsIgnoreCase(inputStringA.trim()) || filterChar == ' '){
           throw new InvalidInputException("Please enter valid input");
       }
        List<String> stringList = new ArrayList<>();
       try{
            String[] wordsArray= inputStringA.split(" ");
            for(int i=0;i<wordsArray.length;i++){
            if(wordsArray[i].startsWith(String.valueOf(filterChar))){
                stringList.add(wordsArray[i]);
                }
            }
       }catch (Exception exception1){
            throw exception1;
        }
        return  stringList;
    }




}
