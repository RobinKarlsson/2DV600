/*
* Date: 2021-10-04.
* File Name: WordTest.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordTest {

	@Test
	void setWord() {
		Word word = new Word("tEsT");
		Assertions.assertEquals("tEsT", word.toString());
	}
	
	@Test
	void testWordHashSame() {
		Word word1 = new Word("tEsT");
		Word word2 = new Word("Test");
		Assertions.assertEquals(word1.hashCode(), word2.hashCode());
	}
	
	@Test
	void testWordHashDifferent() {
		Word word1 = new Word("tEsT");
		Word word2 = new Word("Rest");
		Assertions.assertNotEquals(word1.hashCode(), word2.hashCode());
	}

}
