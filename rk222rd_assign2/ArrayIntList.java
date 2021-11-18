/*
* Date: 2021-10-04.
* File Name: ArrayIntList.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import two_dv600.AbstractIntCollection;
import two_dv600.IntList;

/**
* Implementation of IntList
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class ArrayIntList extends AbstractIntCollection implements IntList {

	/*
	* Add integer n to the end of the list
	* in: 	int integer to add
	*/
	@Override
	public void add(int n) {
		if(size == values.length)
			resize();
		
		values[size++] = n;
	}

	/*
	* Inserts integer n at position index
	* in: 	int integer to add
	* 		int index of added element
	*/
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size + 1))
			throw new IndexOutOfBoundsException();
		
		if(size == values.length)
			resize();
		
		//make room for the new element at index
		System.arraycopy(values, index, values, index + 1, size - index);
		values[index] = n;
		size++;
	}

	/*
	* Remove integer at position index
	* in: 	int index to remove
	*/
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(isEmpty() || !checkIndex(index, size + 1))
			throw new IndexOutOfBoundsException();
		
		while(index < size - 1) {
			values[index] = values[index+1];
			index++;
		}
		
		size--;
	}

	/*
	* Get integer at position index
	* in: 	int index to retrieve
	*/
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if(isEmpty() || !checkIndex(index, size + 1))
			throw new IndexOutOfBoundsException();
		
		return values[index];
	}

	/*
	* Find position of integer n, otherwise return -1
	* in:	int value to search for
	* out:	int index of n
	*/
	@Override
	public int indexOf(int n) {
		for(int i = 0; i < size; i++) {
			if(values[i] == n)
				return i;
		}
		return -1;
	}
}
