package com.temi.pencilKata;

import com.temi.pencilkata.Pencil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorTest {
    @Test
    void testWhereTheEmptySpaceIs(){
        Pencil myPencil = new Pencil(50, 57, 0);
        myPencil.write("hello       i am home");
        assertEquals(6, myPencil.getBeginningOfEmptySpace());
    }

    @Test
    void IfThereIsNoEmptySpace(){
        Pencil myPencil = new Pencil(50, 57, 0);
        myPencil.write("An onion a day keeps the doctor away");
        assertEquals(36, myPencil.getBeginningOfEmptySpace());
    }

    @Test
    void testHowMuchEmptySpaceThereIs(){
        Pencil myPencil = new Pencil(50, 57, 0);
        myPencil.write("hello       i am home");
        assertEquals(5, myPencil.getHowMuchEmptySpaceThereIs());
    }

    @Test
    void testEditingWhenThereIsEnoughSpace(){
        Pencil myPencil = new Pencil(50, 57, 0);
        myPencil.write("An       a day keeps the doctor away");
        myPencil.editPaper("onion");
        assertEquals("An onion a day keeps the doctor away", myPencil.getPaper());
    }

    @Test
    void testEditingWhenThereIsMoreThanEnoughSpace(){
        Pencil myPencil = new Pencil(50, 57, 0);
        myPencil.write("hello            i am home");
        myPencil.editPaper("world");
        assertEquals("hello world      i am home", myPencil.getPaper());
    }

    @Test
    void testEditingWhenThereIsNotEnoughSpace(){
        Pencil myPencil = new Pencil(50, 57, 0);
        myPencil.write("An       a day keeps the doctor away");
        myPencil.editPaper("artichoke");
        assertEquals("An artich@k@ay keeps the doctor away", myPencil.getPaper());
    }
}
