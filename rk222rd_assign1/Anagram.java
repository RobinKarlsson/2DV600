/*
* Date: 2021-09-07.
* File Name: Anagram.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
* Reads a word from the keyboard and prints all anagrams 
* of that word contained in the wordlist file
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Anagram {
	public static void main(String args[]) {
		//read wordlist
		ArrayList<String> data = readFile("wordlist");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a word to find anagrams of: ");
		String word = sc.next();
		sc.close();
		
		for(String s: data) {
			if(isAnagram(word, s)) {
				System.out.println(s);
			}
		}
		
	}
	
	/*
	* Check if two strings are anagram to each others
	*/
	private static boolean isAnagram(String s1, String s2) {
		char [] ch1 = s1.toCharArray();
		char [] ch2 = s2.toCharArray();
		
		//ensure equal number of characters
		if(ch1.length == ch2.length) {
			//sort arrays
			Arrays.sort(ch1);
			Arrays.sort(ch2);

			//compare elements of arrays
			for(int i = 0; i < ch1.length; i++) {
				if(ch1[i] != ch2[i]) {
					return false;
				}
			}
			
			//all elements equal -> anagram
			return true;
		}
		
		return false;
	}
	
	/*
	* Read content of file into an ArrayList
	*/
	private static ArrayList<String> readFile(String file) {
		ArrayList<String> data = new ArrayList<>();
		
		Scanner sc;
		try {
			sc = new Scanner(new FileReader(file));
			
			while(sc.hasNext()) {
				data.add(sc.nextLine());
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(file + " does not exist!");
			System.exit(0);
		}
		
		return data;
	}
}
