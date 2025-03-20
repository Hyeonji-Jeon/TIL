package org.example.kiosk.menu;

import java.util.ArrayList;

public enum MenuService {

    INSTANCE;                                //4번

    private ArrayList<Menu> menus;           //2번

    //초기화
    private MenuService() {                  //3번
        this.menus = new ArrayList<>();      //5번
        menus.add(new Menu(1, "Americano", 3000));
        menus.add(new Menu(2, "Latte", 3500));
        menus.add(new Menu(3, "Cappuccino", 4000));
        menus.add(new Menu(4, "Espresso", 2500));
    }


    public ArrayList<Menu> getList(){       //1번
        return menus;
    }


}