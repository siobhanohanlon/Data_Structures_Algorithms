package ie.gmit.sw;

import java.util.*;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Runner {
	public static void main(String[] args) throws Exception {
		DecimalFormat formatter = new DecimalFormat("#,###.00"); //Formats the time output
		Dictionary d = new Dictionary();
		d.load();
		
		String[] words = d.getSortedWords();
		long start = System.currentTimeMillis(); //Start the clock
		
		//Start adding code here:
		
		//LinkedList as a Queue
//		Queue<String> queue = new LinkedList<>();
//		for (String word : words) {
//		 queue.offer(word); //offer not add
//		}
//		
//		while (!queue.isEmpty()) {
//			 String word = queue.poll(); //poll not remove
//			 System.out.println(word);
//			}
		
		//Deque
//		Deque<String> queue = new ArrayDeque<>();
//		for (String word : words) {
//		 queue.push(word); //push not add to use as a stack
//		}
//		
//		while (!queue.isEmpty()) {
//			 String word = queue.pop(); //pop not remove
//			 System.out.println(word);
//			}
		
//		//Priority Queue
//		Queue<String> queue = 
//				//new PriorityQueue<>((n,m) -> n.compareTo(m)); Another Way Below
//				new PriorityQueue<>(Comparator.comparing(String::hashCode));
//		for (String word : words) {
//		 queue.offer(word); //offer not add
//		}
//		
//		while (!queue.isEmpty()) {
//			 String word = queue.poll(); //poll not remove
//			 System.out.println(word);
//			}
		
		//
		Queue<Ninja> queue = 
				new PriorityQueue<>(Comparator.comparing(Ninja::level));
				//To do it backwards
				//new PriorityQueue<>(Comparator.comparing(Ninja::level).reversed());
		for(int i = 0; i < words.length; i++)
		{
			queue.offer(new Ninja(words[i], i, LocalDate.now()));
		}
		
		while (!queue.isEmpty()) {
			 Ninja n = queue.poll();
			 System.out.println(n);
			}
		
		//Output the formatted time
		System.out.println("Time (ms):  " + formatter.format((System.currentTimeMillis() - start)));
	}	
}