package wordladder;

import java.io.*;
import java.util.*;

/**
 program to find word ladder with shortest path (i.e. minimum number edges
 */
public class Main {

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();

		String inputFileName = args[0]; // dictionary
		String word1 = args[1]; // first word
		String word2 = args[2]; // second word
  
		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);
		
		// read in the data here
		ArrayList<String> words = new ArrayList<String>();
		String line = in.nextLine();
		while(in.hasNext()) {
			words.add(line);
			line = in.nextLine();
		}
		in.close();
		reader.close();
		
		String[] wordsArr = new String[words.size()];
		wordsArr = words.toArray(wordsArr);
		
		// create graph here
		Graph G = new Graph(word1, word2, wordsArr);
		for (int i=0; i<wordsArr.length; i++) {
			char[] letters = wordsArr[i].toCharArray();
			for(int j=0;j<word1.length();j++) {
				for(char letter='a';letter<='z';letter++){
					char currL = letters[j];
					if(letters[j] != letter) {
						letters[j] = letter;
					}
					
					String neighbour = new String(letters);
					if(words.contains(neighbour)) {
						Vertex currVert = G.getVertex(wordsArr[i]);
						currVert.addToAdjList(neighbour);
						words.remove(neighbour);
					}
					letters[j] = currL;
				}
			}
		}
		
		// do the work here
		G.bfs();
		
		
		// end timer and print total time
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
	}

}
