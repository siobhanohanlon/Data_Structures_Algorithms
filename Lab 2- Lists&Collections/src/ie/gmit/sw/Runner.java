package ie.gmit.sw;

import java.util.*;
public class Runner {
	public static void main(String[] args) throws Exception {
		System.out.println("---------- SW2 - DSA Lab 2: Lists & Collections ----------");
		Dictionary dictionary = new Dictionary();
		dictionary.load();
		System.out.println("Dictionary contains " + dictionary.size() +  " words.");
		
		String[] words = dictionary.getSortedWords();
		long startTime = System.nanoTime();
		
		//Start writing the lab exercises after this line:

		
		System.out.println("Running time (ns): " + (System.nanoTime() - startTime));
	}
}