package comp2402a3;

import java.util.LinkedList;
import java.util.Queue;
import java.io.PrintWriter;
import java.util.Random;

/**
 * An implementation of binary trees
 * @author morin
 *
 * @param <Node>
 */
public class BinaryTree<Node extends BinaryTree.BTNode<Node>> {

	public static class BTNode<Node extends BTNode<Node>> {
		public Node left;
		public Node right;
		public Node parent;
	}

	/**
	 * An extension of BTNode that you can actually instantiate.
	 */
	protected static class EndNode extends BTNode<EndNode> {
			public EndNode() {
				this.parent = this.left = this.right = null;
			}
	}

	/**
	 * Used to make a mini-factory
	 */
	protected Node sampleNode;

	/**
	 * The root of this tree
	 */
	protected Node r;

	/**
	 * This tree's "null" node
	 */
	protected Node nil;

	/**
	 * Create a new instance of this class
	 * @param sampleNode - a sample of a node that can be used
	 * to create a new node in newNode()
	 * @param nil - a node that will be used in place of null
	 */
	public BinaryTree(Node sampleNode, Node nil) {
		this.sampleNode = sampleNode;
		this.nil = nil;
		r = nil;
	}

	/**
	 * Create a new instance of this class
	 * @param sampleNode - a sample of a node that can be used
	 * to create a new node in newNode()
	 */
	public BinaryTree(Node sampleNode) {
		this.sampleNode = sampleNode;
	}

