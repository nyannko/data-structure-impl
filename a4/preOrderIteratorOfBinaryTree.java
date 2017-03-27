import java.util.Iterator;
import java.util.Stack;

/**
 * Iterates lazy over a binarytree in a pre-order depth-first manner. For instance a tree
 * with 8 as it's root and 4 and 10 as it's children should be iterated as: 8 ->
 * 4 -> 10.
 */
class BinaryTreeIterator<V> implements Iterator<V> {
  Stack<Position<V>> stack;
  BTree<V> tree;
	/**
	 * Constructor.
	 * Should reset on a new tree.
	 * @param tree
	 *            takes the tree
	 */
	public BinaryTreeIterator(BTree<V> tree) {
	  stack = new Stack<Position<V>>();
	  this.tree=tree;
    this.reset();
	}

	/**
	 * Resets the iterators to start again.
	 */
	private void reset() {
	  if(tree.getRoot() != null){
		  stack.push(tree.getRoot());
		}
	  
	}

	/**
	 * @return True if there is a next element in the iterator, else False
	 */
	@Override
	public boolean hasNext() {
	  return !stack.isEmpty();
	}

	/**
	 * Get the next element of the iterator and shift 
	 * iterator by one.
	 * @return current element value
	 * @post iterator is moved to next element
	 */
	@Override
	public V next() {
		if(hasNext()) {
		  Position<V> x = stack.pop();
		  V item = x.getValue();
		try{
	    if(tree.hasRight(x)) {
		  stack.push(tree.getRight(x));
		  }	
		  if(tree.hasLeft(x)) {
		  stack.push(tree.getLeft(x));
	    }
		}
		catch(Exception InvalidPositionException) {
		}
		
		  return item;
		}
		  return null;
	}
	
	/**
	 * Skip a single element of the iterator.
	 * @post iterator is moved to next element.
	 */
	@Override
	public void remove() {
	  if(hasNext()) {
		  Position<V> x = stack.pop();
		try{
	    if(tree.hasRight(x)) {
		    stack.push(tree.getRight(x));
		  }	
			  
		  if(tree.hasLeft(x)) {
		    stack.push(tree.getLeft(x));
		  }}
		catch(Exception InvalidPositionException) {
		}
		}
	}
}

/** DO NOT MODIFY */
interface Position<V> {

	/**
	 * @return the key of this position.
	 */
	public int getKey();

	/**
	 * @return the value of the position.
	 */
	public V getValue();
}

interface BTree<V> {

	/**
	 * @return the root of the tree
	 */
	public Position<V> getRoot();

	/**
	 * Get the left child of a position.
	 *
	 * @param v
	 *            the position to get the child of.
	 * @return the child of the position iff hasLeft(v) is true.
	 * @throws InvalidPositionException
	 *             else
	 */
	public Position<V> getLeft(Position<V> v) throws InvalidPositionException;

	/**
	 * Get the right child of a position.
	 *
	 * @param v
	 *            the position to get the child of.
	 * @return the child of the position iff hasRight(v) is true.
	 * @throws InvalidPositionException
	 *             else
	 */
	public Position<V> getRight(Position<V> v) throws InvalidPositionException;

	/**
	 * Check if a position has a left child.
	 *
	 * @param v
	 *            position to check.
	 * @return true iff v has a left child.
	 * @throws InvalidPositionException
	 *             if v is not valid (e.g. null)
	 */
	public boolean hasLeft(Position<V> v) throws InvalidPositionException;

	/**
	 * Check if a position has a right child.
	 *
	 * @param v
	 *            position to check.
	 * @return true iff v has a right child.
	 * @throws InvalidPositionException
	 *             if v is not valid (e.g. null)
	 */
	public boolean hasRight(Position<V> v) throws InvalidPositionException;

	/**
	 * Adds a new entry to the tree.
	 *
	 * @param key
	 *            to use.
	 * @param value
	 *            to add.
	 */
	public void add(int key, V value);
}
