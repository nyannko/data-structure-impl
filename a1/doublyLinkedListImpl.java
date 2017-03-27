class Solution {
 	  public static class Node
	  {
	    // Each node object has these three variables
	    private Object element;
	    private Node   next;
	    private Node   previous;
	    
	    // Constructor: Creates a Node object with element = e, next = n and previous = p
	    Node(Object e, Node n, Node p) 
	    {
	      element = e;
	      next    = n;
	      previous = p;
	    }
	  
	    // This function gets Object e as input and sets e as the element of the Node 
	    public void setElement(Object e) 
	    {
	      element = e;
	    }
	    
	    // This function returns the element variable of the Node
	    public Object getElement()
	    {
	      return element;
	    }
	    
	    // This function gets Node n as input and sets the next variable of the current Node object as n.
	    public void setNext(Node n) 
	    {
	      next = n;
	    }
	    
	    // This function returns the next Node
	    public Node getNext()
	    {
	      return next;
	    }
	    
	    // This function gets Node n as input and sets the previous variable of the current Node object as p.
	    public void setPrevious(Node p) 
	    {
	      previous = p;
	    }
	    
	    // This function returns the previous Node
	    public Node getPrevious()
	    {
	      return previous;
	    }
	    
	  }
	  
	  public static class DLList 
	  {
	  
	    // Each object in DLList has one variable head, which points to the starting Node of DLList.
	    private Node head;
	    private Node tail;
	    
	    // Implemens an empty constructor which initialises the head variable as null
	    DLList()
	    {
	      head = null;
	      tail = null;
	    }

	    // Returns the head node of the DLL
	    public Node getHead()
	    {
	      return head;
	    }
	    
	    

	    // Returns the tail node of the DLL
	    public Node getTail()
	    {
	    	return tail;
	    }
	    
	    // Following methods are the ones you are expected to implement
	    
	    // Adds node n to the head of the list.
	    public void addFirst(Node n)
	    {
		    if(head == null) {
		      	head = n;
		      	tail = n;
		      	n.setPrevious(null);
            n.setNext(null);
	   	  } else {
			    n.setNext(head);
			    n.setPrevious(null);
			    head.setPrevious(n);
		      	head = n;
		    }
		      // size++;
	     }
	    
	    //Removes and returns the first node in the list. If the list is empty, returns null.
	    public Node removeFirst()
	    {
	      if(size() > 0) {
			      Node first = head;
		      	head = head.getNext();
			      return first;
		    }else {
			      return null;
		    }
	    }
	    
	    // Adds node n to the end of the list
	    public void addLast(Node n)
	    {
        if(tail == null) {
		    	head = n;
	    		tail = n;
	    	} else {
	    		tail.setNext(n);
	    		n.setPrevious(tail);
	    		tail = n;
	     	}
		      // size++;
	    }
	      
	    //Removes and returns the last node in the list.If the list is empty, returns null.
	    public Node removeLast() {
	      Node last = tail;
        if (tail != null) {
            if (tail.getPrevious() != null) {
                tail = tail.getPrevious();
                tail.setNext(null);
            } else {
                head = tail = null;
            }
        }
        return last;
	    }
	    
	    // Returns the number of nodes in the list
	    public int size()
	    {
	      int size = 0;
	      for (Node node = head; node != null; node = node.getNext()) {
            size++;
        }
        return size;
	    }
	  
	    // Adds node n after the node in position pos. The list is zero indexed, so the first element in the list correspond
	    // to position 0. If there is no node in position pos, this method adds it to the last position.
	    public void addAtPosition(Node n, int pos)
	    {
		    //if(head == null) return;
        if(pos < 0 || pos >= size()) {addLast(n); return;}
        
        Node current = head;
        int i = 0;
        while(i < pos) {
          current = current.getNext();
          i++;
        }
        
        if(current.getNext() == null) {
          current.setNext(n);
          n.setPrevious(current);
          tail = n;
        } else {
          current.getNext().setPrevious(n);
          n.setNext(current.getNext());
          current.setNext(n);
          n.setPrevious(current);
        }
        // size++;  
	    }
	    
	    // Remove and return node n at position pos. The list is zero indexed, so the first element in the list correspond
	    // to position 0. If there is no node in position pos, this method returns null.
	    public Node removeFromPosition(int pos)
	    {
		    if(head == null) return null;
	      if(pos < 0 || pos >= size()) return null;
	      
	      Node current = head;
	      int i = 0;
	      while(i < pos) {
	        current = current.getNext();
	        i++;
	      }
	      
	      if(current.getNext() == null) {
	       return removeLast();
	      }else if(current.getPrevious() == null) {
	        return removeFirst();
	      }else{
	        current.getPrevious().setNext(current.getNext());
	        current.getNext().setPrevious(current.getPrevious());
	      }
	      return current;	  
	    }
	    
	    // Returns  a new DLL that contains the elements of the current one in reversed order
	    public DLList reverse()
	    {
	      DLList L = new DLList();
	      Node p = this.getHead();
	      Node temp = null;
	      
	      if(this.size() <= 0) {
	        return L;
	      }else if(this.size() == 1) {
	        L.addFirst(p);
	        return L;
	      }else {
	        for(int i = 0; i < this.size(); i++) {
	              temp = new Node(p.element, p.getNext(), p.getPrevious());
                L.addFirst(temp);
                p = p.getNext();
	        }
	        return L;
	      }
	    }
	  
	  }
}
