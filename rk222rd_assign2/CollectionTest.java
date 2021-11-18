/*
* Date: 2021-10-05.
* File Name: CollectionMain.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import two_dv600.IntList;
import two_dv600.IntStack;

/**
* JUnit testing of ArrayIntList and ArrayIntStack
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
class CollectionTest {
	IntList int_list;
	IntStack int_stack;

	@BeforeEach
	void reset() {
		int_list = new ArrayIntList();
		int_stack = new ArrayIntStack();
	}
	
	@Test
	void addNumbersList() {
		for (int i = -2; i < 5; i++) {
			int_list.add(i);
		}
		
		Assertions.assertEquals(7, int_list.size());
	}
	
	@Test
	void addNumbersStack() {
		for (int i = -2; i < 5; i++) {
			int_stack.push(i);
		}
		
		Assertions.assertEquals(7, int_stack.size());
	}
	
	@Test
	void popLastStack() {
		for (int i = -2; i < 5; i++) {
			int_stack.push(i);
		}
		
		Assertions.assertEquals(4, int_stack.pop());
	}
	
	@Test
	void peekLastStack() {
		for (int i = -2; i < 5; i++) {
			int_stack.push(i);
		}
		
		Assertions.assertEquals(4, int_stack.peek());
	}
	
	@Test
	void peekLeaveStackUnchanged() {
		for (int i = -2; i < 5; i++) {
			int_stack.push(i);
		}
		int_stack.peek();
		Assertions.assertEquals(7, int_stack.size());
	}
	
	@Test
	void popReduceStack() {
		for (int i = -2; i < 5; i++) {
			int_stack.push(i);
		}
		int_stack.pop();
		Assertions.assertEquals(6, int_stack.size());
	}
	
	@Test
	void resizeList() {
		for (int i = -2; i < 8; i++) {
			int_list.add(i);
		}
		
		Assertions.assertEquals(10, int_list.size());
	}
	
	@Test
	void resizeStack() {
		for (int i = -2; i < 8; i++) {
			int_stack.push(i);
		}
		
		Assertions.assertEquals(10, int_stack.size());
	}

	@Test
	void addMultipleNumbersStack() {
		try {
			for (int i = -2; i < 500000; i++) {
				int_stack.push(i);
			}
		} catch(Exception e) {
			Assertions.fail("Exception was thrown");
		}
	}
	
	@Test
	void addMultipleNumbersList() {
		try {
			for (int i = -2; i < 500000; i++) {
				int_list.add(i);
			}
		} catch(Exception e) {
			Assertions.fail("Exception was thrown");
		}
	}
	
	@Test
	void addMaxNumberList() {
		try {
			int_list.add(Integer.MAX_VALUE);
		} catch(IllegalArgumentException e) {
			Assertions.fail("Exception was thrown");
		}
	}
	
	@Test
	void addMaxNumberStack() {
		try {
			int_stack.push(Integer.MAX_VALUE);
		} catch(IllegalArgumentException e) {
			Assertions.fail("Exception was thrown");
		}
	}
	
	@Test
	void addMinNumberList() {
		try {
			int_list.add(Integer.MIN_VALUE);
		} catch(IllegalArgumentException e) {
			Assertions.fail("Exception was thrown");
		}
	}
	
	@Test
	void addMinNumberStack() {
		try {
			int_stack.push(Integer.MIN_VALUE);
		} catch(IllegalArgumentException e) {
			Assertions.fail("Exception was thrown");
		}
	}
	
	@Test
	void addToIndex() {
		for (int i = -2; i < 5; i++) {
			int_list.add(i);
		}
		
		int_list.addAt(42, 2);
		Assertions.assertEquals(42, int_list.get(2));
	}
	
	@Test
	void addToIndexIncreaseSize() {
		for (int i = -2; i < 5; i++) {
			int_list.add(i);
		}
		
		int_list.addAt(42, 2);
		Assertions.assertEquals(8, int_list.size());
	}
	
	@Test
	void removeIndexdecreaseSize() {
		for (int i = -2; i < 5; i++) {
			int_list.add(i);
		}
		
		int_list.remove(0);
		Assertions.assertEquals(6, int_list.size());
	}
	
	@Test
	void addIndexOutsideException() {
		for (int i = -2; i < 5; i++) {
			int_list.add(i);
		}
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, 
				() -> {
					int_list.addAt(42, 42); 
					});
	}
	
	@Test
	void removeIndexOutsideException() {
		for (int i = -2; i < 5; i++) {
			int_list.add(i);
		}
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, 
				() -> {
					int_list.remove(42); 
					});
	}
	
	@Test
	void getIndexOutsideException() {
		for (int i = -2; i < 5; i++) {
			int_list.add(i);
		}
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, 
				() -> {
					int_list.get(42); 
					});
	}
	
	@Test
	void peekEmptyStackException() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, 
				() -> {
					int_stack.peek(); 
					});
	}
	
	@Test
	void removeAllelementsList() {
		for (int i = 0; i < 6; i++) {
			int_list.add(i);
		}

		for(int i = 0; i < 6; i++) {
			int_list.remove(0);
		}
		
		Assertions.assertEquals(0, int_list.size());
	}
	
	@Test
	void popAllelementsStack() {
		for (int i = 0; i < 6; i++) {
			int_stack.push(i);
		}

		for(int i = 0; i < 6; i++) {
			int_stack.pop();
		}
		
		Assertions.assertEquals(0, int_stack.size());
	}
	
	@Test
	void findElementInList() {
		for (int i = 1; i < 7; i++) {
			int_list.add(i);
		}
		
		Assertions.assertEquals(1, int_list.indexOf(2));
	}
	
	@Test
	void elementNotInList() {
		for (int i = 0; i < 6; i++) {
			int_list.add(i);
		}
		
		Assertions.assertEquals(-1, int_list.indexOf(42));
	}
}
