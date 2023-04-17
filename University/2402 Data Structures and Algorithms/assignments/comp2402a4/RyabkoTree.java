package comp2402a4;

import java.util.Iterator;

public class RyabkoTree implements PrefixStack {
  int n;  // number of items stored in the structure
  int h;  // height of the structure
  long[] sums;

  public RyabkoTree() {
    n = 0;
    h = 1;
    sums = new long[(2<<h) - 1];
  }

  protected void grow() {
    // the height of our prefix-sum tree is going up by 1
    h += 1;
    long[] tmp = new long[(2<<h) - 1];
    System.arraycopy(sums, 0, tmp, 1, sums.length);
    sums = tmp;
    sums[0] = sums[1];  // since right subtree of root is empty
  }

  protected void updateSums(int i, int delta) {
    long sum = 0;
    int c = 1<<(h-1);
    int j = 0;
    while (c > 0) {
      sums[j] += delta;  // go to right child
      if ((i & c) == 0) {
        j += 1; // go to left child
      } else {
        j += 2*c;
      }
      c >>= 1;
    }
    sums[j] += delta;
  }

  public void push(int x) {
    if (n == 1<<h) {
      grow();
    }
    int i = n++;
    updateSums(i, x);
  }

  public int pop() {
    int i = n-1;
    int x = get(i);
    updateSums(i, -x);
    n--;
    return x;
  }


  public int get(int i) {
    if (i < 0 || i >= n) {
      throw new IndexOutOfBoundsException();
    }
    int c = 1<<(h-1);
    int j = 0;
    while (c > 0) {
      if ((i & c) == 0) {
        j += 1; // go to left child
      } else {
        j += 2*c;
      }
      c >>= 1;
    }
    return (int)sums[j];
  }

  public int set(int i, int x) {
    int oldx = get(i);
    int delta = x - oldx;
    updateSums(i, delta);
    return oldx;
  }

  public long prefixSum(int i) {
    long sum = 0;
    int c = 1<<(h-1);
    int j = 0;
    while (c > 0) {
      if ((i & c) == 0) {
        j += 1; // go to left child
      } else {
        sum += sums[j+1]; // skip over left child
        j += 2*c; // go to right child
      }
      c >>= 1;
    }
    return sum + sums[j];
  }

	public int size() {
    return n;
	}

	public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      int i = 0;
      public Integer next() {
        return get(i++);
      }

      public boolean hasNext() {
        return i < n;
      }
    };
	}

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < n; i++) {
      sb.append(Integer.toString(get(i)));
      sb.append('(');
      sb.append(Long.toString(prefixSum(i)));
      sb.append(')');
      if (i < n-1) {
        sb.append(',');
      }
    }
    sb.append(']');
    return sb.toString();
  }

  public static void main(String[] args) {
    int n = 20;
    PrefixStack ps = new RyabkoTree();
    for (int i = 0; i < n; i++) {
      ps.push(1);
    }
    System.out.println(ps);

    for (Integer x : ps) {
      System.out.printf("%d,", x);
    }
    System.out.println("");
  }
}
