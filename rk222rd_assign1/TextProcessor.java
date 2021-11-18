/*
* Date: 2021-09-06.
* File Name: TextProcessor.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

import java.util.Scanner;

/**
* Process a line of text from keyboard by
* - Replace every alphabetic letter in the text with the letter 
* 	following it in the alphabet
* - Capitalize every vowel in the output
* - Characters other than letters remain unchanged.
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class TextProcessor {
	public static void main(String args[]) {
		String processed = ""; //processed string
		char [] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Type a line of text: ");
		String input = sc.nextLine();
		sc.close();

		//for each character in input string
		for(char ch: input.toCharArray()) {
			
			if(Character.isLetter(ch)) {
				if(ch == 'z' || ch == 'Z') {
					ch = 'A';
				}
				
				//increment character
				else {
					ch++;
					
					//capitalize vowels
					for(char vowel : vowels) {
						if(ch == vowel) {
							ch = Character.toUpperCase(ch);
						}
					}
				}
			}
			
			processed += ch;
		}
		
		System.out.println("After Processing: " + processed);
	}
}
