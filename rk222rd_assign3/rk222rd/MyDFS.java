/*
* Date: 2021-10-14.
* File Name: MyDFS.Java
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

import rk222rd_assign3.graphs.DFS;
import rk222rd_assign3.graphs.DirectedGraph;
import rk222rd_assign3.graphs.Node;

/**
* Implementation of depth first search
* 
* @version 1.0 Oct 2021
* @author Robin Karlsson
*/
public class MyDFS<E> implements DFS<E> {

  /**
   * Returns the nodes visited by a depth first search starting from
   * the given root node. Each visited node is also attached with 
   * a depth-first number.

   * @param graph
   * @param root root node
   * @return nodes visited
   */
  @Override
  public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
    ArrayList<Node<E>> notVisited = new ArrayList<Node<E>>();
    Set<Node<E>> visited = new LinkedHashSet<Node<E>>();
    int index = 1;
    
    notVisited.add(root);
    
    while(!notVisited.isEmpty()) {
      Node<E> node = notVisited.get(0);
      notVisited.remove(0);

      if (!visited.contains(node)) {
        node.num = index;
        visited.add(node);
        index++;

        Iterator<Node<E>> succsOfNode = node.succsOf();
        while (succsOfNode.hasNext()) {
          Node<E> succNode = succsOfNode.next();

          if (!visited.contains(succNode)) {
            notVisited.add(0, succNode);
          }
        }
      }
    }
    
    return new ArrayList<Node<E>>(visited);
  }

  /**
   * Returns the nodes visited by a depth first search starting from
   * an arbitrary set of nodes. All nodes are visited. Each visited node is 
   * also attached with a depth-first number.

   * @param graph
   * @return nodes visited
   */
  @Override
  public List<Node<E>> dfs(DirectedGraph<E> graph) {
    List<Node<E>> visited = new ArrayList<Node<E>>();
    int index = 1;
    
    Iterator<Node<E>> headsIterator = graph.heads();
    
    if (!headsIterator.hasNext()) {
      visited = dfs(graph, graph.getNodeFor(graph.allItems().get(0)));
    } else {
      while (headsIterator.hasNext()) {
        Node<E> root = headsIterator.next();
        
        for (Node<E> node : dfs(graph, root)) {
          node.num = index;
          visited.add(node);
          index++;
        }
      }
    }
    
    return visited;
  }

  /**
   * Returns a list of nodes ordered as 
   * post-order of the depth first tree resulting from a
   * depth first search starting at the given root node. 
   * Notice, it only visits nodes reachable from given 
   * root node.
   * </p>
   * The algorithm also attaches a post-order number
   * to each visited node.

   * @param g graph
   * @param root root node
   * @return nodes visited
   */ 
  @Override
  public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
    return new ArrayList<Node<E>>(
        postOrderRecursive(
          root, 
          new LinkedHashSet<Node<E>>(), 
          new LinkedHashSet<Node<E>>()));
  }
  
  /**
   * Post order implementation based on lecture 7 notes

   * @param node current node
   * @param poList post ordered nodes
   * @param visited visited nodes
   * @return post ordered nodes
   */
  public Set<Node<E>> postOrderRecursive(Node<E> node, 
      Set<Node<E>> poList, 
      Set<Node<E>> visited) {
    visited.add(node);
    
    Iterator<Node<E>> nodeSuccIt = node.succsOf();
    while (nodeSuccIt.hasNext()) {
      Node<E> nextNode  = nodeSuccIt.next();
      
      if (!visited.contains(nextNode)) {
        postOrderRecursive(nextNode, poList, visited);
      }
    }
    
    node.num = poList.size();
    poList.add(node);
    
    return poList;
  }
    
  /**
   * Returns a list of ALL nodes in the graph ordered as 
   * post-order of the depth first forest resulting from
   * depth first search starting at arbitrary start nodes.
   * </p>
   * The algorithm also attaches a post-order number
   * to each visited node. 

   * @param g graph
   * @return nodes visited
   */ 
  @Override
  public List<Node<E>> postOrder(DirectedGraph<E> g) {
    List<Node<E>> visited = new ArrayList<Node<E>>();
    int index = 1;
    
    Iterator<Node<E>> headsIterator = g.heads();
    
    if (!headsIterator.hasNext()) {
      visited = postOrder(g, g.getNodeFor(g.allItems().get(0)));
    } else {
      while (headsIterator.hasNext()) {
        Node<E> root = headsIterator.next();
        
        for (Node<E> node : postOrder(g, root)) {
          node.num = index;
          visited.add(node);
          index++;
        }
      }
    }
    
    return visited;
  }

  /**
   * Returns a list of ALL nodes in the graph ordered as 
   * post-order of the depth first forest resulting from
   * depth first search starting at arbitrary start nodes.
   * </p>
   * The algorithm attaches a depth-first number if <tt>attach_dfs_number</tt> 
   * is <tt>true</tt>, otherwise it attaches a post-order number. 
   * 
   * @param g graph
   * @param attach_dfs_number true if nodes numbered as they appear in dfs
   * @return nodes visited
   */ 
  @Override
  public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
    List<Node<E>> poList = postOrder(g);
    
    if (attach_dfs_number) {
      List<Node<E>> dfsList = dfs(g);
      
      for (int i = 0; i < dfsList.size(); i++) {
        poList.get(i).num = dfsList.get(i).num;
      }
    }
    
    return poList;
  }

  /**
   * Returns <tt>true</tt> if the graph contains one or more cycles, 
   * otherwise <tt>false</tt>

   * @param graph
   * @return true if graph is cyclic, else false
   */
  @Override
  public boolean isCyclic(DirectedGraph<E> graph) {
    List<Node<E>> poList = postOrder(graph);
    
    for (Node<E> node : poList) {
      Iterator<Node<E>> nodeSuccIt = node.succsOf();
      
      while (nodeSuccIt.hasNext()) {
        Node<E> nextNode = nodeSuccIt.next();
        
        // check if backward edge
        if (node.num <= nextNode.num) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Returns a list of all nodes in the graph ordered topological.
   * The algorithm assumes that the graph is acyclic. The result for
   * graphs with cycles are undefined. 
   * 
   * @param graph
   * @return elements of graph with topological ordering
   */
  @Override
  public List<Node<E>> topSort(DirectedGraph<E> graph) {
    List<Node<E>> poList = postOrder(graph);
    return reverse(poList);
  }
  
  
  /**
   * Reverse the elements of a list.

   * @param list list to reverse
   * @return list with elements from parameter in reverse order
   */
  private List<Node<E>> reverse(List<Node<E>> list) {
    List<Node<E>> reverseList = new ArrayList<Node<E>>();
    
    for (int i = list.size() - 1; i >= 0; i--) {
      reverseList.add(list.get(i));
    }
    return reverseList;
  }
}
