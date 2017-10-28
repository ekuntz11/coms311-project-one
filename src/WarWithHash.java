// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Implementation of War With Hash
 * @author Eva Kuntz & Merritt Harvey
 */
public class WarWithHash
{
	private int k;
	private String[] stringSet;
	private HashSet<String> h = new HashSet<String>();
	
	public WarWithHash(String[] s, int k)
	{
		//add all elements from the string array to the hashset
		for(int i = 0; i < s.length; i++) {
			h.add(s[i]);
		}
		this.k = k;
		this.stringSet = s;
	}
	
	//TODO
	public ArrayList<String> compute2k()
	{
		ArrayList<String> result = new ArrayList<String>();
		boolean isValid = false;
		
		for(int i = 0; i < stringSet.length; i++) {
			for(int j = 0; j < stringSet.length; j++) {
				String possible = stringSet[i] + stringSet[j];
				isValid = true;
				for(int x = 1; x < stringSet[i].length(); x++) {
					if(!(h.contains(possible.substring(x, x+k)))) {
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
	
	public static void main(String[] args) {
		WarWithHash test = new WarWithHash(new String[]{"AB", "CD", "EF", "DE", "BC"}, 2);
		ArrayList<String> res = test.compute2k();
		System.out.println("size: " + res.size());
		for(int i =0; i< res.size(); i++)
		{
			System.out.println("size: " + res.get(i));
		}
	}
}

