// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;

/**
 * Implementation of War with Array
 * @author Eva Kuntz and Merritt Harvey
 */
public class WarWithArray
{
	/**
	 * Integer to represent length of substrings.
	 */
	private int k;
	
	/**
	 * Set of strings
	 */
	private String[] stringSet;
	
	/**
	 * Constructor
	 * @param s
	 * 	Set of substrings
	 * @param k
	 * 	length of each string
	 */
	public WarWithArray(String[] s, int k)
	{
		this.k = k;
		this.stringSet = s;
	}
	
	/**
	 * Method that returns a list of all
	 * 2k-length substrings of an original set U,
	 * such that S is a set of all k-length strings.
	 * @return
	 * 	List of all possible 2k-length substrings.
	 */
	public ArrayList<String> compute2k()
	{
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<stringSet.length;i++){
			for(int j = 0; j<stringSet.length; j++){
				String possible = stringSet[i] + stringSet[j]; //make 2k-length string
				boolean valid = true;
				for(int x = 1; x<stringSet[i].length(); x++){
					/*if not a valid substring, break and move on to next possible substring*/
					if(!(isValidSubstring(possible.substring(x,x+k)))){
						valid = false;
						break;
					} 
				}
				if(valid){
					//if valid result, add to list of possible 2k-length substrings
					result.add(possible);
				}
			}
		}
		return result;
	}
	
	public static void main(String [] args)
	{
		//WarWithArray test = new WarWithArray(new String[]{"AB", "CD", "EF", "DE", "BC"}, 2);
		WarWithArray test = new WarWithArray(new String[] {"AB", "CD", "EF"}, 2);
		ArrayList<String> res = test.compute2k();
		System.out.println("size: " + res.size());
		for(int i =0; i< res.size(); i++)
		{
			System.out.println("size: " + res.get(i));
		}
	}
	
	/**
	 * Determines whether the input string is a valid
	 * substring of set S or not.
	 * @param s
	 * 	Substring to check
	 * @return
	 * 	True if substring is valid, false otherwise
	 */
	public boolean isValidSubstring(String s) {
		for(int i = 0; i < stringSet.length; i++) {
			if(s.equals(stringSet[i]))
				return true;
		}
		return false;
	}

}

