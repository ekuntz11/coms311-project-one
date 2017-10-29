// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Implementation of War with Roll Hash
 * @author Eva Kuntz & Merritt Harvey
 */
public class WarWithRollHash
{
	private int k;
	private String[] stringSet;
	private Hashtable<Integer, String> table = new Hashtable<Integer, String>();
	
	/**
	 * Constructor
	 * @param s
	 * 	Subset S from which to calculate all possible
	 * 	2k-length substrings from
	 * @param k
	 * 	length of all substrings in set S
	 */
	public WarWithRollHash(String[] s, int k)
	{
		this.k = k;
		stringSet = s;
		//add <string's hashcode, string> to hashtable
		for(int i = 0; i < s.length; i++) {
			table.put(s[i].hashCode(), s[i]);
		}
	}
	
	//TODO
	public ArrayList<String> compute2k()
	{
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < stringSet.length; i++) {
			for(int j = 0; j < stringSet.length; j++) {
				String possible = stringSet[i] + stringSet[j];
				boolean isValid = false;
				for(int x = 1; x < stringSet[i].length(); x++) {
					//calculate the hashcode of substring we are determining if valid or not
					int possibleHash = possible.substring(x, x+k).hashCode();
				}
				
				if(isValid) {
					result.add(possible);
				}
			}
		}
		return result;
	}
}

