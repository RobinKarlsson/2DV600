/*
* Date: 2021-10-04.
* File Name: Spell.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

/**
* A single spell
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Spell {
	private String name;
	private MagicSchools school;
	
	public Spell(String name, MagicSchools school) {
        this.name = name;
        this.school = school;
    }
	
	/**
	* Get ability name
	* out: String name
	*/
	public String getName() {
		return this.name;
	}
	
	/**
	* Get spell school
	* out: MagicSchools school
	*/
	public MagicSchools getSchool() {
		return this.school;
	}
}
