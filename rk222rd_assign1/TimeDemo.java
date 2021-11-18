/*
* Date: 2021-09-10.
* File Name: TimeDemo.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

import java.util.Scanner;

/**
* Testing the Time class
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class TimeDemo {
	public static void main(String args[]) {
		Time timeA = new Time(55+60*59);
		System.out.println("Initial time: " + timeA.toString());
		
		for(int i = 1; i <= 10; i++) {
			timeA.tick();
			System.out.println("Time after " + i + " tick: " + 
					timeA.toString());
		}
		
		Scanner sc = new Scanner(System.in);

		System.out.print("\nCreating new Time object\nEnter hour: ");
		byte hour = (byte) (sc.nextInt() % 24);
		
		System.out.print("Enter minute: ");
		byte minute = (byte) (sc.nextInt() % 60);
		
		System.out.print("Enter second: ");
		byte second = (byte) (sc.nextInt() % 60);
		
		sc.close();
		
		Time timeB = new Time(hour, minute, second);
		
		for(int i = 1; i <= 10; i++) {
			timeA.tick();
			System.out.println("Time after " + i + " tick: " + 
					timeA.toString());
		}
		
		System.out.println("\nAdding " + timeB.toString() + " and " + 
				timeA.toString() + " gives us: " + 
				timeB.addTime(timeA).toString());

		Time timeC = timeA.subtracTime(timeB);
		System.out.println("Difference between " + timeA.toString() + 
				" and " + timeB.toString() + " is: " +
				timeC.toString());
	}
}
