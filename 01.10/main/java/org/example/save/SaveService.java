package org.example.save;

public class SaveService {

    private int balance;

    public int in(int amount){
        int result = 0;

        this.balance += amount;

        result = this.balance;

        return result;
    }

    public int out() {
        int result = 0;

        return result;
    }


}