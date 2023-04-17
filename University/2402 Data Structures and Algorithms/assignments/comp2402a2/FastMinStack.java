package comp2402a2;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FastMinStack<T> implements MinStack<T> {

  protected Comparator<? super T> comp;
  protected LinkedList<T> ds;
  protected LinkedList<T> minvalue;
  public FastMinStack() {
    this(new DefaultComparator<T>());
  }

  public FastMinStack(Comparator<? super T> comp) {
    this.comp = comp;
    // TODO: Your code goes here
    ds = new LinkedList<T>();
    minvalue =  new LinkedList<T>();
  }

  public void push(T x) {
    // TODO: Your code goes here
    if (ds.size() == 0||comparator().compare(x, minvalue.getLast()) <= 0){
      ds.add(x);
      minvalue.add(x);
    }else{
      ds.add(x);
    }
  }

  public T pop() {
    // TODO: Your code goes here
    if (ds.getLast()== minvalue.getLast()){
      minvalue.remove(minvalue.size()-1);
    }
    return ds.remove(ds.size()-1);
  }
  public T min() {
    // TODO: Your code goes here
    return minvalue.getLast();
  }

  public int size() {
    // TODO: Your code goes here
    return ds.size();
  }

  public Iterator<T> iterator() {
    // TODO: Your code goes here
    return ds.iterator();
  }

  public Comparator<? super T> comparator() {
    return comp;
  }
}
