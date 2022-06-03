package com.temi.pencilkata;

public class pencil {
    private int pencilDurability = 10;
    private int inkLeft;
    private int length;
    private int eraserDurability = 5;
    private int eraserLeft = 5;

    private String paper;

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
        if(inkLeft == 0) paper += word.replaceAll("a-zA-z0-9", " ");

        else if(inkLeft > 0 && inkLeft >= word.length()){
            char[] ans = word.toCharArray();
            for(char s: ans){
                if(Character.isUpperCase(s)){
                    inkLeft -= 2;
                } else inkLeft--;
                paper += s;
            }
        }

        else if(inkLeft < word.length()){
            paper+= word.substring(0, inkLeft -1);
            paper += word.substring(inkLeft).replaceAll("a-zA-Z0-9", " ");
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


}
