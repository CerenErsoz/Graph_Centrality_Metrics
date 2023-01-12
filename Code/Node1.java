
public class Node1 {

	private Vertex data;
	private Node1 link;
	
	public Node1(Vertex dataToAdd) {
		data = dataToAdd;
		link = null;
	}

	public Vertex getData1() {return data;}
	public void setData1(Vertex data) {this.data = data;}
	public Node1 getLink1() {return link;}
	public void setLink1(Node1 link) {this.link = link;}
	
}
