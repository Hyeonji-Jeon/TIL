package org.example;

public class MoneyBank {

    public static void main(String[] args) {

        double money = 100;
        double rate = 0.02; //2 %의 금리

        //10년 가치
        for (int i = 0; i < 10; i++) {

            double interest = money * rate;

            money = money + interest;

            System.out.println("  " + money);

        }
    }
}
