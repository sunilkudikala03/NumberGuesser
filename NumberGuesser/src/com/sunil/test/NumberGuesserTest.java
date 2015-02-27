package com.sunil.test;

import java.util.Random;

import org.junit.Test;

import com.sunil.impl.NumberGuesser;

import junit.framework.Assert;
import junit.framework.TestCase;

public class NumberGuesserTest extends TestCase {

	private NumberGuesser guesser;
	public NumberGuesserTest() {
		super();
	}

	public NumberGuesserTest(String name) {
		super(name);
	}
	protected void setUp() throws Exception {
		super.setUp();
		guesser = new NumberGuesser();
	}
		 
	protected void tearDown() throws Exception {
		super.tearDown();
	}
		
	@Test
	public void testNumberGuesser()
	{
		Random numGenerator = new Random();
		Boolean validNumber= false;
		int randomNumber= guesser.getRandonNumber(numGenerator, Integer.valueOf("500"), Integer.valueOf("200"));
		if(randomNumber < 500 && randomNumber>= 200)
			validNumber = true;
		Assert.assertEquals(true, validNumber.booleanValue());
	}
	//More test cases
}
