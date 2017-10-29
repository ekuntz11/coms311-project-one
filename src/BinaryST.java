import java.util.ArrayList;

// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add additional methods and fields)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
 * Binary Search Tree class
 * @author Eva Kuntz & Merritt Harvey
 */
public class BinaryST
{
	private int size, distinct_size, height;
	private Node root;
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
			this.count = 1;
			this.vals_in_left_tree = 0;
		}
		
		public boolean remove(String value, Node parent) {
            if (value.compareTo(this.value) < 0) {
                  if (left != null)
                        return left.remove(value, this);
                  else
                        return false;
            } else if (value.compareTo(this.value) > 0) {
                  if (right != null)
                        return right.remove(value, this);
                  else
                        return false;
            } else {
                  if (left != null && right != null) {
                        this.value = right.minValueForRemoving();
                        right.remove(this.value, this);
                  } else if (parent.left == this) {
                        parent.left = (left != null) ? left : right;
                  } else if (parent.right == this) {
                        parent.right = (left != null) ? left : right;
                  }
                  return true;
            }
      }
 
      public String minValueForRemoving() {
            if (left == null){
            	return value;
            } else {
            	vals_in_left_tree--;
            	return left.minValueForRemoving();
            }                     
      }
		
	}
	
	public BinaryST()
	{
		size = 0;
		height = 0;
		root = null;
	}
	
	public BinaryST(String[] s)
	{
		size = 0;
		height = 0;
		root = null;
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
		return height;
	}
	
	public void add(String s)
	{
	    if(root == null) {
	        root = new Node(s);
	        size++;
	        distinct_size++;
	        height++;
	    } else {
	        Node current = root;
	        int cur_height = 1;
	        while(true) {
	            int comp = current.value.compareTo(s);
	            if(comp == 0) {
	            	current.count++;
	            	size++;
	                return;
	            } else if (comp > 0) { //current.val > s
	                if(current.left != null) {
	                	current.vals_in_left_tree++;
	                    current = current.left;
	                    cur_height++;
	                } else {
	                	current.vals_in_left_tree++;
	                    current.left = new Node(null,null,current, s);
	                    size++;
	                    distinct_size++;
	                    if(cur_height == height){
	                    	height++;
	                    }
	                    return;
	                }
	            } else { // current.value < s
	                if(current.right != null) {
	                    current = current.right;
	                    cur_height++;
	                } else {
	                    current.right = new Node(null,null,current,s);
	                    size++;
	                    distinct_size++;
	                    if(cur_height == height){
	                    	height++;
	                    }
	                    return;
	                }
	            }
	        }
	        
	    }
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
		if (root == null || s == null) {
            return false;
        } else {
            Node n = findRecForDelete(s, root);
            if (n == null) {
                return false;
            }
            if(n.count > 1){
            	n.count--;
            	size--;
            } else {
            	root.remove(s, null);
            	size--;
            	distinct_size--;
            }
            return true;
        }
	}
	
	private Node findRecForDelete(String key, Node n) {
        if (n == null) {
            return null;
        } else {
            if (n.value.equals(key)) {
                return n;
            } else if (n.value.compareTo(key) > 0) {
            	n.vals_in_left_tree--;
                return findRecForDelete(key, n.left);
            } else { // n.value < key
                return findRecForDelete(key, n.right);
            }
        }
    }
	
	public String[] inOrder()
	{
		//recursive method returns an inorder array list .toarray converts it to an array
		return InOrderRec(root, new ArrayList<String>()).toArray(new String[size]);
	}
	
	private ArrayList<String> InOrderRec(Node n, ArrayList<String> arr){
        if(n.left != null) {
            InOrderRec(n.left, arr);
        }
        for(int i=0; i < n.count; i++){
        	arr.add(n.value);
        }
        if(n.right != null) {
            InOrderRec(n.right, arr);
        }
       return arr; 
        
    }
	
	public String[] preOrder()
	{
		//recursive method returns an preorder array list .toarray converts it to an array
		return PreOrderRec(root, new ArrayList<String>()).toArray(new String[size]);
	}
	
	private ArrayList<String> PreOrderRec(Node n, ArrayList<String> arr){
        for(int i=0; i < n.count; i++){
        	arr.add(n.value);
        }
        if(n.left != null) {
            PreOrderRec(n.left, arr);
        }
        if(n.right != null) {
            PreOrderRec(n.right, arr);
        }
       return arr; 
        
    }

	//implementing this will require some changes to the add method
	public int rankOf(String s)
	{
		return rankHelper(s, root, 0);
	}
	
	private int rankHelper(String key, Node n, int x) {
        if (n == null) {
            return -1;
        } else {
            if (n.value.equals(key)) {
                return x + n.vals_in_left_tree;
            } else if (n.value.compareTo(key) > 0) {
                return rankHelper(key, n.left, x);
            } else { // n.value < key
            	x += 1 + n.vals_in_left_tree;
                return rankHelper(key, n.right, x);
            }
        }
    }
	
	//TODO
	//for testing... delete before submission
	public static void main(String [] args)
	{
		BinaryST bst = new BinaryST();
		bst.add("ABBA");
		bst.add("BAAB");
		bst.add("MONKEY");
		bst.add("GUY");
		bst.add("GUY");
		bst.add("FIERRI");
		bst.add("TREE");
		bst.add("ZEBRA");
		bst.add("PO");
		bst.add("POOP");
		bst.remove("MONKEY");
		String[] inorder = bst.preOrder();
		for(int i=0; i<inorder.length; i++){
			System.out.print(inorder[i] + ", ");
		}
		System.out.println("\n height: " + bst.height);
		System.out.println("size: " + bst.size);
		System.out.println("distinct: " + bst.distinct_size);
		System.out.println("rank : " + bst.rankOf("ZEBRA"));
		
	}
	
}