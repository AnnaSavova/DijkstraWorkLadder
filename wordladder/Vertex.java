package wordladder;

import java.util.*;

public class Vertex {

	private LinkedList<AdjListNode> adjList ; // the adjacency list 
    private String word; // the word this vertex holds in the graph
    
	boolean visited; // whether vertex has been visited in a traversal
    String predecessor; // word the predecessor vertex holds

     
    /**
	 creates a new instance of Vertex
	 */
    public Vertex(String w) {
    	adjList = new LinkedList<AdjListNode>();
    	word = w;
    	visited = false;
    }
    
    /**
	 copy constructor
	*/
    public Vertex(Vertex v){
    	adjList = v.getAdjList();
    	word = v.getWord();
    	visited = v.getVisited();
    }
     
    
    public LinkedList<AdjListNode> getAdjList(){
        return adjList;
    }
    
    public String getWord(){
    	return word;
    }
    
    public void setWord(String w){
    	word = w;
    }
    
    public boolean getVisited(){
    	return visited;
    }
    
    public void setVisited(boolean b){
    	visited = b;
    }
    
    public String getPredecessor(){
    	return predecessor;
    }
    
    public void setPredecessor(String w){
    	predecessor = w;
    }
    
    public void addToAdjList(String w){
        adjList.addLast(new AdjListNode(w));
    }
    
    public int vertexDegree(){
        return adjList.size();
    }
}
