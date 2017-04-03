import java.util.Collection;
// import java.util.Collections;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
//import java.util.*;  

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {

  private Graph g;
  private Vertex v;
  private Stack<Vertex> stack;
  private Set<Vertex> colored;

  public GraphIterator(Graph g, Vertex v) {
    this.g = g;
    this.v = v;
    stack = new Stack<Vertex>();
    colored = new TreeSet<Vertex>();
    this.reset();  
  }

  public void reset() {
    if(g!=null&&v!=null)
      stack.push(v);
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public Vertex next() {
    
    if(hasNext()) {
      Vertex temp=stack.pop();
      colored.add(temp);
      List<Vertex> neighbours = g.getNeighbours(temp);
      if(neighbours!=null){
      for(int i=neighbours.size()-1;i>=0;i--){
        
        if((!colored.contains(neighbours.get(i)) )&& stack.search(neighbours.get(i))==-1){
          stack.push(neighbours.get(i));
         }//if
       }//for
      }//if
      // System.out.println("temp id:"+temp.getId());
      return temp;

    }
    return null;
}
  
  @Override
  public void remove() {
    // Can be ignored.
  }
}

/**
 *  DO NOT MODIFY
 */
interface Vertex extends Comparable<Vertex> {

  /**
   * @return the id of the vertex
   */
  public int getId();

}

/**
 * Interface for a generic graph. You may assume that our implementation is an
 * undirected graph.
 */
interface Graph {

  /**
   * @param id
   *            to look for a vertex by.
   * @return the vertex or null if not found.
   */
  public Vertex getVertexById(int id);

  /**
   * Returns the neighbours in a sorted collection by id
   *
   * @param v
   *            node to get the neighbours of.
   * @return sorted collection of neighbours.
   */
  public List<Vertex> getNeighbours(Vertex v);

  /**
   * @return an unsorted collection of all vertices in the graph.
   */
  public Collection<Vertex> getAllVertices();

  /**
   * @return a sorted (small to large) list of all vertex ids in the graph.
   */
  public List<Integer> getAllIds();

}//
