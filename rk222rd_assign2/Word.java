/*
* Date: 2021-10-04.
* File Name: Word.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

/**
* Word object
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Word implements Comparable<Word> {
	private String word;
	
	public Word(String s) {
		word = s;
	}
	
	public String toString() {
		return word;
	}
	
	public int hashCode() {
		return word.toLowerCase().hashCode();
	}
	
	public boolean equals(Object other) {
		if(!(other instanceof Word))
			return false;
		
		return hashCode() == ((Word) other).hashCode();
	}

	@Override
	public int compareTo(Word o) {
		return word.compareTo(o.toString());
	}
	
}
