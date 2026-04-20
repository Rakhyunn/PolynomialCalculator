package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" \\+ | - ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[1]);

        if(expression.contains("+")) return num1 + num2;
        else return num1 - num2;
    }
}
