package org.example.kiosk.order;

import java.util.ArrayList;

//주문을 받는 사람
//주문(Order)에 대한 CRUD 처리하는 존재
public enum OrderService {
    //몇개나 미리 만들것인가
    INSTANCE;

    private ArrayList<Order> orders;

    private OrderService(){
        orders = new ArrayList<>();
    }

    //주문을 받는다(추가한다)
    public void addOrder(Order order){
        orders.add(order);
    }

}
