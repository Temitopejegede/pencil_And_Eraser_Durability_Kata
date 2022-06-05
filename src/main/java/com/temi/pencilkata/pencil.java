package com.temi.pencilkata;

/**
 * A kata prohect to practice Test Driven Development(TDD) by mimicking how the
 * functionalities of a pencil, eraser, and paper.
 */
public class pencil {
    /**
     * An integer that sets the default durability of the pencil to 10.
     * The durability of the pencil how long it can write without needing to be sharpened
     */
    private int pencilDurability = 10;

    /**
     * An integer that stores how much ink is left in the pencil.
     * This variable is always initially set the pencil durability.
     * When the pencil is sharpened, this value returns to pencil durability
     * When a lowercase letter, a number, or a symbol is written this value goes down by 1
     * When an uppercase letter is written, this value goes down by 2
     */
    private int inkLeft;

    /**
     * An integer value that represents how many times a pencil can be sharpened before it wears out
     * The longer the pencil (the higher the number) the more times it can be sharpened
     * This value can never go up. It only goes down
     */
    private int length;

    /**
     * An integer value that represents how many characters the eraser can clean off.
     * This value does not change once the pencil object has been created
     * The default value is set to five.
     */
    private int eraserDurability = 5;

    /**
     * An integer value that represents how many more characters can be erased before the eraser is finished
     * The value of this variable always starts as the eraserDurability.
     * The value of this variable goes down 1 for each character it erases irrespective of its case
     */
    private int eraserLeft = 5;

    /**
     * A string value that stores all the words written by the pencil.
     */
    private String paper = "";

    /**
     * A constructor that creates the pencil object with a custom length value but all other
     * variables are set to the default
     * @param length the amount of times the pencil can be sharpened before it wears out.
     *               This value goes down 1 each time the pencil is sharpened
     */
    public pencil(int length) {
        this.length = length;
        this.inkLeft = pencilDurability;
    }

    /**
     * A constructor that creates the pencil object with a custom value for length and pencilDurability
     * and all other values are set to the default
     * @param length the amount of times the pencil can be sharpened before it wears out.
     *               This value goes down 1 each time the pencil is sharpened
     * @param pencilDurability this is the amount of characters that can be written with the pencil
     *                         before it needs to be sharpened.
     *                         This goes down 1 for every lower case character, any number, or symbol.
     *                         This goes down 2 for every upper case character.
     *                         The value is unchanged if there is a space between words or a new line is printed.
     */
    public pencil(int length, int pencilDurability) {
        this.pencilDurability = pencilDurability;
        this.length = length;
        this.inkLeft = pencilDurability;
    }

    /**
     * A constructor that creates a pencil object with a custom value for pencilDurability, length, and
     * eraserDurability each. Every other variable is set to its default value
     * @param pencilDurability this is the amount of characters that can be written with the pencil
     *                         before it needs to be sharpened.
     *                         This goes down 1 for every lower case character, any number, or symbol.
     *                         This goes down 2 for every upper case character.
     *                         The value is unchanged if there is a space between words or a new line is printed.
     *
     * @param length the amount of times the pencil can be sharpened before it wears out.
     *               This value goes down 1 each time the pencil is sharpened
     *
     * @param eraserDurability this is the amount of characters the eraser can clean off before is no longer usable
     *                         The value of this variable goes down for every character it erases irrespective
     *                         of its case.
     */
    public pencil(int pencilDurability, int length, int eraserDurability) {
        this.pencilDurability = pencilDurability;
        this.length = length;
        this.eraserDurability = eraserDurability;
        this.inkLeft = pencilDurability;
    }

    /**
     *
     * @param word
     */
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

    /**
     *
     */
    public void sharpen(){
        if(length == 0) return;
        inkLeft = pencilDurability;
        length--;
    }

    /**
     *
     * @param word
     */
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

    /**
     *
     * @param word
     */
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
            int k = 0;
            for(int j = i; j < i+word.length();j++){
                if(paper.charAt(j) == ' ' && Character.isLetterOrDigit(paper.charAt(j+1))){
                    wordBuilder.setCharAt(j, '@');
                }
                else{
                    wordBuilder.setCharAt(j, word.charAt(k));
                }
                k++;
            }
            paper = wordBuilder.toString();
        }

    }

    /**
     *
     * @return
     */
    public int getBeginningOfEmptySpace(){
        int i;
        for(i = 0; i<= paper.length() - 2; i++){
            if(paper.charAt(i) == ' ' && paper.charAt(i+1) == ' '){
                break;
            }
        }

        return i+1;
    }

    /**
     *
     * @return
     */
    public int getHowMuchEmptySpaceThereIs(){
        int start = getBeginningOfEmptySpace();
        int count = 1;
        while(paper.charAt(start+1) == ' '){
            if(start == paper.length()-2) break;
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
