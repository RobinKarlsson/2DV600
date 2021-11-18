/*
* Date: 2021-10-04.
* File Name: Character.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

/**
* Character object
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Character {
	protected String name;
	protected CharacterClasses character_class;
	protected int level;
	protected Attributes attributes;
	
	public Character (String name, CharacterClasses character_class, 
			int level) {
		this.name = name;
		this.character_class = character_class;
		this.level = level;
		this.attributes = new Attributes();
	}
	
	public String getName () {
		return this.name;
	}
	
	public String getClassName () {
		return this.character_class.name();
	}
	
	public Attributes getAttributes() {
		return this.attributes;
	}
	
	public int getLevel () {
		return this.level;
	}
	
	public CharacterClasses getCharacterClass() {
		return this.character_class;
	}
	
	/**
	* Check if an array contains a element
	* in: 	T[] array
	* 		T element
	* out: 	boolean true if element in array, else false
	*/
	protected <T> boolean containedIn(T[] array, T element) {
		for(T e: array) {
			if(e == element)
				return true;
		}
		return false;
	}
}
