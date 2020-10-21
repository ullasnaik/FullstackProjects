package com.sr;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MathServiceImplTest {

	
	@Mock
    MathService mathService;
 
    @InjectMocks
    MathServiceImpl mathServiceImpl = new MathServiceImpl();
    
    @Before
    public void setup() {
    MockitoAnnotations.initMocks(this);
    }
    
    
    
	@Test
	public void test() {
		int ex1 = 36;
		Mockito.when(mathService.square(Mockito.anyInt())).thenReturn(ex1);
		int act1 = mathService.square(6);
		Assert.assertEquals(ex1, act1);
	}

	
}
