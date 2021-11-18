/*
* Date: 2021-10-04.
* File Name: QueueTest.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {
	
	@Test
	void qeueEmpty() {
		QueueImplementation queue = new QueueImplementation();
		Assertions.assertEquals(0, queue.size());
	}
	
	@Test
	void enqueueElements() throws Exception {
		QueueImplementation queue = new QueueImplementation();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		Assertions.assertEquals(1, queue.first());
		Assertions.assertEquals(3, queue.last());
		Assertions.assertEquals(3, queue.size());
	}
	
	@Test
	void dequeueElements() throws Exception {
		QueueImplementation queue = new QueueImplementation();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		Assertions.assertEquals(1, queue.dequeue());
		Assertions.assertEquals(2, queue.size());
		Assertions.assertEquals(2, queue.dequeue());
		Assertions.assertEquals(1, queue.size());
		Assertions.assertEquals(3, queue.dequeue());
		Assertions.assertEquals(0, queue.size());
	}
	
	@Test
	void firstLastSameAfterDequeue() throws Exception {
		QueueImplementation queue = new QueueImplementation();
		queue.enqueue(1);
		queue.enqueue(2);
		
		queue.dequeue();
		
		Assertions.assertEquals(queue.first(), queue.last());
	}
	
	@Test
	void iteratorHasNext() {
		QueueImplementation queue = new QueueImplementation();
		queue.enqueue(1);
		
		Assertions.assertTrue(queue.iterator().hasNext());
	}
	
	@Test
	void iteratorGoesntHaveNext() {
		QueueImplementation queue = new QueueImplementation();

		Assertions.assertFalse(queue.iterator().hasNext());
	}
	
	@Test
	void iteratorEmptyAfterDequeue() throws Exception {
		QueueImplementation queue = new QueueImplementation();
		
		queue.enqueue(1);
		queue.dequeue();

		Assertions.assertFalse(queue.iterator().hasNext());
	}
	
	@Test
	void iteratorNext() {
		QueueImplementation queue = new QueueImplementation();
		
		queue.enqueue(1);
		queue.enqueue(2);

		Assertions.assertEquals(1, queue.iterator().next());
	}

}
