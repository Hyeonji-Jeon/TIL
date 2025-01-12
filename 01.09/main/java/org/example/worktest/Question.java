package org.example.worktest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Question {

    private int num;
    private String text;
    private int yesIndex;
    private int noIndex;

    public Question(int num, String text, int yesIndex, int noIndex) {
        this.num = num;
        this.text = text;
        this.yesIndex = yesIndex;
        this.noIndex = noIndex;
    }
}
