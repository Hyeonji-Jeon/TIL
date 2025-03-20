package org.example;

import java.util.Scanner;

public class RPSGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("가위0, 바위1, 보2 를 입력하세요");
        String str = scanner.nextLine(); //키보드에서 입력한 문자열
        System.out.println(str);

        int user = Integer.parseInt(str);
        int com = (int)(Math.random()*3); // 컴 값

        //삼항연산자
        //user = user < com ? user + 3 : user;

        if(user < com){
             user = user + 3;
        }//end if

        int result = user - com; //0,1,2

        System.out.println("USER: " + user);
        System.out.println("COM: " + com);

        switch (result){
            case 0:
                System.out.println("비김");
                break;
            case 1:
                System.out.println("이김");
                break;
            case 2 :
                System.out.println("졌다");
                break;
        }//end switch
    }
}
