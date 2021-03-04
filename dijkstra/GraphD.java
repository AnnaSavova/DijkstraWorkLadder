package dijkstra;

import java.util.*;

public class GraphD {
	private VertexD[] vertices; // the (array of) vertices
	private int numVertices = 0; // number of vertices
	String[] words;
	String word1;
	String word2;

	/**
	 creates a new instance of Graph with n vertices
	*/
	public GraphD(String w1, String w2, String[] words) {
		word1 = w1;
		word2 = w2;
		numVertices = words.length;
		vertices = new VertexD[numVertices];
		this.words = words;
		for (int i = 0; i < numVertices; i++) {
			String currWord = words[i];
			vertices[i] = new VertexD(currWord);
		}
	}

	public int sizeD() {
		return numVertices;
	}

	public VertexD getVertexD(String w) {
		VertexD desV = null; // the desired vertex
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
		LinkedList<VertexD>queue = new LinkedList<VertexD>();
		// comparator for the priority queue to rank neighbours by weight
		Comparator<AdjListNodeD> compareWeight = Comparator.comparing(AdjListNodeD::getWeight);
		PriorityQueue<AdjListNodeD> pqueue = new PriorityQueue<AdjListNodeD>(compareWeight);
		VertexD beginning = getVertexD(word1);
		VertexD end = getVertexD(word2);
		int weight = 0;
		String ladder = "";
		
		for (VertexD v : vertices) {
			v.setVisited(false);
		}
		
		for (VertexD v : vertices) {
			if (!v.getVisited()) {
				v.setVisited(true);
				v.setPredecessor(v.getWord());
				queue.add(v);
				while(!queue.isEmpty()) {
					VertexD next = queue.remove();
					LinkedList<AdjListNodeD> neighbours = next.getAdjListD();
					String nextWord = next.getWord();
					if (beginning.getVisited() && !end.getVisited()) {
						ladder += nextWord + "->";
					}
					
					if (nextWord.equals(word2)) {
						ladder += nextWord;
						break;
					}
					
					for (AdjListNodeD node : neighbours) {
						VertexD w = getVertexD(node.getVertexWord());
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
		}
	}
}
