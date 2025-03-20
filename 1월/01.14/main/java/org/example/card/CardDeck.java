package org.example.card;

import java.util.ArrayList;
import java.util.Collections;

// CardDeck 클래스는 카드 덱을 관리하는 싱글톤 패턴의 구현임
public enum CardDeck {

    //유일한 인스턴스
    INSTANCE;

    //카드 목록을 저장하는 리스트
    private ArrayList<Card> cards;

    //CardDeck의 생성자
    private CardDeck(){
        this.cards = new ArrayList<>(); //카드 리스트 초기화

        //카드 생성 1~48
        for(CardPattern pattern: CardPattern.values()) {

            for (int i = 1; i <= 12; i++) {

                cards.add(new Card(pattern, i));
            }
        }

        //카드 섞기
        Collections.shuffle(cards);
    }

    //카드를 한 장 뽑기
    public Card getOne(){
        //리스트의 첫 번째 카드를 제거하고 반환
        Card card = cards.remove(0);
        return card;
    }
}
