package com.java.basics;

public class TriangularNumber {

    public boolean SumForGivenNumber(int number){
        if(number > 0) {
            int sum = 0;
            for(int i=1;i<= number;i++){

                sum = sum + i;
                if(sum == number){
                    return true;
                }
            }
        } return false;
    }
    public static void main(String args[]){
        TriangularNumber triangular = new TriangularNumber();
        if (triangular.SumForGivenNumber(3)){
            System.out.println("Given Number is triangular");
        } else {
            System.out.println("Given Number is not a triangular");
        }
    }
}
