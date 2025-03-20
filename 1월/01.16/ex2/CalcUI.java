package org.example.ex2;

import java.util.Scanner;

//로직 위주의 객체
//인스턴스 변수 - 조력자/협력자
public class CalcUI {

    Calculator calculator;

    public CalcUI(Calculator calculator) {   //누군지는 모르는데 Calculator 타입의 사람을 소개 받았다
        this.calculator = calculator;
    }

    public void startUI(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("num1");
        int num1 = Integer.parseInt(scanner.nextLine());

    }
}
