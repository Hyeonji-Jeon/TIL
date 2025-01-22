package org.example;

import lombok.Cleanup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyCopy {

    //bad code
    public static void main(String[] args) throws Exception {

        InputStream in = System.in;

        @Cleanup  //close 해줘야 하는 코드들은 전부 클린업
        OutputStream fos = new FileOutputStream("C:\\zzz\\input.txt");

        System.out.println("한글을 입력해 보세요");

        for (int i = 0; i < 10; i++) {

            //read를 하면 1byte가 나옴
            int data = in.read(); //1byte의 내용물

            System.out.println(data);

            fos.write(data);
        }
    }
}
