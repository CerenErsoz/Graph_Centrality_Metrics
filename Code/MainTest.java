import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {

	public static void main(String[] args) throws IOException {
		
		Graph graph1 = new Graph();
		fileReading("karate_club_network.txt", graph1);
		graph1.allPaths();
				
		System.out.println("2019510036 Ceren Ersoz");
		System.out.print("\nZachary Karate Club Network The Highest Node for Betweennes: " );
		graph1.betweeness();
		System.out.print("\nZachary Karate Club Network The Highest Node for Closeness: " );
		graph1.closeness();
		
		System.out.println();
		/*
		Graph graph2 = new Graph();
		fileReading("facebook_social_network.txt", graph2);
		graph2.allPaths();
				
		System.out.print("\nFacebook Social Network The Highest Node for Betweennes: ");
		graph2.betweeness();
		System.out.print("\nFacebook Social Network The Highest Node for Closeness: ");
		graph2.closeness();
		*/
	}


	
	public static void fileReading(String str, Graph graph) throws IOException {			
		File file = new File(str);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		String line = null;		
		line = reader.readLine();
			
		while(line != null) {	
			String[] numbers = line.split(" ");			
			int vertex1 = Integer.parseInt(numbers[0]);
			int vertex2 = Integer.parseInt(numbers[1]);			
			graph.addEdge(vertex1, vertex2);
			line = reader.readLine();
		}
	}
	

}
