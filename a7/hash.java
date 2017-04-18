import java.util.LinkedList;

class Entry {

	public String key;
	public Integer value;

	public Entry(String s, Integer v)
	{
		key = s;
		value = v;
	}

	public boolean equals(String s) {
		return key.equals(s);
	}

	@Override
	public boolean equals(Object s) {
		if (s instanceof Entry) {
			Entry that = (Entry) s;
			return key.equals(that.key);
		}
		return key.equals(s);
	}

	public int getValue() {
		return value;
	}
}

abstract class Hashtable {

  // Entry objects are rused to represent "Key-Value" pairs.
  // An entry can be created by using new Entry(String key, Integer Value)
  // The .equals() method of Entry will compare the keys only.
	private LinkedList<Entry>[] myTable;
  
	/**
	 * Constructs a new hashTable.
	 *
	 * @param size
	 *            to be used as size of the table.
	 */
	@SuppressWarnings("unchecked")
	public Hashtable(int size) {
	    myTable = new LinkedList[size];
	    for(int i = 0; i < size; i++) {
	      myTable[i] = new LinkedList<>();
	    }
	}

	// Required by the LibraryTable to print statistics
	protected LinkedList<Entry>[] getTable() {
		return myTable;
	}

	/**
	 * Add a key value pair to the hashTable.
	 *
	 * @param key
	 *            to identify the value.
	 * @param value
	 *            that is identified by the key.
	 */
	public void put(String key, Integer value) {
	  int index=hash(key);
	  if(!containsKey(key)) {
	    myTable[index].add(new Entry(key, value));
	  }
	  else{
	     for(Entry s: myTable[index]) {
	      if (s.equals(key)){
	        s.value=value;
	        break;
	      }
	    }
	  }

        
	}

	/**
	 * @param key
	 *            to look for in the table.
	 * @return true iff the key is in the table.
	 */
	public boolean containsKey(String key) {
	  for(int i = 0; i < myTable.length; i++) {
	    for(Entry s: myTable[i]) {
	      if (s.equals(key)){
	        return true;
	      }
	    }
	  }
     return false;
	}

	/**
	 * Get a value from the hashtable.
	 *
	 * @param key
	 *            that identifies the value.
	 * @return the value associated with the key or 0 if the key is not in the
	 *         table.
	 */
	public int get(String key) {
	  if(containsKey(key)){
	    int index=hash(key);
	    for(Entry s: myTable[index]){
	      if(s.equals(key))
	        return s.getValue();
	    }
	  }
		return 0;
	}

	/**
	 * @return the size of the table.
	 */
	public int getSize() {
		return myTable.length;
	}

	/**
	 * Hashes a string/key.
	 *
	 * @param item
	 *            to hash.
	 * @return the hashcode of the string.
	 */
	public abstract int hash(String item);
	
}
class ETHHash extends Hashtable {

    int size;
	public ETHHash(int size) {
		super(size);
		this.size = size;
	}

	@Override
	public int hash(String item) {
	  if(item==null)  return 0;
	  
	  int b = 1;
	  for (int i=0; i<item.length(); i++) {
		  b = (int)item.charAt(i) * ((b % 257) + 1);
	  }
	  int c = this.size;
	 // System.out.println(c);
	  return b % this.size;
	}

}

class GNUCPPHash extends Hashtable {
  int size;
	public GNUCPPHash(int size) {
		super(size);
		this.size = size;
	}

	@Override
	public int hash(String item) {
	   if(item==null)  return 0;
	  int b = 0;
	  for (int i=0; i<item.length(); i++) {
		  b = (int)item.charAt(i) + 4*b;
	  }
	  int temp= b & ((1<<31) -1);
    return temp % this.size;
	}

}

class GNUCC1Hash extends Hashtable {
  int size;
	public GNUCC1Hash(int size) {
		super(size);
		this.size = size;
	}

	@Override
	public int hash(String item) {
	   if(item==null)  return 0;
	  int b = item.length();
	  for (int i=0; i<item.length(); i++) {
		  b = (int)item.charAt(i) + 613*b;
	  }
	  int temp= b & ((1<<30) -1);
    return temp % this.size;
	  

	}

}

class HashCodeHash extends Hashtable {
  int size;
	public HashCodeHash(int size) {
		super(size);
		this.size=size;
	}

	@Override
	public int hash(String item) {
	   if(item==null)  return 0;
	  int len=item.length();
	  int b = 0;
	  for (int i=0; i<len; i++) {
	    int temp=((int) (item.charAt(i))) ;
		  b =temp+ b*31 ;
	  }
	  int ans=(Math.abs(b))%size;
		return ans;
	}

}//
