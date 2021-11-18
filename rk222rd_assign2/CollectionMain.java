/*
* Date: 2021-10-04.
* File Name: CollectionMain.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import two_dv600.IntList;
import two_dv600.IntStack;

/**
* Demonstration of ArrayIntList and ArrayIntStack
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class CollectionMain {
	public static void main(String[] args) {
		IntList int_list = new ArrayIntList();
		IntStack int_stack = new ArrayIntStack();
		
		for (int i = 0; i < 4; i++) {
			int_list.add(i);
			int_stack.push(i);
        }
		
		System.out.println("ArrayIntList: " + int_list.toString());
		System.out.println("ArrayIntStack" + int_stack.toString());
		
		int_list.addAt(42, 2);
		
		System.out.println("Added 42 to index 2 of ArrayIntList");
		System.out.println("Popped " + int_stack.pop() + " from ArrayIntStack");
		
		System.out.println("ArrayIntList: " + int_list.toString());
		System.out.println("ArrayIntStack" + int_stack.toString());
		
		int_list.remove(1);
		
		System.out.println("Removed index 1 of ArrayIntList");
		System.out.println("Peeked: " + int_stack.peek() + " from ArrayIntStack ");
		
		System.out.println("ArrayIntList: " + int_list.toString());
		System.out.println("ArrayIntStack" + int_stack.toString());
		
		System.out.println("Retrieved " + int_list.get(1) + " from ArrayIntList at index 1");
		
		System.out.println("42 has index " + int_list.indexOf(42) + " in ArrayIntList");
	}
}
