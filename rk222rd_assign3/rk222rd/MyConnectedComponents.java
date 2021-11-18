/*
* Date: 2021-10-15.
* File Name: MyConnectedComponents.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign3.rk222rd;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import rk222rd_assign3.graphs.ConnectedComponents;
import rk222rd_assign3.graphs.DirectedGraph;
import rk222rd_assign3.graphs.Node;

/**
* Find a partitioning of a graph where two nodes belong to the same partitioning
* iff they are connected.
* 
* @version 1.0 Oct 2021
* @author Robin Karlsson
*/
public class MyConnectedComponents<E> implements ConnectedComponents<E> {

  /**
   * Partition a graph such that nodes which are connected are in the same 
   * partitioning 

   * @param dg graph
   * @return partitioning of dg
   */   
  @Override
  public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
    Collection<Collection<Node<E>>> partitioning = new HashSet<>();
    Set<Node<E>> visited = new HashSet<Node<E>>();
    MyBFS<E> myBFS = new MyBFS<>();

    Iterator<Node<E>> dgIterator = dg.iterator();
    while(dgIterator.hasNext()) {
      Node<E> node = dgIterator.next();
      
      if(!visited.contains(node)) {
        Set<Node<E>> connectedNodes = new HashSet<Node<E>>(myBFS.bfs(dg, node));
        visited.addAll(connectedNodes);
        
        boolean newComponent = true;
        
        // check if intersection between connectedNodes and partitioning not empty
        for (Collection<Node<E>> component : partitioning) {
          if(!Collections.disjoint(component, connectedNodes)) {
            component.addAll(connectedNodes);
            newComponent = false;
            break;
          }
        }
        
        if(newComponent) {
          partitioning.add(connectedNodes);
        }
      }
    }
    return partitioning;
  }
}
