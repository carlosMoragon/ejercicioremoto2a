package com.how2java;

import org.testng.annotations.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest{

	@Test
	public void mediaArmonicaTest(){
		assertTrue((int) App.mediaArmonica(Arrays.asList(3.32,4.0,6.43)) == 4);
	}

	@Test
	public void contiene0(){
	
		assertTrue(App.mediaArmonica(Arrays.asList(0.0, 2.5, 52.0)) == 0);
	}
		
	@Test
	public void denominador0(){

		assertTrue(App.mediaArmonica(Arrays.asList(2.5,-2.5,3.0,-3.0)) == 2147483647);
	}

}
