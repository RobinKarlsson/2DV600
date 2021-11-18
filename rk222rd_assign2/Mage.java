/*
* Date: 2021-10-04.
* File Name: Mage.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.util.ArrayList;

/**
* Character of Mage class
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Mage extends MagicalClasses {
	private static final MagicSchools[] allowed_schools = 
		{MagicSchools.alteration, MagicSchools.evocation};
	
	public Mage(String name, int level) {
		super(name, CharacterClasses.mage, level);
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
