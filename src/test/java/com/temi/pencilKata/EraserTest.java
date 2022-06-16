package com.temi.pencilKata;

import com.temi.pencilkata.Pencil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EraserTest {


    @Test
    void testErasingWord(){
        Pencil myPencil = new Pencil(20, 45);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals("hello       i am home", myPencil.getPaper());
    }

    @Test
    void testEraserDegradationWhenEraserIsNotEnough(){
        Pencil myPencil = new Pencil(50, 57, 2);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals("hello wor   i am home", myPencil.getPaper());
    }

    @Test
    void testEraserDurabilityWhenEraserIsNotEnough(){
        Pencil myPencil = new Pencil(50, 57, 2);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals(0, myPencil.getEraserDurability());
    }

    @Test
    void testEraserDurabilityWhenEraserIsEnough(){
        Pencil myPencil = new Pencil(50, 57, 23);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals(18, myPencil.getEraserDurability());
    }

    @Test
    void testEraserDurabilityWhenEraserIsEmpty(){
        Pencil myPencil = new Pencil(50, 57, 0);
        myPencil.write("hello world i am home");
        myPencil.erase("world");
        assertEquals(0, myPencil.getEraserDurability());
    }

}
