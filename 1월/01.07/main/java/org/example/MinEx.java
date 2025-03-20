package org.example;

public class MinEx {

    public static void main(String[] args) {

        int[] arr = {32,34,22,13,6, -3};

        int min = arr[0];
        int max = arr[0];

        for(int value: arr) {

            //삼항연산자
            min = value < min ? value : min;
            max = value > max ? value : max;

            //value 값이 min 값보다 작으면 min 값은 value
//            if(value < min){
//                min = value;
//            }
//            if(value > max){
//                max = value;
//            }
        }
        System.out.println("MIN :  " + min);
        System.out.println("MAX :  " + max);
    }
}
