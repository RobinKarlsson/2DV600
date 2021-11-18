/*
* Date: 2021-10-15.
* File Name: MyTransitiveClosure.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign3.rk222rd;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import rk222rd_assign3.graphs.DirectedGraph;
import rk222rd_assign3.graphs.Node;
import rk222rd_assign3.graphs.TransitiveClosure;

/**
* Compute the transitive closure of a graph.
* 
* @version 1.0 Oct 2021
* @author Robin Karlsson
*/
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

  /**
   * Computes the transitive closure for the graph.

   *@param dg graph
   *@return transitive closures of dg
   */
  @Override
  public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
    Map<Node<E>, Collection<Node<E>>> transitiveClosure = new HashMap<>();
    MyBFS<E> myBFS = new MyBFS<>();
    
    Iterator<Node<E>> dgIterator = dg.iterator();
    
    dgIterator.forEachRemaining(node -> {
      transitiveClosure.put(node, myBFS.bfs(dg, node));
    });
    
    return transitiveClosure;
  }
}
