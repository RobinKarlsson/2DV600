/*
* Date: 2021-10-04.
* File Name: Warrior.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.util.ArrayList;

/**
* Character of Warrior class
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Warrior extends PhysicalClasses {
	private static final PhysicalAbilities[] allowed_abilities = 
		{PhysicalAbilities.athletics, PhysicalAbilities.survival};
	
	public Warrior(String name, int level) {
		super(name, CharacterClasses.warrior, level);
	}

	/**
	* Learn a new ability
	* in: 	Ability ability
	*/
	@Override
	public void learnAbility(Ability ability) throws Exception {
		if(!containedIn(allowed_abilities, ability.getProficiency()))
			throw new Exception(this.getClassName() + 
					" can not learn " + ability.getProficiency() + " spells");
		
		if(known_abilities.contains(ability))
			throw new Exception(ability.getName() + " has already been acquired");
		
		known_abilities.add(ability);
	}

	/**
	* Get known abilities
	* in: 	ArrayList<Ability> known abilities
	*/
	@Override
	public ArrayList<Ability> getKnownAbilities() {
		return known_abilities;
	}
}
