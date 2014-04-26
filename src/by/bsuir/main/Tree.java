package by.bsuir.main;

public abstract class Tree {

	private int id;
	private static Node root = null;
	
	public static Node getRoot() {
		//if (root==null) root = new Node();
		return root;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

class Node extends Tree {
	
	private Operation OPER;
	private Leaf left, right;
	
	public Node(Operation oper, Leaf l, Leaf r) {
		this.OPER = oper;
		left = l;
		right = r;
	}
	
	public Operation getOperation() {
		return OPER;
	}
	
	public Leaf getLeft() {
		return left;
	}
	
	public Leaf getRight() {
		return right;
	}
	
	class Operation {
		public static final int
			ADD=0, SUB=1, MUL=2, DIV=3, FUNC=4, OUT=5;
	}
}

class Leaf extends Tree {
	
	private Variable X;
	
	public Leaf(Variable v) {
		X = v;
	}
	
	public Variable getX() {
		return X;
	}
	
	class Variable {
		public static final int 
			X1=0, X2=1, X3=2, X4=3, X5=4, X6=5, X7=6, X8=7, X9=8, X10=9;
	}
	
}