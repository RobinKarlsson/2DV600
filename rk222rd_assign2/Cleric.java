/*
* Date: 2021-10-04.
* File Name: Cleric.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.util.ArrayList;

/**
* Character of Cleric class
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Cleric extends MagicalClasses {
	private static final MagicSchools[] allowed_schools = 
		{MagicSchools.divination, MagicSchools.restoration};
	
	public Cleric(String name, int level) {
		super(name, CharacterClasses.cleric, level);
	}
	
	/**
	* Learn a new spell
	* in: 	Spell spell
	*/
	@Override
	public void learnSpell(Spell spell) throws Exception {
		if(!containedIn(allowed_schools, spell.getSchool()))
			throw new Exception(this.getClassName() + 
					" can not learn " + spell.getSchool() + " spells");
		
		if(known_spells.contains(spell))
			throw new Exception(spell.getName() + " has already been acquired");
		
		known_spells.add(spell);
	}

	/**
	* Get known spells
	* in: 	ArrayList<Spell> known spells
	*/
	@Override
	public ArrayList<Spell> getKnownSpells() {
		return known_spells;
	}
}
