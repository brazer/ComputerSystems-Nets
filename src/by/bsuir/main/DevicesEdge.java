package by.bsuir.main;

import by.bsuir.main.JsonParser.Data;

class DevicesEdge extends Edge {
	
	public DevicesEdge(String n1, String n2) {
		super(n1, n2);
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
		devEdges.add(edge);
		traverse(child);
	}
	
	private static String getNodeInfo(Node n) {
		String s = "V"+n.getId()+": ";
		Data d = JsonParser.getDataFromStatic();
		char oper = n.getOperation();
		if (oper=='=')
			s += ""+d.getDeviceNumberWithMinCoef(4);
		if (oper=='+' | oper=='-')
			s += ""+d.getDeviceNumberWithMinCoef(0);
		if (oper=='*' | oper=='/')
			s += ""+d.getDeviceNumberWithMinCoef(1);
		if (oper=='F' | oper=='f')
			s += ""+d.getDeviceNumberWithMinCoef(2);
		return s;
	}
	
	private static void addEdge(Node n, Leaf l) {
		String str1 = getNodeInfo(n);
		String str2 = getLeafInfo(l);
		Edge edge = new Edge(str1, str2);
		edge.setIds(n.getId(), l.getId());
		devEdges.add(edge);
	}
	
	private static String getLeafInfo(Leaf l) {
		String s = "V"+l.getId()+": ";
		Data d = JsonParser.getDataFromStatic();
		s += ""+d.getDeviceNumberWithMinCoef(3);
		return s;
	}
	
}