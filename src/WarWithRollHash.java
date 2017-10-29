// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;
import java.util.Hashtable;


public class WarWithRollHash
{
	private int k;
	private String[] stringSet;
	private Hashtable<Integer, String> table = new Hashtable<Integer, String>();
	
	//TODO
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
		return null;
	}
}

