package com.temi.pencilKata;

import com.temi.pencilkata.Pencil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriterTest {
    @Test
    void testWritingWithNonAlphanumericCharacters(){
        Pencil myPencil = new Pencil(20, 45);
        myPencil.write("hello: my name, is. temi-tope/ jegede");
        assertEquals("hello: my name, is. temi-tope/ jegede", myPencil.getPaper());
    }
}
