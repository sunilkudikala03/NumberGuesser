/**
 * 
 */
package com.sunil.impl;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Sunil Kudikala
 *
 */
/*
 * Assumptions Maximum and Minimum Value 1000 and 0
 * Below Java program works as follows -
 * The user chooses a number in his mind and types “ready” to indicate to the computer that he is ready to begin playing.
The computer asks a series of questions to arrive at the number the user has in mind. The user can only respond with “higher”, “lower” or “yes”.
The game ends when the user responds with “yes” or “end”.
Eg: user chosen value  999 
	1) the system generates 728
  		user chosen value 999 is higher than 728 so print "higher"
    2) if the system generates 980 
    User chosen value is greater than 980 so print "higher"
 */
public class NumberGuesser {

	//Max number Assumption
	private static final int MAX_INT = 1000;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberGuesser numGame = new NumberGuesser();

		Scanner inputStr = new Scanner(System.in);
		System.out
				.println("Type the string 'Ready' to start the game and Press Enter :");
		String result = numGame.startGame(inputStr.nextLine());
		System.out.println("Result  :" + result);
	}

	/*
	 * Generates Random number for the given range
	 */
	public static int getRandonNumber(Random generator, int higher, int lower)
	{
		return generator.nextInt(higher - lower + 1) + lower;
	}
	
	/*
	 * Gets userInput higher or lower or yes/end
	 */
	public static String getUserResp(Scanner userResponse)
	{
		return userResponse.nextLine();
	}
	
	/*
	 * Executes logic based on userresponse and return result
	 */
	public String startGame(String readyStr)
	{
		 int higher = MAX_INT;
		//Min number Assumption
		 int lower  = 1;
		String userResp;
		try{
			if(readyStr != null && readyStr.trim().equalsIgnoreCase("ready"))
		    {
		    	Random numGenerator = new Random();
		    	int num = numGenerator.nextInt(MAX_INT);
		    	System.out.println("Is this number higher or lower than guessed number  " + num +"?");
		    	Scanner userResponse = new Scanner(System.in);
		    	userResp = userResponse.nextLine();
		    	 if(userResp != null && !userResp.isEmpty())
		    	 {
		    		 int num2 =0;
		    		 while(!(userResp.trim().equalsIgnoreCase("yes") || userResp.trim().equalsIgnoreCase("end"))){
		    			 if( userResp.trim().equalsIgnoreCase("higher"))
				    	 {
		    				 higher = num;
		    				 num2 = getRandonNumber(numGenerator, higher, lower);
				    		
				    	 }else
			    		 if(userResp.trim().equalsIgnoreCase("lower"))
				    	 {
			    			 lower = num;
			    			 num2 = getRandonNumber(numGenerator, higher, lower);
				    	 }
			    		 System.out.println("Is this number higher or lower than guessed number "+ num2  +" ? " + "\n" +"print higher or lower or yes and press Enter :");
		    			 userResp = getUserResp(userResponse);
		    			 num = num2;
		    		 }
		    		 System.out.println("Guessed number "+ num);
		    		 return "Matched";
		    	 }
		    }else
		    {
		    	System.out.println("Please rerun the application and enter ready string");
		    }
		}catch (IllegalArgumentException err) {
			System.out.println("IllegalArgumentException occured in startGame method  " + err.getMessage());
		}catch(Exception err1)
		{
			System.out.println("UnKnown Exception occured in startGame method  " + err1.getMessage());
		}
		  
		return "Retry";
	}
}
