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
	private long k;
	private String[] stringSet;
	private Hashtable<Long, String> table = new Hashtable<Long, String>();
	long R = 256;
	
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
		//add <string's hashcode, string> to hashtable
		for(int i = 0; i < s.length; i++) {
			table.put((long)(hash(s[i])*Math.pow(R, i)), s[i]);
		}
	}
	
	private long hash(String key)
    { 
		long hash = 0;;
        for (int j = 0; j < k; j++){
        	hash += key.charAt(j)*Math.pow(R, j); 
        }   
        return hash; 
    } 
	
	//TODO
	public ArrayList<String> compute2k()
	{
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < stringSet.length; i++) {
			for(int j = 0; j < stringSet.length; j++) {
				String possible = stringSet[i] + stringSet[j];
				String ght = possible.substring(1,(int)(1+k));
				long curHashCode = hash(possible.substring(1,(int)(1+k)));
				boolean isValid = true;
				for(int x = 1; x < stringSet[i].length(); x++) {
					//calculate the hashcode of substring we are determining if valid or not
					if(x!=1){
						curHashCode = (curHashCode - possible.charAt((int)(k+x)))*R + possible.charAt((int)(k+x+1));
					}
					if(!table.containsKey(curHashCode)){
						isValid = false;
						break;
					} 
				}
				
				if(isValid) {
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
			WarWithRollHash1 test = new WarWithRollHash1(new String[]{"AA", "AB", "CD", "EF", "DE", "BC"}, 2);
			ArrayList<String> res = test.compute2k();
			System.out.println("size: " + res.size());
			for(int i =0; i< res.size(); i++)
			{
				System.out.println("size: " + res.get(i));
			}
		}
}

