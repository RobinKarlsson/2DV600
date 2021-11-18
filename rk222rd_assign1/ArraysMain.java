/*
* Date: 2021-09-10.
* File Name: ArraysMain.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

/**
* Demonstration of the array class
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class ArraysMain {
	public static void main(String args[]) {
		int[] arr1 = {3,5,2,4,1,3};
		
		System.out.println("Average of {3,5,2,4,1,3}: " + 
				Arrays.average(arr1));
		
		System.out.println("Greatest element of {3,5,2,4,1,3}: " + 
				Arrays.max(arr1));
		
		System.out.print("Adding 42 to {3,5,2,4,1,3} gives us: {");
		for(int i: Arrays.addN(arr1, 42)) {
			System.out.print(i + ",");
		}
		System.out.println("}");
		
		System.out.print("Reversing the elements of {3,5,2,4,1,3} gives us: {");
		for(int i: Arrays.reverse(arr1)) {
			System.out.print(i + ",");
		}
		System.out.println("}");
		
		System.out.print("Replacing 3 with 6 in {3,5,2,4,1,3} gives us: {");
		Arrays.replaceAll(arr1, 3, 6);
		for(int i: arr1) {
			System.out.print(i + ",");
		}
		System.out.println("}");

		System.out.print("Sorting {6,5,2,4,1,6} gives us: {");
		for(int i: Arrays.sort(arr1)) {
			System.out.print(i + ",");
		}
		System.out.println("}");
		
		int[] arr2 = {1,2,3};
		System.out.println("{1,2,3} is a substring of {6,5,2,4,1,6}? " +
				Arrays.hasSubString(arr1, arr2));
		
		int[] arr3 = {2,4,1,6};
		System.out.println("{2,4,1,6} is a substring of {6,5,2,4,1,6}? " +
				Arrays.hasSubString(arr1, arr3));
		
		int[] arr4 = {6,5,2,4,1,6};
		System.out.println("{6,5,2,4,1,6} is a substring of {6,5,2,4,1,6}? " +
				Arrays.hasSubString(arr1, arr4));
		
		int[] arr5 = {6,5,2,4,1,6,42};
		System.out.println("{6,5,2,4,1,6,42} is a substring of {6,5,2,4,1,6}? " +
				Arrays.hasSubString(arr1, arr5));
		
		System.out.print("Absolute difference between "
				+ "{6,5,2,4,1,6} and {6,5,2,4,1,6}: {");
		for(int i: Arrays.absDif(arr1, arr4)) {
			System.out.print(i + ",");
		}
		System.out.println("}");
		
		int[] arr6 = {42,42,42,42,42,42};
		System.out.print("Absolute difference between "
				+ "{6,5,2,4,1,6} and {42,42,42,42,42,42}: {");
		for(int i: Arrays.absDif(arr1, arr6)) {
			System.out.print(i + ",");
		}
		System.out.println("}");
		
		int[] arr7 = {42};
		System.out.print("Absolute difference between "
				+ "{6,5,2,4,1,6} and {42}: ");
		try {
			for(int i: Arrays.absDif(arr1, arr7)) {
				System.out.print(i + ",");
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}
		
		System.out.println("\nAll done :)");
	}
}
