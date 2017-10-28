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
	
	//TODO
	public WarWithArray(String[] s, int k)
	{
		// implementation
		this.k = k;
		this.stringSet = s;
	}
	
	//TODO
	public ArrayList<String> compute2k()
	{
		ArrayList<String> result = new ArrayList<String>();
		return null;
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
	
	public static void main(String[] args) {
		String[] s = {"AA", "AB", "BC"};
		WarWithArray wwa = new WarWithArray(s, 2);
		String[] testString = {"AA", "AB", "BC", "BD", "BA"};
		for(int i = 0; i < testString.length; i++) {
			System.out.println("String: " + testString[i] + " Valid: " + wwa.isValidSubstring(testString[i]));
		}
		
	}
}

