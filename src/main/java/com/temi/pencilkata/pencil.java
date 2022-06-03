package com.temi.pencilkata;

public class pencil {
    private int pencilDurability = 10;
    private int inkLeft;
    private int length;
    private int eraserDurability = 5;
    private int eraserLeft;

    private String paper;

    public pencil(int length) {
        this.length = length;
    }

    public pencil(int pencilDurability, int length) {
        this.pencilDurability = pencilDurability;
        this.length = length;
    }

    public pencil(int pencilDurability, int length, int eraserDurability) {
        this.pencilDurability = pencilDurability;
        this.length = length;
        this.eraserDurability = eraserDurability;
    }



}
