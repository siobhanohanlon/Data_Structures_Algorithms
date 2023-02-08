package ie.gmit.sw;

import java.util.Arrays;

public class Runner 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("---------- SW2 - DSA Lab 1: Space and Time Complexity ----------");
		Dictionary dictionary = new Dictionary();
		dictionary.load();
		System.out.println("Dictionary conains " + dictionary.size() +  " words.");
		
		String[] words = dictionary.getSortedWords();
		//Start the clock
		long startTime = System.nanoTime();
		
		isArrayOver100(words);
		//contains(words, "zebra");
		//binarySearch(words, "zebra");
		//containsDuplicates(words);
		System.out.println("Running time (ns): " + (System.nanoTime() - startTime));
		
	}
	
	//Running time: O(1)- Constant
	public static boolean isArrayOver100(String[] args) 
	{
		return args.length > 100 ? true : false;
	}
	
	//Running time: O(N)- Linear
	public static boolean contains(String[] args, String value) 
	{
	    for (int i = 0; i < args.length; i++) 
	    {
	        if (args[i] == value) return true;
	    }
	    return false;
	}
	
	//Running time: O(log N)- Log
	/*
		A sorted array can be quickly searched using a binary search. The basic idea is to 
		speed up an array search by applying a divide and conquer strategy. The search 
		criterion is compared to the middle item of an array. If the search criterion is less than 
		the middle element, a binary search is recursively applied on the first half. Otherwise, 
		the second half of the array is recursively searched. The following method 
		implements a binary search of a String[] for a given search string key: 
	*/
	public static int binarySearch(String[] sorted, String key) 
	{ 
	    int first = 0; 
	    int upto  = sorted.length; 
	     
	    while (first < upto) 
	    { 
	    	// Compute mid point. 
	        int mid = (first + upto) / 2;  
	        
	        if (key.compareTo(sorted[mid]) < 0) 
	        { 
	        	// repeat search in bottom half.
	            upto = mid;        
	        } 
	        
	        else if (key.compareTo(sorted[mid]) > 0) 
	        { 
	        	// Repeat search in top half.
	            first = mid + 1;   
	        } 
	        
	        else 
	        { 
	        	// Found it. Return position
	            return mid;        
	        } 
	    } 
	    
	    // Failed to find key 
	    return -(first + 1);      
	}
	
	//Does exactly the same thing as above but delegates to the Arrays class.
	public static int lazyBinarySearch(String[] sorted, String key) 
	{
		return Arrays.binarySearch(sorted, key);
	}
	
	//Running time: O(n^2)- Quadratic
	public static boolean containsDuplicates(String[] args) 
	{
        for (int i = 0; i < args.length; i++) 
        {
            for (int j = 0; j < args.length; j++) 
            {
                if (i == j) break;
                if (args[i] == args[j]) return true;
            }
        }
        return false;
    }
}