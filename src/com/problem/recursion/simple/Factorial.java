package com.problem.recursion.simple;

//not complete
public class Factorial {

    //simple factorial without recursion
    public long factorialForLoop(int number){
        long mul = 1;
        if(number == 0 || number == 1) return mul;
        for(int i = 2;i <= number; i++){
            mul *= i;
        }
        return mul;
    }

    //with recursion not optimal - slow
    public long  factorialRecursionSlow(long number){
        if(number == 0 || number == 1) return 1;
        return number * factorialRecursionSlow(number-1);
    }

    //with recursion optimal - fast (memoization)
    public long factorialRecursionFast(long[]a, int number){
        long num = a[number];
        if(num != 0){
            return num;
        }
        a[number] = number * factorialRecursionFast(a, number - 1);
        return a[number];
    }

}
