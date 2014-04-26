package by.bsuir.main;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

public class GraphFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	public static ArrayList<Edge> edges;
	private Graph graph;
	private static char[] function;
	
	class Edge	{
		public final String name1, name2;
		public Edge(String n1, String n2) {
			name1 = n1;
			name2 = n2;
		}
	}
	
	public GraphFrame(char[] charArray) {
		function = charArray;
        Container content = getContentPane();
        graph = new Graph();
        content.add(graph);
        pack();
	}

	public static char[] getFunction() {
		return function;
	}
	
}

class ParsingFunction {
	
	public static void parseFunction(char[] str) {
		buildTree(str);
	}
	
	private static void buildTree(char[] str) {
		for (int i=0; i<str.length; i++) {
			if (str[i]=='x') {
				
			}
			if (str[i]=='*') {
				
			}
			if (str[i]=='/') {
				
			}
			if (str[i]=='+') {
				
			}
			if (str[i]=='-') {
				
			}
			if (str[i]=='f') {
				
			}
		}
	}
	
}
