package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class Dictionary {
	private List<String> words = new ArrayList<>();
	private final String DICTIONARY_FILE = "./dictionary.txt";

	public void load() throws Exception 
	{
		//	Pack it into buffer				<----	convert to character  <---	bits from file
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(DICTIONARY_FILE)))) 
		{
			String next;
			while ((next = br.readLine()) != null) //read till end of file
			{
				words.add(next);//add found word to array
			}
		} catch (Exception e) //if something goes wrong
		{
			throw new Exception("[ERROR] Encountered a problem reading the dictionary. " + e.getMessage());
		}
	}

	public int size() 
	{
		return words.size();
	}

	//returns array list as string array
	public String[] getSortedWords() 
	{
		return words.stream().toArray(String[]::new);//convert to array
		
		//old way
		//return words.toArray(new String[words.size()]);
	}
}