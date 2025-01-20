package org.example;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy2 {

    //try ~ catch ~ finally
    public static void main(String[] args) throws Exception {

        @Cleanup
        InputStream fin = new FileInputStream(("C:\\zzz\\aaa.jpg"));
        @Cleanup
        OutputStream out = new FileOutputStream("C:\\zzz\\copy.jpg");

        while (true) {

            int data = fin.read(); // 1 byte  + 255 음수가 나올 수 없게

            //System.out.println(data);

            if (data == -1) { //더 이상 읽어야 하는 데이터가 없는 경우
                break;
            }

            out.write(data);

            System.out.println(fin);
        }
    }

}