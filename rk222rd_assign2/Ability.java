/*
* Date: 2021-10-04.
* File Name: Ability.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

/**
* A single ability
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Ability {
	private String name;
	private PhysicalAbilities ability;
	
	/**
	* Get ability name
	*/
	public Ability(String name, PhysicalAbilities ability) {
        this.name = name;
        this.ability = ability;
    }
	
	/**
	* Get ability name
	* out: String name
	*/
	public String getName() {
		return this.name;
	}
	
	/**
	* Get proficiency
	* out: PhysicalAbilities ability
	*/
	public PhysicalAbilities getProficiency() {
		return ability;
	}
}
