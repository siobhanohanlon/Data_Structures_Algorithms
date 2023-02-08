package ie.gmit.sw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.*;

public class Output {
	
	public static void main() throws Exception
	{
		String csvName, csvDir, filePath;
		
		csvName = Runner.getCSVName();
		csvDir = Runner.getDirectory();
		
		filePath = csvDir+""+csvName;
		
		output(filePath);
	}
	
	private static void output(String file) throws Exception{
		Map<String, Long> frequency = new HashMap<>();
		FileWriter fw = new FileWriter(new File(file));
		
		frequency = Parser.getMap();
		
		//Loop over These & Write
		for(java.util.Map.Entry<String, Long> entry :frequency.entrySet())
		{
			// put key and value separated by a colon
            fw.write(entry.getKey() + "," + entry.getValue() + "\n");
		}
		
		//Flush
        fw.flush();
		
    	//Close Writer
        fw.close();
	}
}