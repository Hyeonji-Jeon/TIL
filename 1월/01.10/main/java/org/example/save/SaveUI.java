package org.example.save;

import java.util.Scanner;

public class SaveUI {

    private SaveService service;
    private Scanner scanner;

    public SaveUI(){
        this.service = new SaveService();
        this.scanner = new Scanner(System.in);
    }


    public void doJob(){

        outer:
        while(true){

            //입금 1, 출금 2
            System.out.println("1.입금, 2.출금, -1:종료");
            //입력 받아야 하니까..
            //사용자 입력한 결정을 oper라는 변수에 담았다.
            String oper = scanner.nextLine();

            switch (oper){
                case "1":
                    System.out.println("얼마를 입금?");
                    int value = Integer.parseInt(scanner.nextLine());

                    int current = this.service.in(value);
                    System.out.println("현재 잔고는: " + current);

                    break;
                case "2":
                    break;
                case "-1":
                    break outer;
            }
        }//while


    }
}
