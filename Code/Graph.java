import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class Graph {
	
	private SingleLinkedList vertices;//all vertices in the sll(Node1)
	private SingleLinkedList edges;//all edges in the sll(Node2)
	private ArrayList<Path> shortestPaths;//all short paths
		
	public Graph() {		
		this.edges = new SingleLinkedList();
		this.vertices = new SingleLinkedList();
		shortestPaths = new ArrayList<Path>();
	}

	
	public void addEdge(int source, int destination) {
		
		Vertex tempSource, tempDestination;
				
		if(edges.searchEdge(source, destination) == false) {//new edge
			
			if(vertices.searchVertex(source) == false) {//new vertex
				tempSource = new Vertex(source);
				vertices.addVertex(tempSource);//adds new object
			}
			else {
				tempSource = vertices.vertex(source);//returns added object
			}
			
			if(vertices.searchVertex(destination) == false) {//new vertex
				tempDestination = new Vertex(destination);
				vertices.addVertex(tempDestination);//adds new object
			}
			else {
				tempDestination = vertices.vertex(destination);
			}
			
			Edge edge = new Edge(tempSource, tempDestination);//new edge
			tempSource.addEdge(edge);
			tempDestination.addEdge(edge);
			edges.addEdge(edge);			
		}
		else {
			System.out.println("This edge has already added!");
		}		
	}

	
	public Stack getShortestPath(Vertex originVertex, Vertex endVertex) {
		
		vertices.resetingVertex();
		Queue<Vertex> vertexQueue = new LinkedList<>();
		boolean done = false;
		vertexQueue.add(originVertex);
		originVertex.setVisited(false);
		Vertex frontVertex, temp;
		Edge nextNeighbor;
		
		while(!done && !vertexQueue.isEmpty()) {
			frontVertex = vertexQueue.poll();
			
			for(int i = 0; i < frontVertex.size(); i++) {				
				nextNeighbor = frontVertex.nextNeighbor(i);
				
				if(nextNeighbor.getDestination().getName() == frontVertex.getName())
					temp = nextNeighbor.getSource();
				else
					temp = nextNeighbor.getDestination();//burada frontVertex destination ile ayný ise source olmalý
				
				if(!done && temp != null) {
					if(temp.isVisited()) {
						temp.setVisited(false);
						temp.setParent(frontVertex);
						vertexQueue.add(temp);
					}
					if(temp == endVertex) {
						done = true;
					}
				}
			}
		}
		
		//where betweeness and closeness increase
		Stack tempStack = new Stack();
		tempStack.add(endVertex);
		
		Vertex a = endVertex;
		int count = 0;
		
		while(a.getParent() != null) {
			a.setBetweeness(a.getBetweeness() + 1);
			a = a.getParent();
			tempStack.add(a);			
			count++;
		}
		a.setBetweeness(a.getBetweeness() + 1);
		endVertex.setCloseness(endVertex.getCloseness() + count);
		a.setCloseness(a.getCloseness() + count);
		
		return tempStack;
	}
	
	
	public void allPaths() {
		Vertex start, end;	
		Stack tempStack = null;
		
		for(int i = 0; i < vertices.size(); i++) {
			start = vertices.ithVertex(i);
			
			for(int j = i; j < vertices.size(); j++) {				
				end = vertices.ithVertex(j);
				Path path = new Path(start, end, null);
				
				if(start != end) {
					tempStack = getShortestPath(start, end);
					path.setPathh(tempStack);
					shortestPaths.add(path);
				}
					
			}
		}
	}
	
	
	public void betweeness() {
		int temp = 0;
		int num;
		int vv = 0;
		
		for(int i = 0; i < vertices.size(); i++) {				
			num = vertices.ithVertex(i).getBetweeness();
			if(num > temp) {
				temp = num;
				vv = vertices.ithVertex(i).getName();
			}
		}
		System.out.print(vv + " - " + temp);
	}
	
	
	public void closeness() {
		double temp = 100;
		double num;
		int sýra = 0;
		
		for(int i = 0; i < vertices.size(); i++) {
			num = vertices.ithVertex(i).getCloseness();		
			if(num < temp && num != 1) {
				sýra = i;
				temp = num;
			}
		}
		double numm = 1 / vertices.ithVertex(sýra).getCloseness();
		System.out.print(vertices.ithVertex(sýra).getName() + " - " + numm);
	}
	
	
}
