
public class SingleLinkedList {

	Node1 head1;//vertex
	Node2 head2;//edge
	
	
	public void addEdge(Edge data) {
		Node2 newNode = new Node2(data);
		if(head2 == null)
			head2 = newNode;
		else {
			Node2 temp = head2;
			while(temp.getLink2() != null)
				temp = temp.getLink2();
			temp.setLink2(newNode);
		}
	}
	

	public void addVertex(Vertex data) {
		Node1 newNode = new Node1(data);
		if(head1 == null)
			head1 = newNode;
		else {
			Node1 temp = head1;
			while(temp.getLink1() != null)
				temp = temp.getLink1();
			temp.setLink1(newNode);
		}
	}
	

	public boolean searchEdge(int source, int destination) {//gönderilen baþlangýç bitiþ noktalarýna sahip edge ekli mi
		
		boolean flag = false;
		Node2 temp = head2;
		
		if(temp != null) {		
			int tempS = temp.getData2().getSource().getName();
			int tempD = temp.getData2().getDestination().getName();			
			
			while(temp != null) {
				if(tempS == source && tempD == destination || tempS == destination && tempD == source) {//1-2 zaten ekliyse 2-1 de eklenmesin diye
					flag = true;
					break;
				}
				temp = temp.getLink2();
			}
		}
		return flag;		
	}
	

	public boolean searchVertex(int name) {//gönderilen isimli vertex önceden eklenmiþ mi
		
		boolean flag = false;
		Node1 temp = head1;
		
		if(temp!= null) {
			while(temp != null) {
				if(temp.getData1().getName() == name) {
					flag = true;
					break;
				}
				temp = temp.getLink1();
			}
		}
		return flag;		
	}
	

	public Vertex vertex(int name){
		
		Vertex v = null;
		Node1 temp = head1;
		
		if(temp != null) {
			while(temp != null) {
				if(temp.getData1().getName() == name) {
					v = temp.getData1();
				}				
				temp = temp.getLink1();
			}
		}	
		return v;		
	}
	
	
	public Vertex ithVertex(int num) {
		Vertex v = null;
		Node1 temp = head1;
		int count = 1;
				
		if(temp != null) {
			while(count <= num) {
				count++;
				temp = temp.getLink1();
			}
			v = temp.getData1();			
		}		
		return v;
	}
	

	public int size() {	
		if(head1 == null) {
			return 0;
		}
		else {
			int count = 0;
			Node1 temp = head1;
			while(temp != null){
				temp = temp.getLink1();
				count++;
			}
			return count;
		}
	}

		
	public void resetingVertex() {
		Node1 temp = head1;
		Vertex v;
		
		if(temp != null) {
			while(temp != null) {
				v = temp.getData1();
				v.setParent(null);
				v.setVisited(true);
				temp = temp.getLink1();
			}			
		}				
	}
	

}
	
	


