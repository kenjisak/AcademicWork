package comp2402a2;
import java.util.*;

public class FastMinDeque<T> implements MinDeque<T> {

  protected Comparator<? super T> comp;
  protected ArrayDeque<T> ds;
  protected FastMinStack<T> front;
  protected FastMinStack<T> back;
  public FastMinDeque() {
    this(new DefaultComparator<T>());
  }

  public FastMinDeque(Comparator<? super T> comp) {
    this.comp = comp;
    // TODO: Your code goes here
    ds = new ArrayDeque<T>();
    front = new FastMinStack<T>();
    back = new FastMinStack<T>();
  }

  public void addFirst(T x) {
    // TODO: Your code goes here
    ds.add(x);
    front.push(x);
  }

  public void addLast(T x) {
    // TODO: Your code goes here
   ds.addLast(x);
   back.push(x);
  }

  public T removeFirst() {
    // TODO: Your code goes here
    if (front.size() == 0 && back.size() > 0){
      balance();
    }else if(front.size() > 0){
      front.pop();
    }
    return ds.removeFirst();
  }

  public T removeLast() {
    // TODO: Your code goes here
    if (back.size() == 0 && front.size() > 0){
      balance();
    }else if(back.size() > 0){
      back.pop();
    }
    return ds.removeLast();
  }

  public T min() {
    // TODO: Your code goes here
    int frontsize = front.size();
    int backsize = back.size();
    if (frontsize != 0 && backsize !=0 ){
      if(comparator().compare(front.min(),back.min()) <=0){
        return front.min();
      }else{
        return back.min();
      }
    } else if (frontsize == 0 && backsize > 0) {
      return back.min();
    }else if  (backsize == 0 && frontsize > 0){//
      return front.min();
    }else{
      return null;
    }
  }

  public int size() {
    // TODO: Your code goes here
    return ds.size();
  }
  public void balance() {
    int n = size();
    if (3*front.size() < back.size()) {
      int s = n/2 - front.size();
      FastMinStack<T> l1 = new FastMinStack<>();
      FastMinStack<T> l2 = new FastMinStack<>();
      List<T> l = back.ds.subList(0,s);
      Collections.reverse(l);
      for (T x:l){
        l1.push(x);
      }
      for(T x :front.ds){
        l1.push(x);
      }
      for (T x: back.ds.subList(s, back.size())){
        l2.push(x);
      }
      front = l1;
      back = l2;
    } else if (3*back.size() < front.size()) {
      int s = front.size() - n/2;
      FastMinStack<T> l1 = new FastMinStack<>();
      FastMinStack<T> l2 = new FastMinStack<>();
      for (T x:front.ds.subList(s, front.size())){
        l1.push(x);
      }
      List<T> l = front.ds.subList(0, s);
      Collections.reverse(l);
      for(T x: l){
        l2.push(x);
      }
      for(T x: back.ds){
        l2.push(x);
      }
      front = l1;
      back = l2;
    }
  }
  public Iterator<T> iterator() {
    // TODO: Your code goes here
    return ds.iterator();
  }

  public Comparator<? super T> comparator() {
    return comp;
  }

}
