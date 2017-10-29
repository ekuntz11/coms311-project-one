// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Implementation of War with Roll Hash
 * @author Eva Kuntz & Merritt Harvey
 */
public class WarWithRollHash
{
	/**
	 * 'Pattern' length
	 */
	private int k;
	/**
	 * Array for set of substrings
	 */
	private String[] stringSet;
	/**
	 * Hash table to store the set of strings
	 */
	private Hashtable<Long, String> table = new Hashtable<Long, String>();
	
    /**
     * Large prime number        
     */
    private long Q;
    
    /**
     * Radix         
     */
    private int R; 
    
    /**
     * R^(K-1) % Q
     */        
    private long RM; 
	
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
		this.R = 256;
		this.Q = generateRandomPrime(); //generate a random prime number		
		//precompute R^(k-1) % Q
		RM = 1;
        for (int i = 1; i <= this.k - 1; i++){
        	RM = (R * RM) % Q;
        }
        
		//add <string's hashcode, string> to hashtable
		for(int i = 0; i < s.length; i++) {
			table.put(hash(s[i]), s[i]);
		}
		stringSet = s;
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
				String possible = stringSet[i] + stringSet[j];
				boolean isValid = false;
				for(int x = 1; x < stringSet[i].length(); x++) {
					//calculate the hashcode of the substring of 'possible' string
					long possibleHash = hash(possible.substring(x, x+k));
				}
				
				if(isValid) {
					result.add(possible);
				}
			}
		}
		return result;
	}
	
	/**
	 * Method to compute hashcode of a string
	 * @param s
	 * 	String to compute hashcode for
	 * @return
	 * 	hashcode of the input string
	 */
	public long hash(String s) {
		long hash = 0;
		for(int i = 0; i < k; i++) {
			hash = (R * hash + s.charAt(i)) % Q;
		}
		return hash;
	}
	
	/**
	 * Method that generates a random prime number
	 * @return
	 * 	random prime number
	 */
	public long generateRandomPrime(){
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}
}

