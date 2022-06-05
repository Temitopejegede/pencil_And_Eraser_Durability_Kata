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
        this.inkLeft = pencilDurability;
    }

    public pencil(int length, int pencilDurability) {
        this.pencilDurability = pencilDurability;
        this.length = length;
        this.inkLeft = pencilDurability;
    }

    public pencil(int pencilDurability, int length, int eraserDurability) {
        this.pencilDurability = pencilDurability;
        this.length = length;
        this.eraserDurability = eraserDurability;
        this.inkLeft = pencilDurability;
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

    public void erase(String word){

        if(eraserDurability == 0) return;

        if(eraserDurability > 0 && eraserDurability < word.length()){
            word = word.substring(word.length() - eraserDurability);
            String a = "";
            for(char s: word.toCharArray()) a+= " ";
            paper = paper.replace(paper.substring(paper.lastIndexOf(word), paper.lastIndexOf(word)+ word.length()), a);
            eraserDurability = 0;
            return;
        }

        if(eraserDurability >= word.length()){
            String a = "";
            for(char s: word.toCharArray()) a += " ";

            paper = paper.replace(paper.substring(paper.lastIndexOf(word), paper.lastIndexOf(word)+ word.length()), a);
            eraserDurability = eraserDurability - word.length();
        }

    }

    public void editPaper(String word){
        int i = getBeginningOfEmptySpace();
        if(i == paper.length() - 1) return;
        int count = getHowMuchEmptySpaceThereIs();

        StringBuilder wordBuilder = new StringBuilder();
        wordBuilder.append(paper);

        if(count >= word.length()){
            int k = 0;
            for(int j = i; j < i + count;j++ ){
                wordBuilder.setCharAt(j, word.charAt(k));
                if(k == word.length() - 1) break;
                k++;
            }
            paper = wordBuilder.toString();
        }


        if(count < word.length()){

        }

    }

    public int getBeginningOfEmptySpace(){
        int i;
        for(i = 0; i<= paper.length() - 2; i++){
            if(paper.charAt(i) == ' ' && paper.charAt(i+1) == ' '){
                break;
            }
        }

        return i+1;
    }

    public int getHowMuchEmptySpaceThereIs(){
        int start = getBeginningOfEmptySpace();
        int count = 1;
        while(paper.charAt(start+1) == ' '){
            count++;
            start++;
        }
        return count - 1;
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
