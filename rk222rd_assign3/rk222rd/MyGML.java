/*
* Date: 2021-10-12.
* File Name: MyGraph.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign3.rk222rd;

import java.util.Iterator;

import rk222rd_assign3.graphs.DirectedGraph;
import rk222rd_assign3.graphs.GML;
import rk222rd_assign3.graphs.Node;

/**
* Represent graph in GML format
* 
* @version 1.0 Oct 2021
* @author Robin Karlsson
*/
public class MyGML<E> extends GML<E>  {

  public MyGML(DirectedGraph<E> dg) {
    super(dg);
  }

  /**
   * GML mark-up representation of graph

   * @return string
   */
  @Override
  public String toGML() {
    StringBuilder s = new StringBuilder();
    
    s.append("graph [\n\t");
    s.append("comment \"\"\n\t");
    s.append("directed 1\n\t");
    s.append("id \n\t");
    s.append("label \"" + graph + "\"\n");
    
    addNodes(s);
    addEdges(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  /**
   * Add nodes to a stringbuilder object. 

   * @param stringbuilder
   */ 
  private void addNodes(StringBuilder s) {
    Iterator<Node<E>> iteratorNodes = graph.iterator();
    int index = 1;
    
    while (iteratorNodes.hasNext()) {
      Node<E> node = iteratorNodes.next();
      
      s.append("\tnode [\n\t\t");
      s.append("id " + index + "\n\t\t");
      s.append("label node \"node " + node + "\"\n\t\t");
      s.append(node.item() + "\n\t]");
      s.append("\n");
    }
  }
  
  /**
   * Add edges to a stringbuilder object. 

   * @param stringbuilder
   */ 
  private void addEdges(StringBuilder s) {
    Iterator<Node<E>> iteratorNodes = graph.iterator();
    while (iteratorNodes.hasNext()) {
      Node<E> node = iteratorNodes.next();
      Iterator<Node<E>> iteratorSucc = node.succsOf();
      
      while (iteratorSucc.hasNext()) {
        Node<E> succ = iteratorSucc.next();
        
        s.append("\tedge [\n\t\t");
        s.append("source " + node + "\n\t\t");
        s.append("target " + succ + "\n\t\t");
        s.append("label \"Edge from node " + node 
            + " to node " + succ + "\"\n\t]");
        s.append("\n");
      }
    }
  }
}
