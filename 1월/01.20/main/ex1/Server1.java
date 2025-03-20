package org.example.ex1;

import lombok.Cleanup;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    //bad code
    public static void main(String[] args) throws Exception {

        //5555번으로 가게 열기 - 실전화 연결
        //연결 먼저 해야 하니까 Sever1 먼저 실행함
        @Cleanup    //close 하기 귀찮아서
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server Opened...");

        for (int i = 0; i < 100; i++) {
            @Cleanup
            Socket clientSocket = serverSocket.accept();    //Socket이 실전화에서 종이컵 역할
            System.out.println(clientSocket);

            @Cleanup
            InputStream inputStream = clientSocket.getInputStream();

            @Cleanup
            Scanner inScanner = new Scanner(inputStream);   //얘가 읽어

            String line = inScanner.nextLine();

            System.out.println(line);
        }
    }
}
