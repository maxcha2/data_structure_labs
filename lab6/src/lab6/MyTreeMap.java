/*
 * class MyTreeMap<K,V>
 * This implements AVL trees.
 * 
 * An "empty" node is one whose children are both null.
 * A "leaf" node is one whose children are both empty.
 * This lets us avoid continually checking if a node is null.
 */

package lab6;

public class MyTreeMap<K extends Comparable<? super K>,V> {
	// Note that the Node class has some handy utility methods:
	// isEmpty() and isLeaf(), tallestChild(), and setHeight()
	// You should not need to modify the Node class.
	class Node {
		K key;
		V value;
		int height;
		Node leftChild, rightChild;
		
		public Node(K key, V value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.leftChild = left;
			this.rightChild = right;
			this.height = -1;
		}
		
		// makes a new empty node
		public Node() {
			this(null,null,null,null);
		}
		
		// Makes a new leaf node
		public Node(K key, V value) {
			this(key, value, new Node(), new Node());
			this.height = 0;
		}
		
		
		boolean isEmpty( ) {
			return this.leftChild == null && this.rightChild == null;
		}
		
		boolean isLeaf() {
			return this.leftChild.isEmpty() && this.rightChild.isEmpty();
		}
		
		Node tallestChild() {
			if (leftChild.height > rightChild.height)
				return leftChild;
			else return rightChild;
		}
		
		public void setHeight() {
			height = 1 + Math.max(leftChild.height, rightChild.height);
	
		}
						
	} //closes the Node class
 
	private Node root;
	private int size;
	
	public MyTreeMap( ) {
		root = newEmptyNode();
		size = 0;
	}
	
	// A factory method for the tree class to make an empty node
	Node newEmptyNode() {
		return new Node();
	}
	
	// A factory method for the tree class to make a leaf node
	Node newLeafNode(K key, V value) {
		return new Node(key, value);
	}

	public int height() {
		return root.height;
	}
			
	public int size() {
		return size;
	}
	
	public V get(K key) {
		return search(key, root);
	}
	
	private V search(K key, Node t) {
    	// This is a recursive method that returns
    	// the value associated with the given key
    	// on or below node t. If no node has this
    	// key return null.
    	// Before you compare the key with t's key
    	// check to see if t is empty; if so just 
    	// return null.I
    	if (t.isEmpty()) {
    		return null;
    	}
    	else {
    		if (key.compareTo(t.key) == 0) {
    			return t.value;
    		}
    		else if (key.compareTo(t.key) < 0) {
    			return search(key, t.leftChild);
    		}
    		else {
    			return search(key, t.rightChild);
    		}
    	}
    }
    
    public V put(K key, V value){
    	V temp = search(key, root); 
    	root = insert(key, value, root);
    	return temp;
    }
    
    //returns the tree that results from adding
    // (key, value) to the tree rooted at t
    private Node insert(K key, V value, Node t) {
    	// This is a recursive insert method.  It returns
    	// the tree that results from inserting (key, value) 
    	// into t. It has a similar structure to search.  It
    	// starts by asking if t is empty, and if so it returns
    	// a new leaf node. If t is not empty you can compare
    	// key to t.key and take action based on this comparison.
    	// When you create a new leaf node you should 
    	// increment the tree's size variable. When you return from a 
    	// recursive call that updates one of t's children
    	// (e.g. t.leftChild = insert(key, value, t.left))
    	// you should check the AVL property and possibly 
    	// call adjust(t), and then recompute t's height.
    	if (t.isEmpty()) {
    		return newLeafNode(key, value);
    	}
    	else {
    		if( key.compareTo(t.key) == 0) {
    			value = t.value;
    			return t;
    		}
    		else if ( key.compareTo(t.key) < 0) {
    			t.leftChild = insert(key, value, t.leftChild);
    			if (Math.abs(t.leftChild.height - t.rightChild.height) > 1)
    				t = adjust(t);
    			t.setHeight();
    			return t;
    		}
    		else {
    			t.rightChild = insert(key, value, t.rightChild);
    			if (Math.abs(t.leftChild.height - t.rightChild.height) > 1)
    				t = adjust(t);
    			t.setHeight();
    			return t;
    		}
    	}
    }
  
   // This rearranges the tree to maintain balance after
   // an insertion.  Z is the tree node that failed the AVL
   // test.  Y is Z's taller child, X is Y's taller child.
   // a, b, and c are X, Y, and Z in increasing order.
   // t1 through t4 are the 4 children of a, b, and c that are
   // not themselves one of a, b, and c.
   // Once you have identified all of these you should return
   // the tree
   //           b
   //         /   \
   //        a     c
   //       / \   / \
   //      t1 t2 t3 t4
   //
   // Before returning b call a.setHeight(), c.setHeight() and
   // b.setHeight();
    
   private Node adjust(Node Z) {
		Node X, Y, a, b, c, t1, t2, t3, t4;
		a=b=c=null;
		t1=t2=t3=t4=null;
		// Step 1: make Y be Z's tallest child and
		// X be Y's tallest child.  The Node class
		// has a tallestChild( ) method.
		
		// Step 2: You need to assign a, b, and c.
		// Step 3: You need to assign t1 throuh t4
		// If Y is Z's left child and X is Y's left child
		// the tree looks like this:
		//              Z
		//             / \
		//            Y   
		//           / \
		//          X
		//         / \		
		//
		// In this case a is X, b is Y and c is Z.
		// t1 is X.leftChild, t2 is X.rightChild, t3 is Y.rightChild
		// t4 is Z.rightChild.  You do the other 3 cases.
		//
		// Once you have assigned all 9 variables build the
		// tree shown above, recompute the heights of a, c,
		// and b, and return b.
		Y = Z.tallestChild();
		X = Y.tallestChild();
		if (Y == Z.leftChild && X == Y.leftChild) {
			a = X;
			b = Y;
			c = Z;
			t1 = a.leftChild;
			t2 = a.rightChild;
			t3 = b.rightChild;
			t4 = c.rightChild;
		}
		else if (Y == Z.leftChild && X == Y.rightChild) {
			a = Y;
			b = X;
			c = Z;
			t1 = a.leftChild;
			t2 = b.leftChild;
			t3 = b.rightChild;
			t4 = c.rightChild;
		}
		else if (Y == Z.rightChild && X == Y.leftChild) {
			a = X;
			b = Z;
			c = Y;
			t1 = b.leftChild;
			t2 = a.rightChild;
			t3 = a.leftChild;
			t4 = c.rightChild;
		}
		else if (Y == Z.rightChild && X == Y.rightChild) {
			a = Z;
			b = Y;
			c = X;
			t1 = a.leftChild;
			t2 = b.leftChild;
			t3 = c.leftChild;
			t4 = c.rightChild;
		}
		a.leftChild = t1;
		a.rightChild = t2;
		a.setHeight();
		c.leftChild = t3;
		c.rightChild = t4;
		c.setHeight();
		b.leftChild = a;
		b.rightChild = c;
		b.setHeight();
		return b;
		
	}
    
   // This will help you with debugging.It prints the keys
   // on each level of the tree.
    public void treePrinter() {
    	for (int level = 0; level <= root.height; level++ ) {
    		System.out.printf("Level %d: ", level);
    		printLevel(level, root);
    		System.out.println();
    	}
    }
    
    public void printLevel(int level, Node t) {
    	if (!t.isEmpty()) {
    		if (level == 0)
    			System.out.printf(  "%s ", t.key);
    		else {
    			printLevel(level-1, t.leftChild);
    			printLevel(level-1, t.rightChild);
    		}
    	}
    }
}


