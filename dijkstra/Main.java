package dijkstra;

import java.io.*;
import java.util.*;

import wordladder.Graph;
import wordladder.Vertex;

/**
 program to find word ladder with shortest distance for two words in a dictionary
 distance between elements of the word ladder is the absolute difference in the
 positions of the alphabet of the non-matching letter
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
		int weight = 0;
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
		GraphD G = new GraphD(word1, word2, wordsArr);
		for (int i=0; i<wordsArr.length; i++) {
			char[] letters = wordsArr[i].toCharArray();
			for(int j=0;j<word1.length();j++) {
				int origPos = letters[j];
				for(char letter='a';letter<='z';letter++){
					char currL = letters[j];
					if(letters[j] != letter) {
						letters[j] = letter;
					}
					
					String neighbour = new String(letters);
					if(words.contains(neighbour)) {
						weight = Math.abs(letterPos(letter)-origPos); // absolute difference between the changed symbol and original
						VertexD currVert = G.getVertexD(wordsArr[i]);
						currVert.addToAdjListD(neighbour,weight);
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
	
	// helper function to find the position of a char in the alphabet with 'a' = 1;
	public static int letterPos(char l) {
		int pos = 0;
		String alphabet = "abcdefghijklmnopqrstuvwxyz"; //{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		pos = alphabet.indexOf(l) + 1;
		return pos;
	}

}
