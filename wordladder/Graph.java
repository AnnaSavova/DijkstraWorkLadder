package wordladder;

import java.util.*;

public class Graph {
	private Vertex[] vertices; // the (array of) vertices
	private int numVertices = 0; // number of vertices
	String[] words;
	String word1;
	String word2;

	/**
	 creates a new instance of Graph with n vertices
	*/
	public Graph(String w1, String w2, String[] words) {
		word1 = w1;
		word2 = w2;
		numVertices = words.length;
		vertices = new Vertex[numVertices];
		this.words = words;
		for (int i = 0; i < numVertices; i++) {
			String currWord = words[i];
			vertices[i] = new Vertex(currWord);
		}
	}

	public int size() {
		return numVertices;
	}

	public Vertex getVertex(String w) {
		Vertex desV = null; // the desired vertex
		for (int i =0; i < numVertices; i++) { // check the words of all vertices
			if (vertices[i].getWord().equals(w)) {
				desV = vertices[i];
				break; // stop iterating when desV is found
			}
		}
		return desV;
	}

	/**
	 carry out a breadth first search/traversal of the graph
	 */
	public void bfs() {
		LinkedList<Vertex>queue = new LinkedList<Vertex>();
		Vertex beginning = getVertex(word1);
		Vertex end = getVertex(word2);
		int transformations = 0;
		String ladder = "";
		
		for (Vertex v : vertices) {
			v.setVisited(false);
		}
		
		for (Vertex v : vertices) {
			if (!v.getVisited()) {
				v.setVisited(true);
				v.setPredecessor(v.getWord());
				queue.add(v);
				while(!queue.isEmpty()) {
					Vertex next = queue.remove();
					LinkedList<AdjListNode> neighbours = next.getAdjList();
					String nextWord = next.getWord();
					if (beginning.getVisited() && !end.getVisited()) {
						transformations ++;
						ladder += nextWord + "->";
					}
					
					if (nextWord.equals(word2)) {
						ladder += nextWord;
						break;
					}
					
					for (AdjListNode node : neighbours) {
						Vertex w = getVertex(node.getVertexWord());
						if (!w.getVisited()) {
							w.setVisited(true);
							w.setPredecessor(nextWord);
							queue.add(w);
						}
					}
				}
			}
		}
		
		if (!end.getVisited()) {
			System.out.println("Unable to find ladder transforming " + word1 + " to " + word2);
		} else {
			System.out.println("Shortest ladder from " + word1 + " to " + word2 + ":");
			System.out.println(ladder);
			System.out.println(transformations + " transformations were needed");
		}
	}
}