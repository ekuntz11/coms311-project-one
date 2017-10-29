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
public class WarWithRollHash1
{
	/**
	 * Length of each substring
	 */
	private long k;
	/**
	 * Set of the substrings
	 */
	private String[] stringSet;
	/**
	 * Hashtable to store <hashcode, string> pairs
	 */
	private Hashtable<Long, String> table = new Hashtable<Long, String>();
	/**
	 * Radix
	 */
	private long R = 256;
	
	/**
	 * Constructor
	 * @param s
	 * 	Subset S from which to calculate all possible
	 * 	2k-length substrings from
	 * @param k
	 * 	length of all substrings in set S
	 */
	public WarWithRollHash1(String[] s, int k)
	{
		this.k = k;
		stringSet = s;
		//add <hashcode, string> key-value pair to hashtable
		for(int i = 0; i < s.length; i++) {
			table.put((long)(hash(s[i])), s[i]);
		}
	}
	
	/**
	 * Method to compute hashcode of a string
	 * @param s
	 * 	String to compute hashcode for
	 * @return
	 * 	hashcode of the input string
	 */
	private long hash(String key)
    { 
		long hash = 0;
        for (int j = 0; j < k; j++){
        	hash += key.charAt(j)*Math.pow(R, k-j-1); 
        }   
        return hash; 
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
		for(int i = 0; i < stringSet.length; i++) {
			for(int j = 0; j < stringSet.length; j++) {
				//possible 2k-length substring
				String possible = stringSet[i] + stringSet[j];
				
				/*get hashcode of the first k-length substring of the
				possible 2k-length substring*/
				long curHashCode = hash(possible.substring(1,(int)(1+k)));
				boolean isValid = true;
				for(int x = 1; x < stringSet[i].length(); x++) {
					if(x!=1){
						//roll hash here
						curHashCode = (long)(curHashCode - possible.charAt((int)(x-1))*Math.pow(R,k-(x-1)))*R + possible.charAt((int)(k+x));
					}
					if(!table.containsKey(curHashCode)){
						isValid = false;
						break;
					} 
				}				
				if(isValid) {
					//if valid, add the possible 2k-length substring to the result list
					result.add(possible);
				}
			}
		}
		return result;
	}
	
	//TODO
	//remove before submission
	public static void main(String [] args)
	{
		//WarWithRollHash1 test = new WarWithRollHash1(new String[]{"ABA", "ACD", "BAA", "AAC", "CDB", "DBA"}, 3);
		WarWithRollHash1 test = new WarWithRollHash1(new String[]{"AA", "AB", "CD", "EF", "DE", "BC"}, 2);
		ArrayList<String> res = test.compute2k();
		System.out.println("size: " + res.size());
		for(int i =0; i< res.size(); i++)
		{
			System.out.println("size: " + res.get(i));
		}
	}
}

