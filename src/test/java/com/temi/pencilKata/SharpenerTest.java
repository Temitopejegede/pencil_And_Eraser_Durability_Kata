package com.temi.pencilKata;

import com.temi.pencilkata.Pencil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SharpenerTest {

    @Test
    void testInkLeftAfterSharpening(){
        Pencil myPencil = new Pencil(20, 34);
        myPencil.write("hello word happy to be here");
        myPencil.sharpen();
        assertEquals(34, myPencil.getInkLeft());
    }

    @Test
    void testLengthAfterSharpening(){
        Pencil myPencil = new Pencil(20, 34);
        myPencil.write("hello word happy to be here");
        myPencil.sharpen();
        assertEquals(19, myPencil.getLength());
    }

    @Test
    void testLengthAfterSharpeningMultipleTimes(){
        Pencil myPencil = new Pencil(20, 34);
        myPencil.write("hello word happy to be here");
        // The DRY principle (or do not repeat yourself) would say to use a for loop here, but I appreciate that you spelled it out. It's good to make tests 'wet' so that we don't do something complicated and have a bad test.
        myPencil.sharpen();
        myPencil.sharpen();
        myPencil.sharpen();
        myPencil.sharpen();
        myPencil.sharpen();
        assertEquals(15, myPencil.getLength());
    }

}
