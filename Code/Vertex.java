import java.util.ArrayList;

public class Vertex {
	private int name;
	private ArrayList<Edge> edges;//Keeps the edges that vertex has
	private boolean visited;
	private Vertex parent;
	private double closeness;
	private int betweeness;
	
	public Vertex(int name) {
		this.name = name;
		edges = new ArrayList<Edge>();
		visited = true;
		parent = null;
		closeness = 0;
		betweeness = 0;
	}

	public void addEdge(Edge e) {edges.add(e);}
	public ArrayList<Edge> getEdges() {return this.edges;}
	public int getName() {return name;}
	public void setName(int name) {this.name = name;}
	public boolean isVisited() {return visited;}
	public void setVisited(boolean visited) {this.visited = visited;}
	public Vertex getParent() {return parent;}
	public void setParent(Vertex parent) {this.parent = parent;}
	public double getCloseness() {return closeness;}
	public void setCloseness(double closeness) {this.closeness = closeness;}
	public int getBetweeness() {return betweeness;}
	public void setBetweeness(int betweeness) {this.betweeness = betweeness;}

	
	public Edge nextNeighbor(int count) {
		Edge temp = null;		
		if(hasNeighbor())
			temp = edges.get(count);
		return temp;	
	}

	
	public boolean hasNeighbor() {		
		if(edges.size() == 0)
			return false;
		else
			return true;		
	}

	
	public int size() {return edges.size();}
	
	
	
	
	
	
	
	
	
	
	
	

}
