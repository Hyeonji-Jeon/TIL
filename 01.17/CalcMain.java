package org.example;

import org.example.transfer.BusTMoney;
import org.example.transfer.CarTMoney;
import org.example.transfer.KTXTMoney;
import org.example.transfer.TMoney;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalcMain {

    public static void main(String[] args) {

        Map<String, TMoney> tmap = new HashMap<>();
        tmap.put("1", new CarTMoney());
        tmap.put("2", new KTXTMoney(30000,50));
        tmap.put("3", new BusTMoney(10000,10,40000));



        Scanner scanner = new Scanner(System.in);

        System.out.println("거리를 입력하세요");

        int distance = Integer.parseInt(scanner.nextLine());

        System.out.println("1.자동차, 2.KTX, 3.고속버스");

        String choice = scanner.nextLine();

        TMoney transfer = tmap.get(choice);

        System.out.println(transfer.calc(distance));


//        if(choice.equals("1")){
//
//            int money = distance * 130;
//
//            System.out.println(money);
//
//        }else if(choice.equals("2")){
//
//            int defaultMoney = 30000;
//
//            int money = defaultMoney + (distance * 50);
//
//            System.out.println(money);
//
//        }else if(choice.equals("3")){
//
//            int defaultMoney = 10000;
//            int toolPay = 40000;
//            int money = defaultMoney + toolPay + (distance * 10);
//
//            System.out.println(money);
//        }


    }
}
