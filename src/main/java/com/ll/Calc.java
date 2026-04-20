package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");

        int result = Integer.parseInt(expressionBits[0]);

        for(int i = 1; i < expressionBits.length; i += 2){
            String op = expressionBits[i];
            int num = Integer.parseInt(expressionBits[i + 1]);
            if(op.equals("+")) result += num;
            else result -= num;
        }

        return result;
    }
}
