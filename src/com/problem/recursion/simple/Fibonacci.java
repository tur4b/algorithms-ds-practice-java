package com.problem.recursion.simple;

public class Fibonacci {

    //fibonacci numbers - 1 , 1 , 2 , 3 , 5 , 8 , 13 , 21 , 34 , 55 ,......
    //indexs            - 0 , 1 , 2 , 3 , 4 , 5 , 6 ,  7  ,  8 ,  9 ,.......
    public static long fibonacci(long number){
        if(number == 0 || number == 1) return 1;
        return fibonacci(number - 2) + fibonacci(number - 1);
    }
}
