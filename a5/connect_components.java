import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;
import java.util.Stack;

class Solution {

  public static int numberOfConnectedComponents(Graph g) {
   
    int size = 0;
    Collection<Vertex> unexplored = g.getAllVertices();
    // System.out.println(unexplored);
    if( unexplored.size() == 0) {
      return 0;
    }
     while(unexplored.size()>0){
       System.out.println(unexplored);
       Vertex v = unexplored.iterator().next();
      // System.out.println("Outer"+v);
       Iterator<Vertex> it = new GraphIterator(g,v);
       unexplored.remove(v);
       while(it.hasNext()){
        Vertex u = it.next();
        // System.out.println("Inner"+u);
        unexplored.remove(u);
     } 
    
     size ++ ;
       
     }
     

    // unexplored.remove(v);
    // size ++;
    
    return size;
  }
}

/**
 * DO NOT MODIFY 
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
