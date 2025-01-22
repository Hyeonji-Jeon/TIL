package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //bad code
    public static void main(String[] args) throws Exception{

        String path = "http://mp4.cine21.com/cine21/multi/trailer/a-b/banzi_pre_2.mp4";
        URL url = new URL(path);
        InputStream in = url.openStream();

        //Menu m = new PizzaMenu();
        //InputStream in = new FileInputStream("C:\\zzz\\aaa.jpg");
        OutputStream out = new FileOutputStream("C:\\zzz\\copy.mp4");

        //모든 빨대는 사용후에 닫는다. close
        while(true){

                int data = in.read(); // 1 byte  + 255 음수가 나올 수 없게

                //System.out.println(data);

                if(data == -1){ //더 이상 읽어야 하는 데이터가 없는 경우
                    break;
                }

                out.write(data);

        }//end while

        in.close();
        out.close();
    }
}









