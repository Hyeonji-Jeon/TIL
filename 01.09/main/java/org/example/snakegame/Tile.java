package org.example.snakegame;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString

public class Tile {

    private int num;
    private String desc;
    private String type;
    private int moving;

    public Tile(int num) {
        this.num = num;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMoving(int moving) {
        this.moving = moving;
    }

    public int getNum() {
        return num;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public int getMoving() {
        return moving;
    }
}
