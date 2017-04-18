import java.util.HashSet;
import java.util.Iterator;

class MySet extends HashSet<String> {
  private static final long serialVersionUID = 1L;
  
  
  public MySet() {
    
    super();
  }
  
  // post: returns the union of the elements of this and that
  // +union(that : MySet) : MySet  
  public MySet union(MySet that) {
    MySet result = new MySet();
    Iterator<String> it = this.iterator();
    while(it.hasNext()) {
      String a = it.next();
      result.add(a);
    }
    it = that.iterator();
    while(it.hasNext()) {
      String a = it.next();
      if(!result.contains(a)){
        result.add(a);
      }
    }
    
    return result;
  }
  
  // post: returns the intersection of the elements of this and that
  // +intersection(that : MySet) : MySet  
  public MySet intersection(MySet that) {
    MySet result = new MySet();
    Iterator<String> it = this.iterator();
    while(it.hasNext()) {
      String a = it.next();
      if(that.contains(a)) {
        result.add(a);
      }
    }

    return result;
  }
  
  // post: returns the difference of the elements of this and that
  // +difference(that : MySet) : MySet
  public MySet difference(MySet that) {
    MySet result = new MySet();
    Iterator<String> itTemp = this.iterator();
    while(itTemp.hasNext()){
      result.add(itTemp.next());
    }
    
    MySet inte = intersection(that);
    
    Iterator<String> it = result.iterator();
    while(it.hasNext()) {
      String a = it.next();
      if(inte.contains(a)) {
        it.remove();
      }
    }
    System.out.println("This_size"+this.size());
    return result;
  }
 
  // post: returns the exclusive or (XOR) of the elements of this and that
  // +difference(that : MySet) : MySet
  public MySet exclusiveOr(MySet that) {
    MySet result = new MySet();
    result = union(that);
    MySet inte = intersection(that);
    Iterator<String> it = result.iterator();
    while(it.hasNext()) {
      String a = it.next();
      if(inte.contains(a)) {
        it.remove();
      }
    }
    return result;
  }
  
  // post: returns a String representation of a MySet object
  // +toString()
  public String toString() {
    Iterator<String> it = this.iterator();
    String b = "";
    while(it.hasNext()) {
      String a = it.next();
      b += a + ",";
    }
    int size = b.length() - 1;
    b = b.substring(0,size);
    return "<MySet{" + b + "}>";   
  }
}
//
