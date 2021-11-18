/*
* Date: 2021-10-13.
* File Name: MyBFS.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign3.rk222rd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import rk222rd_assign3.graphs.BFS;
import rk222rd_assign3.graphs.DirectedGraph;
import rk222rd_assign3.graphs.Node;

/**
* Implementation of breadth-first search
* 
* @version 1.0 Oct 2021
* @author Robin Karlsson
*/
public class MyBFS<E> implements BFS<E> {

  /**
   * Returns the nodes visited by a breadth-first search starting from
   * the given root node. Each visited node is also attached with 
   * a breadth-first number.

   * @param graph
   * @param root node
   * @return nodes visited
   */
  @Override
  public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
    Set<Node<E>> notVisited = new LinkedHashSet<Node<E>>();
    Set<Node<E>> visited = new LinkedHashSet<Node<E>>();
    int index = 1;
    
    notVisited.add(root);
    
    while(!notVisited.isEmpty()) {
      Node<E> node = popSet(notVisited);

      if (!visited.contains(node)) {
        node.num = index;
        visited.add(node);
        index++;

        Iterator<Node<E>> succsOfNode = node.succsOf();
        while (succsOfNode.hasNext()) {
          Node<E> succNode = succsOfNode.next();

          if (!visited.contains(succNode)) {
            notVisited.add(succNode);
          }
        }
      }
    }
    
    return new ArrayList<Node<E>>(visited);
  }

  /**
   * Returns the nodes visited by a breadth first search starting from
   * an arbitrary set of nodes. All nodes are visited. Each visited node is 
   * also attached with a breadth-first number.

   * @param graph
   * @return nodes visited
   */    
  @Override
  public List<Node<E>> bfs(DirectedGraph<E> graph) {
    List<Node<E>> visited = new ArrayList<Node<E>>();
    int index = 1;
    
    Iterator<Node<E>> headsIterator = graph.heads();
    
    if (!headsIterator.hasNext()) {
      visited = bfs(graph, graph.getNodeFor(graph.allItems().get(0)));
    } else {
      while (headsIterator.hasNext()) {
        Node<E> root = headsIterator.next();
        
        for (Node<E> node : bfs(graph, root)) {
          node.num = index;
          visited.add(node);
          index++;
        }
      }
    }
    
    return visited;
  }
  
  protected Node<E> popSet(Set<Node<E>> set) {
    Iterator<Node<E>> setIterator = set.iterator();
    Node<E> node = setIterator.next();
    setIterator.remove();
    return node;
  }
}
