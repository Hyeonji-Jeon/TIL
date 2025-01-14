package org.example.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//필수적인 데이터(패턴과 숫자는 모든 카드에 필요하잖아)는 생성자가 필요함
@AllArgsConstructor
@Getter
@ToString
public class Card {

    private CardPattern pattern;
    private int num;

}
