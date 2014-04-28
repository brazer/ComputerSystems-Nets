package by.bsuir.main;

import java.util.ArrayList;

class Edge	{
	
	private int id;
	private static int count = 0;
	private int idVertex1, idVertex2;
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
	
	public int getIdVertex1() {
		return idVertex1;
	}
	
	public int getIdVertex2() {
		return idVertex2;
	}
		
	public void setIds(int id1, int id2) {
		this.idVertex1 = id1;
		this.idVertex2 = id2;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void buildEdges() {
		Tree t = Tree.getRoot();
		traverse((Node) t);
	}
	
	private static void traverse(Node n) {
		Tree left = n.getLeft();
		Tree right = n.getRight();
		processChild(n, left);
		processChild(n, right);
	}
	
	private static void processChild(Node n, Tree t) {
		if (t instanceof Node) 
			addEdgeAndTraverse(n, (Node) t);
		if (t instanceof Leaf)
			addEdge(n, (Leaf) t);
	}
	
	private static void addEdgeAndTraverse(Node parent, Node child) {
		String str1 = getNodeInfo(parent);
		String str2 = getNodeInfo(child);
		Edge edge = new Edge(str1, str2);
		edge.setIds(parent.getId(), child.getId());
		edges.add(edge);
		traverse(child);
	}
	
	private static String getNodeInfo(Node n) {
		String s;
		s = String.valueOf(n.getId());
		s += ": "+String.valueOf(n.getOperation());
		return s;
	}
	
	private static void addEdge(Node n, Leaf l) {
		String str1 = getNodeInfo(n);
		String str2 = getLeafInfo(l);
		Edge edge = new Edge(str1, str2);
		edge.setIds(n.getId(), l.getId());
		edges.add(edge);
	}
	
	private static String getLeafInfo(Leaf l) {
		String s;
		s = String.valueOf(l.getId());
		s += ": X"+String.valueOf(l.getX());
		return s;
	}
	
}