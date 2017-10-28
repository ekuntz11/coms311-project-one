// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;


public class WarWithArray
{
	// member fields and methods
	String[] s;
	int k;
	//TODO
	public WarWithArray(String[] s, int k)
	{
		this.s = s;
		this.k = k;
	}
	
	private boolean search(String com){
		boolean found = false;
		for(int i=0; i<s.length; i++){
			if(s[i].compareTo(com) == 0){
				return true;
			}
		}
		return found;
	}
	
	//TODO
	public ArrayList<String> compute2k()
	{
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<s.length;i++){
			for(int j = i; j<s.length; j++){
				String possible = s[i] + s[j];
				boolean valid = true;
				for(int x = 1; x<s[i].length(); x++){
					if(search(possible.substring(x,x+k))){
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

