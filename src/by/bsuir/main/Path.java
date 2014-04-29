package by.bsuir.main;

import java.util.ArrayList;

public class Path {
	
	@SuppressWarnings("unchecked")
	private ArrayList<String>[] paths = new ArrayList[10];
	private int count = 0;
	
	public ArrayList<String>[] getPaths() {
		return paths;
	}
	
	public Path() {
		Tree root = Tree.getRoot();
		for (int i=0; i<10; i++)
			paths[i] = new ArrayList<String>();
		traverse(root, new ArrayList<String>());
	}
	
	private void traverse(Tree t, ArrayList<String> s) {
		if (t instanceof Node) {
			Node n = (Node) t;
			s.add(String.valueOf(n.getId()));
			Tree left = n.getLeft();
			Tree right = n.getRight();						
			if (right!=null & left!=null) {	
				ArrayList<String> s1 = new ArrayList<String>();
				s1.addAll(s);
				traverse(right, s1);
				traverse(left, s);
			} else {
				if (left!=null) traverse(left, s);	
				else traverse(right, s);
			}
		} else {
			s.add(""+t.getId());
			paths[count].addAll(s);
			count++;			
		}
	}
	
}
