package dijkstra;

public class AdjListNodeD {
	private String vertexWord;
	private int weight;
	
	public AdjListNodeD(String w, int we) {
		vertexWord = w;
		weight = we;
	}
	
	public String getVertexWord() {
		return vertexWord;
	}
	
	public void setVertexWord(String w) {
		vertexWord = w;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int we) {
		weight = we;
	}
}
