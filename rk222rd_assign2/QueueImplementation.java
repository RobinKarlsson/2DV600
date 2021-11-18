/*
* Date: 2021-10-04.
* File Name: QueueImplementation.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.util.Iterator;

/**
* Implementation of Queue
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class QueueImplementation<E> implements Queue<E> {
	private int size = 0;
	private Node<E> first_element;
	private Node<E> last_element;

	/**
	* Get size of queue
	* out: int number of nodes in queue
	*/
	@Override
	public int size() {
		return size;
	}

	/**
	* Check if queue iis empty
	* out: boolean true if queue is empty, else false
	*/
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	* Add a node to end of queue
	* in: value of new node
	*/
	@Override
	public void enqueue(E element) {
		if(isEmpty()) {
			first_element = new Node<E>(element);
			last_element = first_element;
		} else {
			try {
				last_element.newNode(element);
			} catch (Exception e) {
				System.out.println("Couldnt enqueue item");
				return;
			}
			last_element = last_element.nextNode();
		}
		
		size++;
	}

	/**
	* Pop first element of queue
	* out: value of first element
	*/
	@Override
	public E dequeue() throws Exception {
		if(isEmpty())
			throw new Exception("Empty queue");
		
		Node<E> first_element_placeholder = first_element;
		first_element = first_element.nextNode();
		size--;
		return first_element_placeholder.getValue();
	}

	/**
	* Get first element of queue
	* out: value of first element
	*/
	@Override
	public E first() throws Exception {
		if(isEmpty())
			throw new Exception("Empty queue");
		
		return first_element.getValue();
	}

	/**
	* Get last element of queue
	* out: value of last element
	*/
	@Override
	public E last() throws Exception {
		if(isEmpty())
			throw new Exception("Empty queue");
		
		return last_element.getValue();
	}

	/**
	* Get queue iterator
	* out: queue iterator
	*/
	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	/**
	* Private queue iterator class
	* 
	* @version 1.0 Sep 2021
	* @author Robin Karlsson
	*/
	private class QueueIterator implements Iterator<E> {
		private Node<E> node = first_element;

		/**
		* Check if node has a next element
		* out: boolean true if next exist, else false
		*/
		@Override
		public boolean hasNext() {
			return node != null;
		}

		/**
		* Move to next node
		* out: value of previous node
		*/
		@Override
		public E next() {
			E value = node.getValue();
			node = node.nextNode();
			return value;
		} 
	}
}
