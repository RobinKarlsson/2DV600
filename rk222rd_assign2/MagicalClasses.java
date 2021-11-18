/*
* Date: 2021-10-04.
* File Name: MagicalClasses.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.util.ArrayList;

/**
* Abstract class for classes utilizing magic
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public abstract class MagicalClasses extends Character {
	protected ArrayList<Spell> known_spells = new ArrayList<>();
	
	public MagicalClasses (String name, CharacterClasses character_class, 
			int level) {
		super(name, character_class, level);
	}
	
	/**
	* Learn a new spell
	* in: 	Spell spell
	*/
	public abstract void learnSpell(Spell spell) throws Exception;
	
	/**
	* Get known spells
	* in: 	ArrayList<Spell> known spells
	*/
	public abstract ArrayList<Spell> getKnownSpells();
}
