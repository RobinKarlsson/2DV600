/*
* Date: 2021-10-04.
* File Name: PhysicalClasses.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.util.ArrayList;

/**
* Abstract class for classes utilizing physical abilities
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public abstract class PhysicalClasses extends Character {
	protected ArrayList<Ability> known_abilities = new ArrayList<>();
	
	public PhysicalClasses(String name, CharacterClasses character_class, 
			int level) {
		super(name, character_class, level);
	}
	
	/**
	* Learn a new ability
	* in: 	Ability ability
	*/
	public abstract void learnAbility(Ability ability) throws Exception;
	
	/**
	* Get known abilities
	* in: 	ArrayList<Ability> known abilities
	*/
	public abstract ArrayList<Ability> getKnownAbilities();
}
