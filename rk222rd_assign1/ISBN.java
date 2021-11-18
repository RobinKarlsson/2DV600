
/*
* Date: 2021-09-05.
* File Name: ISBN.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

import java.util.Scanner; 

/**
* Prompts the user to enter the first 9 ISBN digits and displays the 10-digit ISBN
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class ISBN {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		int input = sc.nextInt();
		sc.close();

		//get ISBN-10 string representation of input
		String isbn = calcISBN10(input);
		
		System.out.println("The ISBN-10 number is: " + isbn);
	}
	
	/*
	* Get ISBN-10 representation from a integer
	*/
	private static String calcISBN10(int number) {
		int d10 = 0;
		int digit;
		String isbn10 = "";
		
		//calculate the 10:th digit by ISBN-10 convention
		for(int i = 1; i < 10; i++) {
			//get digit at position i
			digit = number % 10;
			number /= 10;
			
			
			//add digit to isbn10 string
			isbn10 = digit + isbn10;
			
			//add to 10th digit sum
			d10 += digit * (10 - i);
		}
		
		d10 = d10 % 11;
		
		//add 10th digit to isbn10 string
		if(d10 == 10) {
			isbn10 += "X";
		} else {
			isbn10 += d10;
		}
		
		return isbn10;
	}
}
