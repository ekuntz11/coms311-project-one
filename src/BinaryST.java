// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add additional methods and fields)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)


public class BinaryST
{
	private int size;
	private Node head;
	//private int distinctsize; //not sure if we will need this... what do you think?
	//private int height; //also not sure about this one
	private class Node {
		public Node left;
		public Node right;
		public Node parent;
		public String value;
		public int vals_in_left_tree; //need this for the rankOf method
		//public int count; //this could be used in order to store the number of times the string appears... not sure which way is best for doing this
		
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
		// implementation
	}
	
	public BinaryST(String[] s)
	{
		// implementation
	}
	
	public int distinctSize()
	{
		// implementation
	}
	
	public int size()
	{
		// implementation
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
		// implementation
	}
	
	public int frequency(String s)
	{
		// implementation
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