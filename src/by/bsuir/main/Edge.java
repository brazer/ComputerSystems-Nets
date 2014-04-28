package by.bsuir.main;

import java.util.ArrayList;

class Edge	{
	
	private int id;
	private static int count = 0;
	public final String name1, name2;
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public Edge(String n1, String n2) {
		count++; id = count;
		name1 = n1;
		name2 = n2;
	}
	
	public int getId() {
		return id;
	}
	
	public static void buildEdges() {
		Tree t = Tree.getRoot();
		traverse((Node) t);
	}
	
	private static void traverse(Node n) {
		String str1 = getNodeInfo(n);
		Tree left = n.getLeft();
		Tree right = n.getRight();
		processChild(str1, left);
		processChild(str1, right);
	}
	
	private static void processChild(String str1, Tree t) {
		if (t instanceof Node) 
			addEdgeAndTraverse(str1, (Node) t);
		if (t instanceof Leaf)
			addEdge(str1, (Leaf) t);
	}
	
	private static void addEdgeAndTraverse(String str1, Node n) {
		String str2 = getNodeInfo(n);
		Edge edge = new Edge(str1, str2);
		edges.add(edge);
		traverse(n);
	}
	
	private static String getNodeInfo(Node n) {
		String s;
		s = String.valueOf(n.getId());
		s += ": "+String.valueOf(n.getOperation());
		return s;
	}
	
	private static void addEdge(String str1, Leaf l) {
		String str2 = getLeafInfo(l);
		Edge edge = new Edge(str1, str2);
		edges.add(edge);
	}
	
	private static String getLeafInfo(Leaf l) {
		String s;
		s = String.valueOf(l.getId());
		s += ": X"+String.valueOf(l.getX());
		return s;
	}
	
}