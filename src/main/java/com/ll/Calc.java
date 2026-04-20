package com.ll;

import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");

        if(expression.contains("*")) {
            for(int i = 0; i < expressionBits.length; i++){
                if(expressionBits[i].equals("*")){
                    int num1 = Integer.parseInt(expressionBits[i - 1]);
                    int num2 = Integer.parseInt(expressionBits[i + 1]);
                    expressionBits[i + 1] = String.valueOf(num1 * num2);
                    expressionBits[i - 1] = "";
                    expressionBits[i] = "";
                }
            }
        }

        List<String> expressionList = Arrays.stream(expressionBits)
                .filter(s -> !s.isBlank())
                .toList();

        int result = Integer.parseInt(expressionList.get(0));

        if(expressionList.size() == 1) return result;

        for(int i = 1; i < expressionList.size(); i += 2){
            String op = expressionList.get(i);
            int num = Integer.parseInt(expressionList.get(i + 1));
            if(op.equals("+")) result += num;
            else result -= num;
        }

        return result;
    }
}
