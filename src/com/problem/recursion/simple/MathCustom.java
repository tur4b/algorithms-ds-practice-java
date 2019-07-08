package com.problem.recursion.simple;

//simple custom math functions
public class MathCustom {

    //multiply two numbers with recursion
    public static long multiply(long num1, long num2){
        if(num2 == 1) return num1;
        return multiply(num1, num2 - 1);
    }

    //find power of given number using recursion
    public static long pow(long num, long pow){
        if(pow == 1) return num;
        return num * pow(num, pow - 1);
    }

    //sum of numbers from 1 to n - 1,2,3,.....,n
    public static long sum(long num){
        if(num == 1) return 1;
        return num + sum(num - 1);
    }

}
