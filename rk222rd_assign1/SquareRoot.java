/*
* Date: 2021-09-06.
* File Name: SquareRoot.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

import java.util.Scanner;

/**
* Estimate square root of a number by the Babylonian algorithm
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class SquareRoot {
	public static void main(String args[]) {
		System.out.print("This program estimate square roots.\n"
				+ "Enter an integer to estimate the square root of: ");
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		
		double result = babylonianAlg(number);
		System.out.printf("The estimated square root of 25 is %.2f", result);
	}
	
	/*
	* Calculate square root of a number by Babylonian algorithm
	*/
	private static double babylonianAlg(double number) {
		double guess = number / 2;
		double guess_previous = number;
		byte threshold = 1;
		int difference;
		
		//iterate until within threshold % error
		do {
			guess = (guess + number / guess) / 2;
			difference = (int) ((guess_previous - guess) * 100);
			guess_previous = guess;
			
			System.out.println("Current guess: " + guess);
			
		} while(difference > threshold);
		
		return guess;
	}
}
