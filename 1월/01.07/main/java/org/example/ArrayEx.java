package org.example;

public class ArrayEx {

    public static void main(String[] args) {

        int[] arr = {10,30,24,32,42,15};

        //length = 6
        //인덱스 번호 = 0,1,2,3,4,5
        for (int i = 0; i < arr.length; i++) {

           int value = arr[i];
            System.out.println(value);

        }//end for

        System.out.println("------------------------");

        for(int value : arr) {
            System.out.println(value);
        }

    }
}
