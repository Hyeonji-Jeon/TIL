package org.example;

import java.util.Scanner;

public class Calculator4U {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0; //값이 누적되어야 하니까 루프 밖에 선언.
                     //루프 안에 선언하면 루프 돌 때마다 초기화됨.

        while(true){

            System.out.println("값을 입력하세요");
            String str = scanner.nextLine();

            if (str.equals("END")){
                break;
            }

            int value = Integer.parseInt(str);
            sum = sum + value;
            System.out.println("sum :" + sum);

        }
    }
}
