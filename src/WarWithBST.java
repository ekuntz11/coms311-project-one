// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;

/**
 * Implementation of War with BST
 * @author Eva Kuntz and Merritt Harvey
 */
public class WarWithBST
{
	/**
	 * Binary Search Tree instance
	 */
	private BinaryST bst;
	
	/**
	 * Integer to represent k-length substrings
	 */
	private int k;
	
	/**
	 * Constructor
	 * @param s
	 * 	Subset S of set U with k-length strings
	 * @param k
	 * 	Integer to represent length of substrings
	 */
	public WarWithBST(String[] s, int k)
	{
		bst = new BinaryST(s);
		this.k = k;
	}
	
	/**
	 * Method that computes all the possible
	 * 2k-length substrings of the original set U,
	 * where set S is a subset of all k-length
	 * strings of U.
	 * @return
	 * 	ArrayList of all the 2k-length substrings.
	 */
	public ArrayList<String> compute2k()
	{
		ArrayList<String> result = new ArrayList<String>();
		String[] s = bst.inOrder();
		for(int i=0; i<s.length;i++){
			for(int j = i; j<s.length; j++){
				String possible = s[i] + s[j];
				boolean valid = true;
				for(int x = 1; x<s[i].length(); x++){
					if(!bst.search(possible.substring(x,x+k))){
						valid = false;
						break;
					} 
				}
				if(valid){
					result.add(possible);
				}
			}
		}
		return result;
	}
	
	//TODO
	//for testing... delete before submission
	public static void main(String [] args)
	{
		WarWithBST test = new WarWithBST(new String[]{"AB", "CD", "EF", "DE", "BC"}, 2);
		ArrayList<String> res = test.compute2k();
		System.out.println("size: " + res.size());
		for(int i =0; i< res.size(); i++)
		{
			System.out.println("size: " + res.get(i));
		}
	}
}

