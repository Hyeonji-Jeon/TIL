package org.example;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy3 {

    //bad code
    public static void main(String[] args) throws Exception {

        @Cleanup
        InputStream fin = new FileInputStream("C:\\zzz\\test.txt");

        byte[] buffer = new byte[5]; //임시로 저장해놓음

        @Cleanup
        OutputStream fos = new FileOutputStream("copy.txt");

        while(true){

            int count = fin.read(buffer); //계란판을 이용한 읽기 => 한번에 5개를 읽음

            if(count == -1){
                break;
            }

            fos.write(buffer, 0, count);   // 맨처음(0)부터, 새롭게 채워진 숫자만큼만 써라

        }//end while

    }
}
