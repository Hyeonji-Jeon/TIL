package org.example;

import java.util.Scanner;

public class RandomGame {

    public static void main(String[] args) {

        //Scanner 필요
        Scanner scanner = new Scanner(System.in);

        //당첨값 필요 - 랜덤값
        int value = (int)(Math.random() * 6); //0 부터 5까지

        //반복처리 필요
        for (int i = 0; i < 6 ; i++){
            System.out.println("i ------" + i);
            scanner.nextLine();

            if(value == i){
                System.out.println("당첨");
                break;
            }
        }//end for
    }
}

