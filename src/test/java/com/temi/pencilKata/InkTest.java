package com.temi.pencilKata;

import com.temi.pencilkata.Pencil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InkTest {
    @Test
    void testPaperAfterWritingWhenInkIsEnough(){
        Pencil myPencil = new Pencil(20, 20);
        myPencil.write("I am a nice dude");
        assertEquals("I am a nice dude", myPencil.getPaper() );
    }

    @Test
    void testInkLeftWhenInkIsEnough(){
        Pencil myPencil = new Pencil(20, 20);
        myPencil.write("i am a nice dude");
        assertEquals(4, myPencil.getInkLeft());
    }

    @Test
    void testInkLeft(){
        Pencil myPencil = new Pencil(20, 0);
        assertEquals(0, myPencil.getInkLeft());
    }

    @Test
    void testPaperAfterWritingWhenInkIsNotEnough(){
        Pencil myPencil = new Pencil(10, 10);
        myPencil.write("i am a nice dude");
        assertEquals("i am a nic      ", myPencil.getPaper());
    }

    @Test
    void testPaperAfterWritingWhenThereIsNoInk(){
        Pencil myPencil = new Pencil(0, 0);
        myPencil.write("hello world");
        assertEquals("           ", myPencil.getPaper());
    }

    @Test
    void testInkLeftAfterWriting(){
        Pencil myPencil = new Pencil(34, 34);
        myPencil.write("Temitope Jegede");
        assertEquals(17, myPencil.getInkLeft());
    }

    @Test
    void testInkLeftAfterWritingWithNonAlphanumericCharacters(){
        Pencil myPencil = new Pencil(20, 45);
        myPencil.write("hello: my name, is. temi-tope/ jegede");
        assertEquals(8, myPencil.getInkLeft());
    }

}
