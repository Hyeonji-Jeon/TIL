package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("금액을 입력하세요. 한 번당 1000원");

        int money = scanner.nextInt();

        int ticket = money / 1000;        //유지하고 싶은 값은 루프 바깥에 선언.

        for (int j = 0; j < ticket; j++) {

            int[] balls = new int[45];

            int blength = balls.length;  //루프 바깥에 선언해야 좀더 성능이 좋음

            for (int i = 0; i < blength; i++) {
              balls[i] = i + 1;
            }
            //System.out.println(Arrays.toString(balls));

            //임의의 숫자 0부터 44까지 - 6번 뽑기
            for (int i = 0; i < 6; ) {
                int idx = (int) (Math.random() * 45); //임의의 배열내 인덱스 번호

                int value = balls[idx]; //내용물 1~45

                //만일 value == -1이면 continue
                if (value == -1) {
                 //   System.out.println("중복 발생");
                    continue;
                }

                System.out.println(value);

                //출력한 다음에는 -1로 바꾼다.
                balls[idx] = -1;
                i++;
            }

            System.out.println("--------------------");
        }

    }
}
