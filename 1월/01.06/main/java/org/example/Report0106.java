package org.example;

import java.util.Scanner;

public class Report0106 {

    //섭씨온도를 화씨로 변경
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("섭씨화씨 변환");
        System.out.println("사용법: 섭씨를 화씨로 바꾸려면 F, 화씨를 섭씨로 바꾸려면 C, 종료하려면 END를 입력하세요.");

        while(true){

            String str = scanner.nextLine();

            if (str.equals("END")){
                System.out.println("종료");
                break;
            }

            if (str.equals("F")){

                System.out.println("섭씨온도를 입력하세요");
                String c = scanner.nextLine();
                double value = Double.parseDouble(c);

                double f = 1.8 * value + 32;
                System.out.println("섭씨 " + value + " 도 => 화씨 " + f + " 도");
                System.out.println("사용법: 섭씨를 화씨로 바꾸려면 F, 화씨를 섭씨로 바꾸려면 C, 종료하려면 END를 입력하세요.");
                continue;
            }

            if (str.equals("C")) {

                System.out.println("화씨온도를 입력하세요");
                String f = scanner.nextLine();
                double value = Double.parseDouble(f);
                double c = (value - 32) / 1.8;
                System.out.println("화씨 " + c + " 도 => 섭씨 " + value + " 도");
                System.out.println("사용법: 섭씨를 화씨로 바꾸려면 F, 화씨를 섭씨로 바꾸려면 C, 종료하려면 END를 입력하세요.");
                continue;
            }

        }
    }
}
