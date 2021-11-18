/*
* Date: 2021-10-12.
* File Name: MyNode.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign3.rk222rd;

import java.util.ArrayList;
import java.util.Iterator;
import rk222rd_assign3.graphs.Node;

/**
* Implementation of Node class
* 
* @version 1.0 Oct 2021
* @author Robin Karlsson
*/
public class MyNode<E> extends Node<E> {
  private ArrayList<Node<E>> successors;
  private ArrayList<Node<E>> predecessors;

  /**
   * Constructs a new node using <tt>item</tt> as key.

   * @param item
   */
  public MyNode(E item) {
    super(item);
    successors = new ArrayList<Node<E>>();
    predecessors = new ArrayList<Node<E>>();
  }

  /**
   * Returns <tt>true</tt> if <tt>this</tt> node has <tt>node</tt> as successor, 
   * otherwise <tt>false</tt>.

   * @param a possible successor node
   * @return boolean
   */
  @Override
  public boolean hasSucc(Node<E> node) {
    return successors.contains(node);
  }

  /**
   * Returns the number of successors (i.e. outgoing edges)

   * of this node.
   * @return node out-degree
   */
  @Override
  public int outDegree() {
    return successors.size();
  }

  /**
   * Returns an iterator over all successor nodes.

   * @return successor node iterator
   */
  @Override
  public Iterator<Node<E>> succsOf() {
    return successors.iterator();
  }

  /**
   * Returns <tt>true</tt> if <tt>this</tt> node has <tt>node</tt> as predecessor, 
   * otherwise <tt>false</tt>.

   * @param a possible predecessor node
   * @return boolean
   */
  @Override
  public boolean hasPred(Node<E> node) {
    return predecessors.contains(node);
  }

  /**
   * Returns the number of predecessors  (i.e. incoming edges)
   * of this node.
 
   * @return node out-degree
   */
  @Override
  public int inDegree() {
    return predecessors.size();
  }

  /**
   * Returns an iterator over all predecessor nodes.

   * @return predecessor node iterator
   */
  @Override
  public Iterator<Node<E>> predsOf() {
    return predecessors.iterator();
  }

  /**
   * Adds node <tt>succ</tt> as a successor to <tt>this</tt> node.

   * @param new successor node
   */
  @Override
  protected void addSucc(Node<E> succ) {
    successors.add(succ);
  }

  /**
   * Removes node <tt>succ</tt> as a successor to <tt>this</tt> node.

   * @param a successor node
   */
  @Override
  protected void removeSucc(Node<E> succ) {
    successors.remove(succ);
  }

  /**
   * Adds node <tt>pred</tt> as a predecessor to <tt>this</tt> node.

   * @param new predecessor node
   */
  @Override
  protected void addPred(Node<E> pred) {
    predecessors.add(pred);
  }

  /**
   * Removes node <tt>succ</tt> as a predecessor to <tt>this</tt> node.

   * @param a predecessor node
   */
  @Override
  protected void removePred(Node<E> pred) {
    predecessors.remove(pred);
  }

  /**
   * Disconnects this node from all adjacent nodes. That is, removes all successor, 
   * and predecessor, nodes to <tt>this</tt> node.
   */
  @Override
  protected void disconnect() {
    for (Node<E> succ : successors) {
      ((MyNode<E>) succ).removePred(this);
    }
    
    for (Node<E> pred : predecessors) {
      ((MyNode<E>) pred).removeSucc(this);
    }
    
    successors.clear();
    predecessors.clear();
  }
}
