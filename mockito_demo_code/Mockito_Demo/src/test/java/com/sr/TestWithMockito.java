package com.sr;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.Test;

public class TestWithMockito  {
	 
    @Test
    public void testQuery()  {
 
        //arrange
         Iterator<String> iterator = mock(Iterator.class);
         when(iterator.next()).thenReturn("Hello").thenReturn("World");
         
         //act
         String result =iterator.next() + " " +iterator.next();
         
         //assert
         assertEquals("Hello World", result);
    }
}