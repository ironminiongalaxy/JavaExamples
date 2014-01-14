package com.dj.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class Sample1Test {

	@Test
	public void testallUnique() {
		assertFalse(Sample1.allUnique("apple"));
		assertTrue(Sample1.allUnique("aple"));
		
	}

}
