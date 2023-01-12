
public class Node2 {

	private Edge data;
	private Node2 link;
	
	public Node2(Edge dataToAdd) {
		data = dataToAdd;
		link = null;
	}

	public Edge getData2() {return data;}
	public void setData2(Edge data) {this.data = data;}
	public Node2 getLink2() {return link;}
	public void setLink2(Node2 link) {this.link = link;}
	
}
