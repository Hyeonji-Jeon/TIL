package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] arr = new int[3];

        int[] arr2 = arr;

        arr[0] = 5;
        arr[1] = 10;
        arr[2] = 20;

        System.out.println(arr.length);

        System.out.println(arr[1]);
        System.out.println(arr2[1]);


        //배열의 내용물 보기
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }
}