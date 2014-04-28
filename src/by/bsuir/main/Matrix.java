package by.bsuir.main;

public class Matrix {
	
	private static int matrix[][];
	
	public static int[][] buildMatrix() {
		int length = Tree.getCount();
		matrix = new int[length][length];
		for (int i=0; i<Edge.getCount(); i++) {
			Edge e = Edge.edges.get(i);
			matrix[e.getIdVertex1()-1][e.getIdVertex2()-1] = 1;
			matrix[e.getIdVertex2()-1][e.getIdVertex1()-1] = 1;
		}
		return matrix;
	}
	
}
