package com.temi.pencilKata;

import com.temi.pencilkata.pencil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PencilTest {

    /**********************************************************************/
    /*******/                                                      /*******/
    /*******                  INK TESTS                            /*******/
    /*******/                                                      /*******/
    /**********************************************************************/

    @Test
    void testPaperAfterWritingWhenInkIsEnough(){
        pencil myPencil = new pencil(20, 20);
        myPencil.write("I am a nice dude");
        assertEquals("I am a nice dude", myPencil.getPaper() );
    }

    @Test
    void testInkLeftWhenInkIsEnough(){
        pencil myPencil = new pencil(20, 20);
        myPencil.write("i am a nice dude");
        assertEquals(4, myPencil.getInkLeft());
    }

    @Test
    void testInkLeft(){
        pencil myPencil = new pencil(20, 0);
        assertEquals(0, myPencil.getInkLeft());
    }


    @Test
    void testPaperAfterWritingWhenInkIsNotEnough(){
        pencil myPencil = new pencil(10, 10);
        myPencil.write("i am a nice dude");
        assertEquals("i am a nic      ", myPencil.getPaper());
    }

    @Test
    void testPaperAfterWritingWhenThereIsNoInk(){
        pencil myPencil = new pencil(0, 0);
        myPencil.write("hello world");
        assertEquals("           ", myPencil.getPaper());
    }

    @Test
    void testInkLeftAfterWriting(){
        pencil myPencil = new pencil(34, 34);
        myPencil.write("Temitope Jegede");
        assertEquals(17, myPencil.getInkLeft());
    }

    @Test
    void testInkLeftAfterWritingWithNonAlphanumericCharacters(){
        pencil myPencil = new pencil(20, 45);
        myPencil.write("hello: my name, is. temi-tope/ jegede");
        assertEquals(8, myPencil.getInkLeft());
    }

    /**********************************************************************/
    /*******/                                                      /*******/
    /*******                  SHARPENER TESTS                     /*******/
    /*******/                                                      /*******/
    /**********************************************************************/


    @Test
    void testInkLeftAfterSharpening(){
        pencil myPencil = new pencil(20, 34);
        myPencil.write("hello word happy to be here");
        myPencil.sharpen();
        assertEquals(34, myPencil.getInkLeft());
    }

    @Test
    void testLengthAfterSharpening(){
        pencil myPencil = new pencil(20, 34);
        myPencil.write("hello word happy to be here");
        myPencil.sharpen();
        assertEquals(19, myPencil.getLength());
    }

    @Test
    void testLengthAfterSharpeningMultipleTimes(){
        pencil myPencil = new pencil(20, 34);
        myPencil.write("hello word happy to be here");
        myPencil.sharpen();
        myPencil.sharpen();
        myPencil.sharpen();
        myPencil.sharpen();
        myPencil.sharpen();
        assertEquals(15, myPencil.getLength());
    }

    /**********************************************************************/
    /*******/                                                      /*******/
    /*******                  WRITER TESTS                         /*******/
    /*******/                                                      /*******/
    /**********************************************************************/

    @Test
    void testWritingWithNonAlphanumericCharacters(){
        pencil myPencil = new pencil(20, 45);
        myPencil.write("hello: my name, is. temi-tope/ jegede");
        assertEquals("hello: my name, is. temi-tope/ jegede", myPencil.getPaper());
    }


    /**********************************************************************/
    /*******/                                                      /*******/
    /*******                  ERASER TESTS                         /*******/
    /*******/                                                      /*******/
    /**********************************************************************/


    @Test
    void testErasingWord(){
        pencil myPencil = new pencil(20, 45);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals("hello       i am home", myPencil.getPaper());
    }

    @Test
    void testEraserDegradationWhenEraserIsNotEnough(){
        pencil myPencil = new pencil(50, 57, 2);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals("hello wor   i am home", myPencil.getPaper());
    }

    @Test
    void testEraserDurabilityWhenEraserIsNotEnough(){
        pencil myPencil = new pencil(50, 57, 2);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals(0, myPencil.getEraserDurability());
    }

    @Test
    void testEraserDurabilityWhenEraserIsEnough(){
        pencil myPencil = new pencil(50, 57, 23);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals(18, myPencil.getEraserDurability());
    }

    @Test
    void testEraserDurabilityWhenEraserIsEmpty(){
        pencil myPencil = new pencil(50, 57, 0);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals(0, myPencil.getEraserDurability());
    }


}