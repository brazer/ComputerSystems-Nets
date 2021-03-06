package by.bsuir.main;

public abstract class Tree {

	private int id;
	private static int count = 0;
	private static Node root = null;
	
	public Tree() {
		count++; id = count;
	}
	
	public static void setRoot(Node r) {
		root = r;
	}
	
	public static Node getRoot() {
		return root;
	}

	public int getId() {
		return id;
	}
	
	public static int getCount() {
		return count;
	}
	
}

class Node extends Tree {
	
	private char OPER;
	private Tree left=null, right=null;
	
	public Node(char i) {
		OPER = i;
	}
	
	public char getOperation() {
		return OPER;
	}
	
	public Tree getLeft() {
		return left;
	}
	
	public void setLeft(Tree l) {
		left = l;
	}
	
	public Tree getRight() {
		return right;
	}
	
	public void setRight(Tree r) {
		right = r;
	}
	
	class Operation {
		public static final int
			ADD=0, SUB=1, MUL=2, DIV=3, FUNC=4, OUT=5;
	}
}

class Leaf extends Tree {
	
	private int X;
	
	public Leaf(int i) {
		X = i;
	}
	
	public int getX() {
		return X;
	}
	
	static class Variable {
		
		private static Exception ex = new Exception("Ошибка разбора переменной X");
		public static final String 
			X1="x1", X2="x2", X3="x3", X4="x4", X5="x5", 
			X6="x6", X7="x7", X8="x8", X9="x9", X10="x10";
		
		public static String getVariable(int n) throws Exception {
			switch(n) {
			case 1: return X1;
			case 2: return X2;
			case 3: return X3;
			case 4: return X4;
			case 5: return X5;
			case 6: return X6;
			case 7: return X7;
			case 8: return X8;
			case 9: return X9;
			case 10: return X10;
			}
			throw ex;
		}
	}
	
}