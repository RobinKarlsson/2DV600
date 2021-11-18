/*
* Date: 2021-10-04.
* File Name: ArrayIntStack.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import two_dv600.AbstractIntCollection;
import two_dv600.IntStack;

/**
* Implementation of IntStack
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	/*
	* Add integer at top of stack
	* in: 	int integer to add
	*/
	@Override
	public void push(int n) {
		if(size == values.length)
			resize();
		
		values[size++] = n;
	}

	/*
	* Returns and removes integer at top of stack
	* out: 	int at top of stack
	*/
	@Override
	public int pop() throws IndexOutOfBoundsException {
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		
		size--;
		return values[size];
	}

	/*
	* Returns integer at top of stack
	* out: 	int at top of stack
	*/
	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		return values[size - 1];
	}

}
