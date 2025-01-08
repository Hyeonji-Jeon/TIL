package org.example;

import org.example.knn.Point;
import org.example.lotto.LottoBall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

//    public static double calcDistance(Point p1, Point p2){
//
//        double result = 0;
//
//        result = Math.sqrt(
//                Math.pow(p1.xpos - p2.xpos, 2) +
//                        Math.pow(p1.ypos - p2.ypos, 2)
//        );
//
//        return result;
//
//    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("금액을 입력하세요. 한 번당 1000원");

        int money = scanner.nextInt();
        int ticket = money / 1000;

            ArrayList<LottoBall> balls = new ArrayList<>();

            for (int i = 1; i <= 45; i++) {

                balls.add(new LottoBall(i));
            }

            for (int i = 0; i < ticket; i++) {

                Collections.shuffle(balls);
                System.out.println(balls.subList(0, 6));
                System.out.println("-------------------------");
                System.out.println(balls.size());
            }



    }
}
