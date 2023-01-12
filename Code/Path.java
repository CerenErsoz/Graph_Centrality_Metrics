import java.util.Stack;

public class Path {

	private Vertex start;
	private Vertex end;
	private Stack pathh;
	
	public Path(Vertex s, Vertex e, Stack p) {
		start = s;
		end = e;
		pathh = p;
	}

	public Vertex getStart() {return start;}
	public void setStart(Vertex start) {this.start = start;}
	public Vertex getEnd() {return end;}
	public void setEnd(Vertex end) {this.end = end;}
	public Stack getPathh() {return pathh;}
	public void setPathh(Stack pathh) {this.pathh = pathh;}
	
	
	public int pathSize() {
		return pathh.size();
	}
	
	
	
}
