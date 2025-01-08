package org.example.snake;

public class Tile {

    public int tile; // 타일 번호
    public boolean snake; // 뱀이 있는지 없는지
    public int snaketo; // 뱀을 타고 가는 타일 번호
    public boolean ladder; // 사다리가 있는지 없는지
    public int ladderto; // 사다리 타고 가는 타일 번호


    public Tile(int tile, boolean snake, int snaketo, boolean ladder, int ladderto) {
        this.tile = tile;
        this.snake = snake;
        this.snaketo = snaketo;
        this.ladder = ladder;
        this.ladderto = ladderto;
    }
}
