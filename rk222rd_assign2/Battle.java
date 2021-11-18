/*
* Date: 2021-10-04.
* File Name: Battle.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

/**
* Logic for battles between parties and single characters
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Battle {
	/**
	* Print party statistics
	*/
	public static void printStatistics(Character[] party) {
		double level_avr = 0;
		int mage_spells = 0;
		int cleric_spells = 0;
		int warrior_abilities = 0;
		int rogue_abilities = 0;
		
		for(Character c: party) {
			level_avr += c.getLevel();
			switch(c.getCharacterClass()) {
				case mage:
					mage_spells += ((Mage) c).getKnownSpells().size();
					break;
				case cleric:
					cleric_spells += ((Cleric) c).getKnownSpells().size();
					break;
				case warrior:
					warrior_abilities += ((Warrior) c).getKnownAbilities().size();
					break;
				case rogue:
					rogue_abilities += ((Rogue) c).getKnownAbilities().size();
					break;
			}
		}
		
		level_avr = level_avr / party.length;
		
		System.out.println("Average party level: " + level_avr);
		System.out.println("Total spells: " + (mage_spells + cleric_spells));
		System.out.println("Mage spells: " + mage_spells);
		System.out.println("Cleric spells: " + cleric_spells);
		System.out.println("Total abilities: " + (warrior_abilities + rogue_abilities));
		System.out.println("Warrior abilities: " + warrior_abilities);
		System.out.println("Rogue abilities: " + rogue_abilities);
	}
	
	/**
	* Battle between two parties
	* in: 	Character[] party 1
	* 		Character[] party 2
	* out: 	Character[] winning party, null if draw
	*/
	public static Character[] resolve(Character[] party1, Character[] party2) {
		if(party1.length > party2.length)
			return party1;
		if(party2.length > party1.length)
			return party2;
		if(party1.length == 0)
			return null;
		
		double party1_lvl = averageLevel(party1);
		double party2_lvl = averageLevel(party2);
		
		if(party1_lvl > party2_lvl)
			return party1;
		if(party2_lvl > party1_lvl)
			return party2;
		
		int primary_attr_party1 = numPrimaryAttributes(party1);
		int primary_attr_party2 = numPrimaryAttributes(party2);
		
		if(primary_attr_party1 > primary_attr_party2)
			return party1;
		if(primary_attr_party2 > primary_attr_party1)
			return party2;
		
		return null;
	}
	
	/**
	* Battle between two characters
	* in: 	Character character1
	* 		Character character 2
	* out: 	Character winning character, null if draw
	*/
	public static Character singleCombat(Character character1, Character character2) 
			throws Exception {
		if(character1.getClassName() != character2.getClassName())
			throw new Exception("Characters must be of same class");
		
		if(character1.getLevel() > character2.getLevel())
			return character1;
		if(character2.getLevel() > character1.getLevel())
			return character2;
		
		int primary_attr_1 = numPrimaryAttributes(new Character[] {character1});
		int primary_attr_2 = numPrimaryAttributes(new Character[] {character2});
		
		if(primary_attr_1 > primary_attr_2)
			return character1;
		if(primary_attr_2 > primary_attr_1)
			return character2;
		
		int powers_1 = numKnownPowers(character1);
		int powers_2 = numKnownPowers(character2);
		
		if(powers_1 > powers_2)
			return character1;
		if(powers_2 > powers_1)
			return character2;
		System.out.println(1);
		return null;
	}
	
	/**
	* Number of spells/abilities known by a character
	* in: 	Character character
	* out: 	int known spells/abilities
	*/
	private static int numKnownPowers(Character character) {
		if(character instanceof MagicalClasses)
			return ((MagicalClasses) character).getKnownSpells().size();
		return ((PhysicalClasses) character).getKnownAbilities().size();
	}
	
	/**
	* Average level of a party
	* in: 	Character[] party
	* out: 	double average level
	*/
	private static double averageLevel(Character[] party) {
		double lvl = 0;
		
		for(Character c: party) {
			lvl += c.getLevel();
		}
		
		return lvl / party.length;
	}
	
	/**
	* number of primary attributes held by party members
	* in: 	Character[] party
	* out: 	int sum primary attributes
	*/
	private static int numPrimaryAttributes(Character[] party) {
		int primary = 0;
		
		for(Character c: party) {
			switch(c.getCharacterClass()) {
				case mage:
					primary += c.getAttributes().getIntelligence();
					break;
				case cleric:
					primary += c.getAttributes().getWisdom();
					break;
				case warrior:
					primary += c.getAttributes().getStrength();
					break;
				case rogue:
					primary += c.getAttributes().getAgility();
					break;
			}
		}
		
		return primary;
	}
}
