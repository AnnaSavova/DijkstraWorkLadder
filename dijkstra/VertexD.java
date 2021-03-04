package dijkstra;

import java.util.*;

public class VertexD {

	private LinkedList<AdjListNodeD> adjListD ; // the adjacency list 
    private String word; // the word this vertex holds in the graph
    
	boolean visited; // whether vertex has been visited in a traversal
    String predecessor; // word the predecessor vertex holds

     
    /**
	 creates a new instance of Vertex
	 */
    public VertexD(String w) {
    	adjListD = new LinkedList<AdjListNodeD>();
    	word = w;
    	visited = false;
    }
    
    /**
	 copy constructor
	*/
    public VertexD(VertexD v){
    	adjListD = v.getAdjListD();
    	word = v.getWord();
    	visited = v.getVisited();
    }
     
    
    public LinkedList<AdjListNodeD> getAdjListD(){
        return adjListD;
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
    
    public void addToAdjListD(String w, int we){
        adjListD.addLast(new AdjListNodeD(w, we));
    }
    
    public int vertexDegree(){
        return adjListD.size();
    }
}
