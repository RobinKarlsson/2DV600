/*
* Date: 2021-10-04.
* File Name: Node.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

/**
* Node object for Queue
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Node<E> {
	private E value;
	private Node<E> next_node = null;
	
	Node(E v) {
		value = v;
	}
	
	/**
	* Get value of node
	* out: node value
	*/
	public E getValue() {
		return value;
	}
	
	/**
	* Get next node
	* out: Node next node
	*/
	public Node<E> nextNode() {
		return next_node;
	}
	
	/**
	* Check if next node exist
	* out: boolean true if node is linked, else false
	*/
	public boolean hasNext() {
		return next_node == null;
	}
	
	/**
	* Link node to a new node
	* out: value of new node
	*/
	public void newNode(E value) throws Exception {
		if(!hasNext())
			throw new Exception("This node has already been linked");
		
		next_node = new Node<E>(value);
	}
}
