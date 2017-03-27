class ArrayStack {
	private Object[] elements;
	private int size;
	private int capacity;

	// post: Empty StackArray with capacity 1
	public ArrayStack() {
		this.size = 0;
		this.capacity = 1;
		this.elements = new Object[capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size <= 0) {
			return true;
		}
		return false;
	}

	// post: returns true iff capacity is fully used
	public boolean isFull() {
		if (size >= capacity) {
			return true;
		}
		return false;
	}

	public Object peek() throws EmptyStackException {
	  if(!isEmpty()) {
			return elements[size - 1];
	  }else {
	    throw new EmptyStackException();
	  }
	}

	/**
	 * pre: the stack is not full post: o added to the stack. If capacity of
	 * stack was too small, capacity is doubled and o is added.
	 */
	public void push(Object o) {
		if (!isFull()) {
			size++;
			elements[size - 1] = o;
		} else {
			capacity *= 2;
			Object[] temp = new Object[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = elements[i];
			}

			elements = new Object[capacity];
			for (int i = 0; i < size; i++) {
				elements[i] = temp[i];
			}
			size++;
			elements[size - 1] = o;
		}
	}

	/**
	 * @return the element which was at the top of the stack, If removing top
	 *         would make the stack use less than 25% of its capacity, then the
	 *         capacity is halved.
	 * @throws EmptyStackException
	 *             iff the queue is empty
	 */
	public Object pop() throws EmptyStackException {
		Object top = peek();
		size--;
		if (size < capacity / 4) {
			capacity /= 2;
			Object[] temp = new Object[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = elements[i];
			}

			elements = new Object[capacity];
			for (int i = 0; i < size; i++) {
				elements[i] = temp[i];
			}
		}
		return top;
	}

	/**
	 * post: returns a String representation of the ArrayStack Example output
	 * for ArrayStack with 2 elements and capacity 5: <ArrayStack[1,2]>(Size=2,
	 * Cap=5)
	 */
	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str = str + elements[i] + ",";
		}
		if (size > 0) {
			str = str.substring(0, str.length() - 1);
		}
		str = str + "]";
		return "<ArrayStack" + str + ">" + "(Size=" + size + ", " + "Cap=" + capacity + ")";
	}

	// For testing, do not remove or change.
	public Object[] getElements() {
		return elements;
	}

}
