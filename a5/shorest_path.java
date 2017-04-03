import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Solution {

  /**
   * Find the shortest path between v and u in the graph g.
   *
   * @param g
   *            graph to search in.
   * @param v
   *            node to start from.
   * @param u
   *            node to reach.
   * @return the nodes that form the shortest path, including v and u. An
   *         empty list iff there is no path between v and u.
   */
  public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
    System.out.println("Graph="+v+"to"+u);
    Map<Vertex, Vertex> predecessors = new TreeMap<>();
    List<Vertex> list = new ArrayList<>();
    boolean foundFlag=false;
    // Note: You can use the GraphIterator(Graph, Vertex) constructor to get
    // a BFS iterator as you built for the previous assignment.
    GraphIterator it = new GraphIterator(g, v);
    
    if(u==v)
    { list.add(u);
      return list;
    }
    
    while(it.hasNext()) {
      Vertex temp = it.next();
      System.out.println("temp="+temp);
      Collection<Vertex> c = g.getNeighbours(temp);
      Iterator<Vertex> ii=c.iterator();
      // System.out.println(c);
      if(c!=null && c.size() > 0) {
        for(int i = 0; i < c.size(); i++) {
          Vertex nextV=ii.next();
          if(!predecessors.containsValue(nextV)&&!predecessors.containsKey(nextV)){
            System.out.println("i=\t"+i+"Add path:"+nextV + temp);
            predecessors.put(nextV, temp);
            
          }
        }//for
      if(predecessors.containsKey(u)) {
        foundFlag=true;
        break;
      }
    }//if
  }//while
  
    if(!foundFlag){
      return list;
    }

    System.out.println("fuck predec u:"+predecessors);
    list.add(u);
    System.out.println("Shit u:"+list);
    Vertex newkey=u;
    while(newkey!=v && newkey!=null) {
      
      newkey = predecessors.get(newkey);
      // Vertex m = predecessors.get(newkey);
      System.out.println("newkey"+newkey);
      list.add(newkey);
      // newkey = predecessors.get(newkey);
    }
    
    System.out.println("Shit llll:"+u+list);
    if(list!=null){
      Collections.reverse(list);
      System.out.println("list! :"+ list);
    }
    return list;
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
	public Collection<Vertex> getNeighbours(Vertex v);

	/**
	 * @return an unsorted collection of all vertices in the graph.
	 */
	public Collection<Vertex> getAllVertices();

}//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.TreeMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//class Solution {
//
//  /**
//   * Find the shortest path between v and u in the graph g.
//   *
//   * @param g
//   *            graph to search in.
//   * @param v
//   *            node to start from.
//   * @param u
//   *            node to reach.
//   * @return the nodes that form the shortest path, including v and u. An
//   *         empty list iff there is no path between v and u.
//   */
//  public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
//    
//    Map<Vertex, Vertex> predecessors = new TreeMap<>();
//    List<Vertex> list = new ArrayList<>();
//    
//    // Note: You can use the GraphIterator(Graph, Vertex) constructor to get
//    // a BFS iterator as you built for the previous assignment.
//    GraphIterator it = new GraphIterator(g, v);
//    while(it.hasNext()) {
//    //  Collection <Vertex> c=g.getNeighbours(it.next());
//      temp = it.next();
//      Collection c = g.getNeighbours(temp);
//      if(c.size()>0) {
//        for(int i = 0; i < c.size(); i++) {
//          predecessors.put(c.get(i), temp);
//        }
//      if(predecessors.containsKey(v)) {
//        break;
//      }
//    }
//  }
//    list.add(u);
//    Vertex newkey = predecessor.get(u);
//    
//    while(!predecessors.containsKey(v)) {
//      Vertex m = predecessors.containsKey(newkey);
//      list.add(m);
//      newkey = predecessor.get(m);
//    }
//    
//    Collections.reverse(aList);
//}
//
///**
// * DO NOT MODIFY
// */
//interface Vertex extends Comparable<Vertex> {
//
//	/**
//	 * @return the id of the vertex
//	 */
//	public int getId();
//
//}
//
///**
// * Interface for a generic graph. You may assume that our implementation is an
// * undirected graph.
// */
//interface Graph {
//
//	/**
//	 * @param id
//	 *            to look for a vertex by.
//	 * @return the vertex or null if not found.
//	 */
//	public Vertex getVertexById(int id);
//
//	/**
//	 * Returns the neighbours in a sorted collection by id
//	 *
//	 * @param v
//	 *            node to get the neighbours of.
//	 * @return sorted collection of neighbours.
//	 */
//	public Collection<Vertex> getNeighbours(Vertex v);
//
//	/**
//	 * @return an unsorted collection of all vertices in the graph.
//	 */
//	public Collection<Vertex> getAllVertices();
//
//}//
