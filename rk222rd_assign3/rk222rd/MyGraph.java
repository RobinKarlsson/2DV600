/*
* Date: 2021-10-12.
* File Name: MyGraph.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign3.rk222rd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import rk222rd_assign3.graphs.DirectedGraph;
import rk222rd_assign3.graphs.Node;

/**
* Implementation of DirectedGraph class
* 
* @version 1.0 Oct 2021
* @author Robin Karlsson
*/
public class MyGraph<E> implements DirectedGraph<E> {
  private List<Node<E>> nodes;
  
  /**
   * Constructs a new graph.
   */
  public MyGraph() {
    nodes = new ArrayList<Node<E>>();
  }

  /**
   * Adds a node representing <tt>item</tt> if not added before.
   * Exception is thrown if <tt>item</tt> is null. It returns the
   * node representing <tt>item</tt> (new or previously constructed).

   * @param item, 
   * @return Node representing <tt>item</tt>
   */
  @Override
  public Node<E> addNodeFor(E item) {
    if (item == null) {
      throw new NullPointerException();
    }
    
    if (!containsNodeFor(item)) {
      MyNode<E> node = new MyNode(item);
      nodes.add(node);
    }
    
    return getNodeFor(item);
  }

  /**
   * Returns the node representing <tt>item</tt>.
   * Exception is thrown if <tt>item</tt> is null or if no
   * node representing <tt>item</tt> is found.

   * @param item
   * @return Node representing <tt>item</tt>
   */
  @Override
  public Node<E> getNodeFor(E item) {
    if (item == null) {
      throw new NullPointerException();
    }
    
    for (Node<E> node : nodes) {
      if(node.item().equals(item)) {
        return node;
      }
    }
    
    throw new NoSuchElementException();
  }

  /**
   * Adds an edge between the nodes represented by <tt>from</tt>
   * and <tt>to</tt>  if not added before. The nodes representing 
   * <tt>from</tt> and <tt>to</tt> are added if not added before.
   * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null. 
   * It returns <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.

   * @param from, source node
   * @param to, target node
   * @return <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.
   */
  @Override
  public boolean addEdgeFor(E from, E to) {
    if (from == null || to == null) {
      throw new NullPointerException();
    }
    
    MyNode<E> mainNode = (MyNode<E>) addNodeFor(from);
    MyNode<E> childNode = (MyNode<E>) addNodeFor(to);
    
    if (mainNode.hasSucc(childNode) && childNode.hasPred(mainNode)) {
      return false;
    }
    
    mainNode.addSucc(childNode);
    childNode.addPred(mainNode);
    
    return true;
  }

  /**
   * Returns <tt>true</tt> if the node representing <tt>item</tt> is 
   * contained in the graph, otherwise <tt>false</tt>.
   * Exception is thrown if <tt>item</tt> is null. 

   * @param item, node to be checked.
   */
  @Override
  public boolean containsNodeFor(E item) {
    try {
      getNodeFor(item);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  /**
   * Returns the number of nodes in the graph. 

   * @return number of nodes
   */ 
  @Override
  public int nodeCount() {
    return nodes.size();
  }

  /**
   * Returns an iterator over all nodes in the graph. 

   * @return graph nodes iterator
   */ 
  @Override
  public Iterator<Node<E>> iterator() {
    return nodes.iterator();
  }

  /**
   * Returns an iterator over all nodes with no in-edges. 

   * @return heads iterator
   */
  @Override
  public Iterator<Node<E>> heads() {
    ArrayList<Node<E>> headNodes = new ArrayList<Node<E>>();
    
    for (Node<E> node : nodes) {
      if (node.isHead()) {
        headNodes.add(node);
      }
    }
    
    return headNodes.iterator();
  }

  /**
   * The number of nodes with no in-edges. 

   * @return number of head nodes.
   */
  @Override
  public int headCount() {
    int headNodes = 0;
    
    for (Node<E> node : nodes) {
      if (node.isHead()) {
        headNodes++;
      }
    }
    
    return headNodes;
  }

  /**
   * Returns an iterator over all nodes with no out-edges. 

   * @return tails iterator
   */
  @Override
  public Iterator<Node<E>> tails() {
    ArrayList<Node<E>> tailNodes = new ArrayList<Node<E>>();
    
    for (Node<E> node : nodes) {
      if (node.isTail()) {
        tailNodes.add(node);
      }
    }
    
    return tailNodes.iterator();
  }

  /**
   * The number of nodes with no out-edges. 

   * @return number of head nodes.
   */
  @Override
  public int tailCount() {
    int tailNodes = 0;
    
    for (Node<E> node : nodes) {
      if (node.isTail()) {
        tailNodes++;
      }
    }
    
    return tailNodes;
  }

  /**
   * Returns a list over all node items currently used in the graph. 

   * @return list of items
   */
  @Override
  public List<E> allItems() {
    ArrayList<E> items = new ArrayList<E>();
    
    for (Node node : nodes) {
      items.add((E) node.item());
    }
    
    return items;
  }

  /**
   * Returns the number of graph edges. 

   * @return edge count
   */
  @Override
  public int edgeCount() {
    int edges = 0;
    
    for (Node<E> node : nodes) {
      edges += node.outDegree();
    }
    
    return edges;
  }

  /**
   * Removes the node represented by <tt>item</item> and 
   * all its connecting edges. Exception is thrown if <tt>item</tt> 
   * is null  or if no node representing <tt>item</tt> is found. 

   * @param item, node to be removed.
   */
  @Override
  public void removeNodeFor(E item) {
    MyNode<E> node = (MyNode<E>) getNodeFor(item);
    
    node.disconnect();
    
    for (Node<E> e : nodes) {
      if (e.item().equals(item)) {
        nodes.remove(e);
        return;
      }
    }
  }

  /**
   * Returns <tt>true</tt> if an edge between the nodes represented 
   * by <tt>from</tt> and <tt>to</tt> is added to the graph. 
   * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.

   * @param from, source node item
   * @param to, target node item
   * @return <tt>true</tt> if edge in graph, otherwise <tt>false</tt>.
   */
  @Override
  public boolean containsEdgeFor(E from, E to) {
    if (from == null || to == null) {
      throw new NullPointerException();
    }
    
    if (containsNodeFor(from) && containsNodeFor(to)) {
      Node<E> mainNode = getNodeFor(from);
      Node<E> childNode = getNodeFor(to);
      
      return mainNode.hasSucc(childNode) && childNode.hasPred(mainNode);
    }
    
    return false;
  }

  /**
   * Removes the edge between the nodes represented 
   * by <tt>from</tt> and <tt>to</tt> if it exist.
   * Returns <tt>true</tt> if an edge between the nodes represented 
   * by <tt>from</tt> and <tt>to</tt>  is found and successfully removed. 
   * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null. 

   * @param from, source node item
   * @param to, target node item
   * @return <tt>true</tt> if edge in graph and successfully removed, otherwise <tt>false</tt>.
   */
  @Override
  public boolean removeEdgeFor(E from, E to) {
    if (from == null || to == null) {
      throw new NullPointerException();
    }
    
    if (containsNodeFor(from) && containsNodeFor(to)) {
      MyNode<E> mainNode = (MyNode<E>) getNodeFor(from);
      MyNode<E> childNode = (MyNode<E>) getNodeFor(to);
      
      mainNode.removeSucc(childNode);
      childNode.removePred(mainNode);
      return true;
    }
    return false;
  }
}
