// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add additional methods and fields)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)


public class BinaryST
{
	private int size, distinct_size, height;
	private Node root;
	//private int height; //also not sure about this one
	private class Node {
		public Node left, right, parent;
		public String value;
		public int vals_in_left_tree; //need this for the rankOf method
		public int count; //tracks the number of times this string appears
		
		public Node(String val){
			this(null, null, null, val);
		}
		public Node(Node left, Node right, Node parent, String val){
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.value = val;
		}
		
	}
	// member fields and methods
	
	public BinaryST()
	{
		size = 0;
		root = null;
	}
	
	public BinaryST(String[] s)
	{
		for(int i=0; i<s.length; i++){
			//the add method will deal with increasing size, distinct size, etc. 
			this.add(s[i]);
		}
	}
	
	public int distinctSize()
	{
		return distinct_size;
	}
	
	public int size()
	{
		return size;
	}
	
	public int height()
	{
		// implementation
	}
	
	public void add(String s)
	{
		// implementation
	}
	
	public boolean search(String s)
	{
		if(root == null || s ==null) {
            return false;
        }
       Node n =  findRec(s, root);
       return n != null;
	}
	
	//recursive helper method to help search and frequency methods
	//returns null if the node was not found. if n = a node then it was found in the tree
	private Node findRec(String key, Node n) {
        if (n == null) {
            return null;
        } else {
            if (n.value.equals(key)) {
                return n;
            } else if (n.value.compareTo(key) > 0) {
                return findRec(key, n.left);
            } else { // n.value < key
                return findRec(key, n.right);
            }
        }

    }
	
	public int frequency(String s)
	{
		Node n = findRec(s, root);
		if(n == null){
			return 0;
		} else {
			return n.count;
		}
	}
	
	public boolean remove(String s)
	{
		// implementation
	}
	
	public String[] inOrder()
	{
		// implementation
	}
	
	public String[] preOrder()
	{
		// implementation
	}
	
	public int rankOf(String s)
	{
		// implementation
	}
}