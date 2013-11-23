package com.dj.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSamplesTest {

	@Test
	public void testallUnique() {
		assertFalse(StringSamples.allUnique("apple"));
		assertTrue(StringSamples.allUnique("aple"));
		
	}

}
