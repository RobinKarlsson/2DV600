/*
* Date: 2021-10-04.
* File Name: Attributes.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

/**
* Attributes of a character
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Attributes {
	private int intelligence;
	private int wisdom;
	private int strength;
	private int agility;
	
	public Attributes () {
		setIntelligence(0);
		setWisdom(0);
		setStrength(0);
		setAgility(0);
	}
	
	public Attributes (int intelligence, int wisdom, 
			int strength, int agility) {
		setIntelligence(intelligence);
		setWisdom(wisdom);
		setStrength(strength);
		setAgility(agility);
	}
	
	/**
	* Get intelligence
	* out: int intelligence
	*/
	public int getIntelligence() {
		return intelligence;
	}
	
	/**
	* Get wisdom
	* out: int wisdom
	*/
	public int getWisdom() {
		return wisdom;
	}
	
	/**
	* Get strength
	* out: int strength
	*/
	public int getStrength() {
		return strength;
	}
	
	/**
	* Get agility
	* out: int agility
	*/
	public int getAgility() {
		return agility;
	}
	
	/**
	* Set intelligence
	* in: int intelligence
	*/
	public void setIntelligence (int intelligence) {
		this.intelligence = intelligence;
	}
	
	/**
	* Set wisdom
	* in: int wisdom
	*/
	public void setWisdom (int wisdom) {
		this.wisdom = wisdom;
	}
	
	/**
	* Set strength
	* in: int strength
	*/
	public void setStrength (int strength) {
		this.strength = strength;
	}
	
	/**
	* Set agility
	* in: int agility
	*/
	public void setAgility (int agility) {
		this.agility = agility;
	}
}
