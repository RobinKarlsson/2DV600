package rk222rd_assign2;

public interface Queue<E> extends Iterable<E> {
	int size(); // current queue size
	boolean isEmpty(); // true if queue is empty
	void enqueue(E element); // add element at end of queue
	E dequeue() throws Exception; // return and remove first element.
	E first() throws Exception; // return (without removing) first element
	E last() throws Exception; // return (without removing) last element
}