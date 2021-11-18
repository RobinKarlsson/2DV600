/*
* Date: 2021-10-04.
* File Name: Exercise1Test.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* Unit testing of battle results
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
class Exercise1Test {

	@Test
	void draw() throws Exception {
		Rogue rogue1 = new Rogue("rogue 1", 50);
		Warrior warrior1 = new Warrior("warrior 1", 34);
		
		Mage mage2 = new Mage("mage 1", 22);
		Cleric cleric2 = new Cleric("cleric 1", 62);
		
		Ability stealth_ability = new Ability("stealth ability", 
				PhysicalAbilities.stealth);
		Ability acrobatics_ability = new Ability("acrobatics ability", 
				PhysicalAbilities.acrobatics);
		
		rogue1.learnAbility(stealth_ability);
		rogue1.learnAbility(acrobatics_ability);
		
		Ability athletics_ability = new Ability("athletics ability", 
				PhysicalAbilities.athletics);
		Ability survival_ability = new Ability("survival ability", 
				PhysicalAbilities.survival);
		
		warrior1.learnAbility(athletics_ability);
		warrior1.learnAbility(survival_ability);
		
		Spell evocation_spell = new Spell("evocation spell", 
				MagicSchools.evocation);
		Spell alteration_spell = new Spell("alteration spell", 
				MagicSchools.alteration);
		
		mage2.learnSpell(evocation_spell);
		mage2.learnSpell(alteration_spell);
		
		Spell restoration_spell = new Spell("restoration spell", 
				MagicSchools.restoration);
		Spell divination_spell = new Spell("divination spell", 
				MagicSchools.divination);
		
		cleric2.learnSpell(restoration_spell);
		cleric2.learnSpell(divination_spell);
		
		Character[] party1 = {rogue1, warrior1};
		Character[] party2 = {mage2, cleric2};
		
		Character[] battle1 = Battle.resolve(party1, party2);
		Character[] battle2 = Battle.resolve(party2, party1);
		
		Assertions.assertEquals(battle1, null);
		Assertions.assertEquals(battle2, null);
	}

	@Test
	void party1Win() throws Exception {
		Rogue rogue1 = new Rogue("rogue 1", 50);
		Warrior warrior1 = new Warrior("warrior 1", 34);
		
		Mage mage2 = new Mage("mage 1", 21);
		Cleric cleric2 = new Cleric("cleric 1", 62);
		
		Ability stealth_ability = new Ability("stealth ability", 
				PhysicalAbilities.stealth);
		Ability acrobatics_ability = new Ability("acrobatics ability", 
				PhysicalAbilities.acrobatics);
		
		rogue1.learnAbility(stealth_ability);
		rogue1.learnAbility(acrobatics_ability);
		
		Ability athletics_ability = new Ability("athletics ability", 
				PhysicalAbilities.athletics);
		Ability survival_ability = new Ability("survival ability", 
				PhysicalAbilities.survival);
		
		warrior1.learnAbility(athletics_ability);
		warrior1.learnAbility(survival_ability);
		
		Spell evocation_spell = new Spell("evocation spell", 
				MagicSchools.evocation);
		Spell alteration_spell = new Spell("alteration spell", 
				MagicSchools.alteration);
		
		mage2.learnSpell(evocation_spell);
		mage2.learnSpell(alteration_spell);
		
		Spell restoration_spell = new Spell("restoration spell", 
				MagicSchools.restoration);
		Spell divination_spell = new Spell("divination spell", 
				MagicSchools.divination);
		
		cleric2.learnSpell(restoration_spell);
		cleric2.learnSpell(divination_spell);
		
		Character[] party1 = {rogue1, warrior1};
		Character[] party2 = {mage2, cleric2};
		
		Character[] battle1 = Battle.resolve(party1, party2);
		Character[] battle2 = Battle.resolve(party2, party1);
		
		Assertions.assertEquals(battle1, party1);
		Assertions.assertEquals(battle2, party1);
	}
	
	@Test
	void singleCombatDraw() throws Exception {
		Warrior warrior1 = new Warrior("warrior 1", 42);
		Warrior warrior2 = new Warrior("warrior 2", 42);
		
		Ability athletics_ability = new Ability("athletics ability", 
				PhysicalAbilities.athletics);
		Ability survival_ability = new Ability("survival ability", 
				PhysicalAbilities.survival);
		
		warrior1.learnAbility(athletics_ability);
		warrior2.learnAbility(survival_ability);
		
		Character battle1 = Battle.singleCombat(warrior1, warrior2);
		Character battle2 = Battle.singleCombat(warrior2, warrior1);
		
		Assertions.assertEquals(battle1, null);
		Assertions.assertEquals(battle2, null);
	}
	
	@Test
	void singleCombat1Wins() throws Exception {
		Warrior warrior1 = new Warrior("warrior 1", 42);
		Warrior warrior2 = new Warrior("warrior 2", 42);
		
		Ability athletics_ability = new Ability("athletics ability", 
				PhysicalAbilities.athletics);
		Ability survival_ability = new Ability("survival ability", 
				PhysicalAbilities.survival);
		
		warrior1.learnAbility(athletics_ability);
		warrior1.learnAbility(survival_ability);
		warrior2.learnAbility(survival_ability);
		
		Character battle1 = Battle.singleCombat(warrior1, warrior2);
		Character battle2 = Battle.singleCombat(warrior2, warrior1);
		
		Assertions.assertEquals(battle1, warrior1);
		Assertions.assertEquals(battle2, warrior1);
	}
}
