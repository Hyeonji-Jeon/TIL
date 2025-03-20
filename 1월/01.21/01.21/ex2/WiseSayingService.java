package org.example.ex2;

public enum WiseSayingService {

    INSTANCE;

    private String [] sentences;

    private WiseSayingService(){
        sentences = new String[5];
        sentences[0] = "삶은 10%는 내가 겪는 일이지만, 90%는 내가 그것에 어떻게 반응하느냐에 달려 있다.";
        sentences[1] = "성공은 실패를 거듭하면서도 열정을 잃지 않는 데 있다.";
        sentences[2] = "행동이 모든 두려움을 정복한다.";
        sentences[3] = "너의 시간이 제한되어 있다는 것을 기억하라. 그러니 다른 사람의 삶을 사느라 낭비하지 마라.";
        sentences[4] = "작은 일이라도 꾸준히 하다 보면 큰 변화를 가져올 수 있다.";
    }

    public String getOne(){
        int idx = (int)(Math.random()*5); //0,1,2,3,4
        return sentences [idx];

    }

}
