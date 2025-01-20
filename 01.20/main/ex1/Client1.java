package org.example.ex1;

import lombok.Cleanup;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

public class Client1 {

    //bad code
    public static void main(String[] args) throws Exception {

        @Cleanup
        Socket socket = new Socket("127.0.0.1", 5555);
        System.out.println(socket);

        @Cleanup
        InputStream inputStream = socket.getInputStream();

        @Cleanup
        OutputStream outputStream = socket.getOutputStream();

        // 문자열 배열 생성
        //String[] strings = {"apple", "banana", "cherry", "date", "fig"};

        // 배열을 리스트로 변환
        //List<String> stringList = Arrays.asList(strings);

        // 순서 섞기
        //Collections.shuffle(stringList);

        //Random random = new Random();
        //String msg = strings[random.nextInt(strings.length)];

        //String msg = "호민팬티도둑\n";

        System.out.println("아무거나 입력해보세요");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();

        byte[] arr = msg.getBytes();

        outputStream.write(arr);    //얘가 열씸히 써

    }
}
