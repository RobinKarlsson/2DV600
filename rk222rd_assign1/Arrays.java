/*
* Date: 2021-09-10.
* File Name: Arrays.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

/**
* Class containing various array operations
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Arrays {
	/*
	* Return average of elements in arr
	*/
	static int average(int[] arr) {
		int sum = 0;
		
		for(int i: arr) {
			sum += i;
		}
		
		return sum/arr.length;
	}
	
	/*
	* Return greatest element of arr
	*/
	static int max(int[] arr) {
		int max_element = arr[0];
		
		for(int i: arr) {
			if(i > max_element)
				max_element = i;
		}
		
		return max_element;
	}
	
	/*
	* Returns an array with the number n added to 
	* all elements in the array arr
	*/
	static int[] addN(int[] arr, int n) {
		int[] new_arr = arr.clone();
		
		for(int i = 0; i < arr.length; i++) {
			new_arr[i] += n;
		}
		
		return new_arr;
	}
	
	/*
	* Returns an array with the elements of arr in reverse order
	*/
	static int[] reverse(int[] arr) {
		int[] new_arr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			new_arr[i] = arr[arr.length - 1 - i];
		}
		
		return new_arr;
	}
	
	/*
	* Replace all elements equal to old in arr with nw
	*/
	static void replaceAll(int[] arr, int old, int nw) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == old) 
				arr[i] = nw;
		}
	}
	
	/*
	* Returns a new array containing the elements of arr, sorted
	* in ascending order
	*/
	static int[] sort(int[] arr) {
		int min_index, placeholder;
		int[] new_arr = arr.clone();
		
		//for each index of array
		for(int i = 0; i < arr.length; i++) {
			min_index = i;
			
			//search remaining indices for lower valued items
			for(int j = i + 1; j < arr.length; j++) {
				if(new_arr[j] < new_arr[min_index])
					min_index = j;
			}
			
			//switch place with lowest element
			placeholder = new_arr[min_index];
			new_arr[min_index] = new_arr[i];
			new_arr[i] = placeholder;
		}
		
		return new_arr;
	}
	
	/*
	* Check if sub is part of arr
	*/
	static boolean hasSubString(int[] arr, int[] sub) {
		boolean is_substring;
		
		//if sub has more elements than arr
		if(arr.length < sub.length)
			return false;

		for(int i = 0; i <= arr.length - sub.length; i++) {
			if(arr[i] == sub[0]) {
				//possible match
				is_substring = true;
				
				//check next sub.length indices
				for(int j = 1; j < sub.length; j++) {
					if(arr[i + j] != sub[j]) {
						is_substring = false;
						break;
					}
				}

				//match found
				if(is_substring)
					return true;
			}
		}
		return false;
	}
	
	/*
	* Return an array that is the absolute difference 
	* between array arr1 and array arr2
	*/
	static int[] absDif(int[] arr1, int[] arr2) {
		if(arr1.length != arr2.length) {
			throw new ArrayIndexOutOfBoundsException(
					"Arrays need to be of same size!");
		}
		
		int[] new_arr = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			new_arr[i] = Math.abs(arr1[i] - arr2[i]);
		}
		
		return new_arr;
	}
}
