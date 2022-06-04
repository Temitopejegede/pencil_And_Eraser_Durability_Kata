package com.temi.pencilkata;

public class pencil {
    private int pencilDurability = 10;
    private int inkLeft;
    private int length;
    private int eraserDurability = 5;
    private int eraserLeft = 5;

    private String paper = "";

    public pencil(int length) {
        this.length = length;
        this.inkLeft = length;
    }

    public pencil(int pencilDurability, int length) {
        this.pencilDurability = pencilDurability;
        this.length = length;
        this.inkLeft = length;
    }

    public pencil(int pencilDurability, int length, int eraserDurability) {
        this.pencilDurability = pencilDurability;
        this.length = length;
        this.eraserDurability = eraserDurability;
        this.inkLeft = length;
    }

    public void write(String word){
        if(inkLeft == 0) {
            paper += word.replaceAll("[A-Za-z0-9]", " ");
            return;
        }

        if(inkLeft > 0 && inkLeft >= word.length()){
            char[] ans = word.toCharArray();
            for(char s: ans){
                if(Character.isUpperCase(s)) inkLeft--;
                inkLeft--;
                paper += s;
            }
            return;
        }

        if(inkLeft < word.length()){
            paper+= word.substring(0, inkLeft);
            paper += word.substring(inkLeft).replaceAll("[A-Za-z0-9]", " ");
            inkLeft = 0;
        }
    }

    public void sharpen(){
        if(length == 0) return;
        inkLeft = pencilDurability;
        length--;
    }

    public void erase(){

    }

    public int getPencilDurability() {
        return pencilDurability;
    }

    public void setPencilDurability(int pencilDurability) {
        this.pencilDurability = pencilDurability;
    }

    public int getInkLeft() {
        return inkLeft;
    }

    public void setInkLeft(int inkLeft) {
        this.inkLeft = inkLeft;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getEraserDurability() {
        return eraserDurability;
    }

    public void setEraserDurability(int eraserDurability) {
        this.eraserDurability = eraserDurability;
    }

    public int getEraserLeft() {
        return eraserLeft;
    }

    public void setEraserLeft(int eraserLeft) {
        this.eraserLeft = eraserLeft;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

}