	/**
	 * Allocate a new node for use in this tree
	 * @return
	 */
	@SuppressWarnings({"unchecked"})
	protected Node newNode() {
		try {
			Node u = (Node)sampleNode.getClass().getDeclaredConstructor().newInstance();
			u.parent = u.left = u.right = nil;
			return u;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Compute the depth (distance to the root) of u
	 * @param u
	 * @return the distanct between u and the root, r
	 */
	public int depth(Node u) {
		int d = 0;
		while (u != r) {
			u = u.parent;
			d++;
		}
		return d;
	}

	/**
	 * Compute the size (number of nodes) of this tree
	 * @warning uses recursion so could cause a stack overflow
	 * @return the number of nodes in this tree
	 */
	public int size() {
		return size(r);
	}

	/**
	 * @return the size of the subtree rooted at u
	 */
	protected int size(Node u) {
		if (u == nil) return 0;
		return 1 + size(u.left) + size(u.right);
	}

	/**
	 * Compute the number of nodes in this tree without recursion
	 * @return
	 */
	public int size2() {
		Node u = r, prev = nil, next;
		int n = 0;
		while (u != nil) {
			if (prev == u.parent) {
				n++;
				if (u.left != nil) next = u.left;
				else if (u.right != nil) next = u.right;
				else next = u.parent;
			} else if (prev == u.left) {
				if (u.right != nil) next = u.right;
				else next = u.parent;
			} else {
				next = u.parent;
			}
			prev = u;
			u = next;
		}
		return n;
	}

	/**
	 * Compute the maximum depth of any node in this tree
	 * @return the maximum depth of any node in this tree
	 */
	public int height() {
		return height(r);
	}

	/**
	 * @return the height of the subtree rooted at u
	 */
	protected int height(Node u) {
		if (u == nil) return -1;
		return 1 + Math.max(height(u.left), height(u.right));
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		toStringHelper(sb, r);
		return sb.toString();
	}

	protected void toStringHelper(StringBuilder sb, Node u) {
			if (u == null) {
				return;
			}
			sb.append('(');
			toStringHelper(sb, u.left);
			toStringHelper(sb, u.right);
			sb.append(')');
	}


	/**
	 * @ return an n-node BinaryTree that has the shape of a random
	 * binary search tree.
	 */
	public static BinaryTree<EndNode> randomBST(int n) {
		Random rand = new Random();
		EndNode sample = new EndNode();
		BinaryTree<EndNode> t = new BinaryTree<EndNode>(sample);
		t.r = randomBSTHelper(n, rand);
		return t;
	}

	protected static EndNode randomBSTHelper(int n, Random rand) {
		if (n == 0) {
			return null;
		}
		EndNode r = new EndNode();
		int ml = rand.nextInt(n);
		int mr = n - ml - 1;
		if (ml > 0) {
			r.left = randomBSTHelper(ml, rand);
			r.left.parent = r;
		}
		if (mr > 0) {
			r.right = randomBSTHelper(mr, rand);
			r.right.parent = r;
		}
		return r;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return r == nil;
	}

	/**
	 * Make this tree into the empty tree
	 */
	public void clear() {
		r = nil;
	}

	/**
	 * Demonstration of a recursive traversal
	 * @param u
	 */
	public void traverse(Node u) {
		if (u == nil) return;
		traverse(u.left);
		traverse(u.right);
	}

	/**
	 * Demonstration of a non-recursive traversal
	 */
	public void traverse2() {
		Node u = r, prev = nil, next;
		while (u != nil) {
			if (prev == u.parent) {
				if (u.left != nil) {
					next = u.left;
				} else if (u.right != nil) {
					next = u.right;
				}	else {
					next = u.parent;
				}
			} else if (prev == u.left) {
				if (u.right != nil) {
					next = u.right;
				} else {
					next = u.parent;
				}
			} else {
				next = u.parent;
			}
			prev = u;
			u = next;
		}
	}

	/**
	 * Demonstration of a breadth-first traversal
	 */
	public void bfTraverse() {
		Queue<Node> q = new LinkedList<Node>();
		if (r != nil) q.add(r);
		while (!q.isEmpty()) {
			Node u = q.remove();
			if (u.left != nil) q.add(u.left);
			if (u.right != nil) q.add(u.right);
		}
	}

	/**
	 * Find the first node in an in-order traversal
	 * @return the first node reported in an in-order traversal
	 */
	public Node firstNode() {
		Node w = r;
		if (w == nil) return nil;
		while (w.left != nil)
			w = w.left;
		return w;
	}

	/**
	 * Find the node that follows w in an in-order traversal
	 * @param w
	 * @return the node that follows w in an in-order traversal
	 */
	public Node nextNode(Node w) {
		if (w.right != nil) {
			w = w.right;
			while (w.left != nil)
				w = w.left;
		} else {
			while (w.parent != nil && w.parent.left != w)
				w = w.parent;
			w = w.parent;
		}
		return w;
	}

	public int totalDepth() {
		// TODO: Your code goes here
		//depth is length of path to a node
		//so this is sum of all lengths to nodes
		//get first node. 0 depth find next node, +1 depth for that node then add it to a sum var.
		//keep doing this in a while loop till node becomes nil.
		if (isEmpty()) return -1;
		int sum = 0; //depth = 0 rn or depth(r) = 0 r is root node first node is the first node after root node
		int depth = 0;

		////////////////////////////////////
		Queue<Node> currlevel = new LinkedList<>();
		if (r!=nil)currlevel.add(r);
		while (!currlevel.isEmpty()){//each level depth
			Queue<Node> nextlevel = new LinkedList<>();
			depth++;
			for (Node currnode :currlevel){
				if (currnode.left != nil) {
					nextlevel.add(currnode.left);//if left isnt null, add left to queue;
					sum +=depth;
				}
				if (currnode.right != nil) {
					nextlevel.add(currnode.right);//if right isnt null, add right to queue;
					sum +=depth;
				}
			}

			currlevel = nextlevel;//next level of nodes
		}
		return sum;
	}
	public int totalLeafDepth() {
		// TODO: Your code goes here
		//sum of all lengths to nodes of leaf nodes(leaf node is a node with no left child and no right child)
		//find first node with no node.left and node.right. add +1 depth of node each time you search. once node is found then take the depth size and add to sum
		if (isEmpty()) return -1;
		int sum = 0; //depth = 0 rn or depth(r) = 0 r is root node first node is the first node after root node
		Node temp = firstNode(); //start using node after root or use root to start? but adds timecomplexity for no reason cus depth = 0 anyway
		if (isEmpty()){//return -1 if tree is empty
			return -1;
		}else{
			while(temp!= nil){
				if (temp.left==nil && temp.right == nil){//if its a leaf node then find depth of it and add to sum
					sum += depth(temp);
				}
				temp = nextNode(temp);
			}

		}
		return sum;
	} 
	public String bracketSequence() {
		StringBuilder sb = new StringBuilder();
		// TODO: Your code goes here, use sb.append()
		//read part 2c, needs multiple if statements, basically printing out bracket statements depending on contents of tree
		Node u = r, prev = nil, next;

		while (u != nil) {
			if(u.right == nil && u.left ==nil){
				sb.append("(..)");
			}
			if (prev == u.parent) {// prev node was parent of curr node so go left
				if (u.left != nil) {//go left child
					next = u.left;
					sb.append("(");
					//++
				} else if (u.right != nil) {//go right child
					//print
					next = u.right;
					sb.append("(.");
					//++
				}	else {//no left or right
					//print
					next = u.parent;
					//--
				}
			} else if (prev == u.left) {// prev node was left child, go right
				//print
				if (u.right != nil) {
					next = u.right;
					//++
				} else {
					next = u.parent;
					sb.append(".)");
					//--
				}
			} else {//came from right child go back to parent
				next = u.parent;
				sb.append(")");
				//--
			}
			prev = u;
			u = next;

		}
		//sb.append(")");
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(randomBST(30));
	}

}
