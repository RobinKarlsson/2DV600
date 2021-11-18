/*
* Date: 2021-09-06.
* File Name: ArmstrongNumber.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

import java.util.Scanner;

/**
* Prints Armstrong numbers in a range
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class ArmstrongNumber {
	public static void main(String args[]) {
		int start;
		int end;
		String run_again = null;
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Enter the starting number of the range: ");
			start = sc.nextInt();
			System.out.print("Enter the ending number of the range: ");
			end = sc.nextInt();
			
			System.out.println("\nThe Armstrong numbers between the given range are:");
			
			for(int i = start; i < end; i++) {
				if(isArmstrong(i)) {
					System.out.println(i);
				}
			}
			
			System.out.print("Do you want to repeat? (Y/N): ");
			run_again = sc.next();
		} while(run_again.equals("Y"));
		
		sc.close();
	}
	
	/*
	* Check if an integer is Armstrong
	*/
	private static boolean isArmstrong(int number) {
		int digit;
		int number_backup = number;
		int sum = 0; //store sum of digits
		int number_digits = String.valueOf(number).length();
		
		while(number > 0) {
			digit = number % 10;
			sum += Math.pow(digit, number_digits);
			number /= 10;
		}

		return number_backup == sum;
	}
}
