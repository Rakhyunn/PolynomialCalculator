package com.ll;

import java.util.Arrays;
import java.util.List;

public class Calc {
    /** 계산 과정 **/
    // 가장 안쪽 괄호 쌍을 찾아 재귀로 값을 구하고(괄호가 없을 때까지)
    // 괄호 바깥 연산을 수행
    public static int run(String expression) {
        while(expression.contains("(")){
            // 가장 안쪽 여는 괄호 인덱스
            int openIdx = expression.lastIndexOf("(");
            // 가장 안쪽 괄호의 짝꿍인 닫는 괄호 인덱스
            int closeIdx = expression.indexOf(")", openIdx);
            // 괄호 안쪽을 계산
            int num = run(expression.substring(openIdx + 1, closeIdx));
            // 괄호를 계산 결과로 바꿔 다항식 치환
            expression = expression.substring(0, openIdx) + num + expression.substring(closeIdx + 1);
        }

        // 기존 계산 로직 수행
        String[] expressionBits = expression.split(" ");

        // 곱하기 연산이 있는 경우 먼저 처리
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

        // 빈 문자열 제거
        List<String> expressionList = Arrays.stream(expressionBits)
                .filter(s -> !s.isBlank())
                .toList();

        int result = Integer.parseInt(expressionList.get(0));

        // 배열 크기가 1이면 계산 종료
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
