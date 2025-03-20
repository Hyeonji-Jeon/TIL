package org.example;

import org.example.ex.EX1;
import org.example.menu.*;
import org.example.store.BasicRes;
import org.example.store.BusanRes;
import org.example.store.DaeguRes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)throws Exception {

        List<LottoBall> ballList = new ArrayList<>();  //인터페이스 List

        for (int i = 1; i <= 45 ; i++) {
            ballList.add( new LottoBall(i));
        }

        Collections.shuffle(ballList);

        List<LottoBall> result = ballList.subList(0, 6);

        System.out.println(result);






//        HashMap<String, MenuService> map = new HashMap<>();
//
//        map.put("mega", new MegaMenuService());
//        map.put("compose", new ComposeMenuService());
//
//        MenuService menuService = map.get("mega");




//        String url = "https://www.mega-mgccoffee.com/menu/menu.php?menu_category1=1&menu_category2=1&category=&list_checkbox_all=all";
//        Document doc = Jsoup.connect(url).get();
//        //System.out.println(doc);
//
//        Element element = doc.selectFirst("#menu_list");
//        //System.out.println(element);
//
//        Elements names = element.select(".text1 b");
//        //System.out.println(names);
//
//        List<String> nameList = names.eachText();
//        System.out.println(nameList);




//        Document doc = Jsoup.connect("https://composecoffee.com/menu?amp%3Bcategory=185").get();
//        //System.out.println(doc);
//
//        Element element = doc.selectFirst("#masonry-container");
//        //System.out.println(element);
//
//        Elements names = element.select("h4");
//        //System.out.println(names);
//
//        List<String> nameList = names.eachText();
//
//        System.out.println(nameList);



//        //추상 클래스는 객체 생성 불가
//        //물려주거나 타입으로는 유용
//        Menu m = new Coffee();


//        HashMap<String, BasicRes> resHashMap = new HashMap<>();
//
//                       //키보드
//        resHashMap.put("서울",new BasicRes());
//        resHashMap.put("부산",new BusanRes());
//        resHashMap.put("대구",new DaeguRes());
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("도시를 입력하세요");
//        String city = scanner.nextLine();
//
//        BasicRes target = resHashMap.get(city); //입력받은 city 값에 따라 makeZazang() 값이 달라짐
//
//        target.makeZazang();


//        ArrayList<BasicRes> resList = new ArrayList<>();
//
//        resList.add(new BasicRes());
//        resList.add(new BusanRes());
//        resList.add(new DaeguRes());
//
//        resList.forEach(r -> {
//            r.makeZazang();
//        });

    }
}