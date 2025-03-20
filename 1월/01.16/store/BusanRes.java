package org.example.store;

public class BusanRes extends BasicRes{

    public void makeGanZZ(){
        System.out.println("계란후라이 있는 간짜장");
    }

    @Override
    public void makeZazang() {
        makeGanZZ();
    }
}
