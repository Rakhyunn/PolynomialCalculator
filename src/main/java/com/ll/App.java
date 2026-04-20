package com.ll;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("=== 다항식 계산기 ===");
        while(true) {
            System.out.println("(계산 / 종료) 중 명령어를 입력하여 주세요.");
            System.out.print("명령 : ");
            String cmd = scanner.nextLine().trim();
            switch (cmd) {
                case "종료" -> {
                    System.out.println("계산기를 종료합니다.");
                    return;
                }
                case "계산" -> {
                    System.out.println("계산할 식을 입력하여 주세요.");
                    System.out.print("계산식 : ");
                    String expression = scanner.nextLine().trim();
                    try {
                        int result = Calc.run(expression);
                        System.out.println("계산 결과: " + result);
                    } catch (Exception e) {
                        System.out.println("잘못된 계산식입니다. 다시 입력해주세요.");
                    }
                }
                default -> {
                    System.out.println("잘못된 명령입니다. 다시 입력해주세요.");
                    continue;
                }
            }
        }
    }
}
