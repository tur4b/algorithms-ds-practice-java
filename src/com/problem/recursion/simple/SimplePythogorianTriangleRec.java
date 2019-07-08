package com.problem.recursion.simple;

//sum function with recursion - so simple right? :)
public class SimplePythogorianTriangleRec {
    /*  number is 4
        [
        [[
        [[[
        [[[[
    how many brackets was used => 1+2+3+4=10 brackets*/
    public long triangleRecursion(long number){
        if(number == 1) return 1;
        return number + triangleRecursion(number - 1);
    }

}
