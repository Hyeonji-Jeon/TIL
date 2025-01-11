package org.example;

import java.util.Scanner;

public class ScanEx {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("나이를 입력하세요");
        String str = scanner.nextLine(); //키보드에서 입력한 문자열
        System.out.println(str);

        int age = Integer.parseInt(str);

        if(age >= 18){
            System.out.println("성인");
        }else {
            System.out.println("미성년자");
        }

    }
}
