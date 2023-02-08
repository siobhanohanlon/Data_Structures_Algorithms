package ie.gmit.sw;

import java.io.*;
import java.security.KeyStore.Entry;
import java.util.*;

public class Parser {
	private static Map<String, Long> frequency = new HashMap<>();
	
	public static Map<String, Long> getMap() {
		return Parser.frequency;
	} // end Map
	
	public static void parse(String dir) throws Exception{
		String[] files = new File(dir).list();
		
		//For each file
		for(String f: files){
			//Make File have directory
			String fileUsing = dir+""+f;
			
			//Send File to Process
			process(fileUsing);
		}
	}//end parse
	
	public static void process(String file) throws Exception{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
		String line = null;
		long value = 1;
		long nGram = 0;
			
			//Loop through text file line by line
			while((line = br.readLine()) != null) {
				
				line = line.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
				String[] words = line.toLowerCase().split("\\s+");
				
				nGram = Runner.getNGramSize();
				
				//For each line in file
				for(String word : words) {
					char[] w = word.toCharArray();
					List<Character> letters = new ArrayList<Character>();
					
					//Loop over word and extract n-gram
					for(int i = 0; i < w.length; i++) {
						char letr = w[i];
						letters.add(letr);
						
						if(letters.size() == nGram)
						{
							// create object of StringBuilder class
					        StringBuilder sb = new StringBuilder();
					 
					        // Appends characters one by one
					        for (Character ch : letters) {
					            sb.append(ch);
					        }
					        
					        //Check ig the nGram is already in the Frequency
					        if(frequency.containsKey(sb.toString()))
					        {
					        	value = frequency.get(sb.toString());
					        	value++;
					        }
					        
							//Add word to hash map
							frequency.put(sb.toString(), value);
							
							//Reset Value 
							value = 1;
						}
					}
				}				
			}
		}
		
		Output.main();
	}

}