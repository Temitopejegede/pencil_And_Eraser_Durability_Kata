package com.temi.pencilKata;

import com.temi.pencilkata.pencil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PencilTest {

    @Test
    void testPaperAfterWritingWhenInkIsEnough(){
        pencil myPencil = new pencil(20);
        myPencil.write("I am a nice dude");
        assertEquals("I am a nice dude", myPencil.getPaper() );
    }

    @Test
    void testInkLeftWhenInkIsEnough(){
        pencil myPencil = new pencil(20);
        myPencil.write("i am a nice dude");
        assertEquals(4, myPencil.getInkLeft());
    }

    @Test
    void testInkLeft(){
        pencil myPencil = new pencil(0);
        assertEquals(0, myPencil.getInkLeft());
    }


    @Test
    void testPaperAfterWritingWhenInkIsNotEnough(){
        pencil myPencil = new pencil(10);
        myPencil.write("i am a nice dude");
        assertEquals("i am a nic      ", myPencil.getPaper());
    }

    @Test
    void testPaperAfterWritingWhenThereIsNoInk(){
        pencil myPencil = new pencil(0);
        myPencil.write("hello world");
        assertEquals("           ", myPencil.getPaper());
    }

    @Test
    void testInkLeftAfterWriting(){
        pencil myPencil = new pencil(34);
        myPencil.write("Temitope Jegede");
        assertEquals(17, myPencil.getInkLeft());
    }




}