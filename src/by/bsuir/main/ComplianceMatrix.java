package by.bsuir.main;

import by.bsuir.main.JsonParser.Data;

public class ComplianceMatrix {
	
	private static int matrix[][];
	private Data data;
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public static int[][] getMatrixFromStatic() {
		return matrix;
	}
	
	public ComplianceMatrix() {
		JsonParser parser = new JsonParser();
		data = parser.getData();
		int count = Tree.getCount();
		matrix = new int[count][15];
		buildMatrix();
	}
	
	private void buildMatrix() {
		Tree t = Tree.getRoot();
		traverse(t);
	}
	
	private void traverse(Tree t) {
		if (t==null) return;
		if (t instanceof Node) {
			Node n = (Node) t;
			char ch = n.getOperation();
			if (ch=='+' | ch=='-') {
				setDevices(ch, n.getId());
				matrix[n.getId()-1][data.getDeviceNumberWithMinCoef(0)-1] += 1;				
			}
			if (ch=='*' | ch=='/') {
				setDevices(ch, n.getId());
				matrix[n.getId()-1][data.getDeviceNumberWithMinCoef(1)-1] += 1;
			}
			if (ch=='f' | ch=='F') {
				setDevices(ch, n.getId());
				matrix[n.getId()-1][data.getDeviceNumberWithMinCoef(2)-1] += 1;
			}
			if (ch=='=') {
				setDevices(ch, n.getId());
				matrix[n.getId()-1][data.getDeviceNumberWithMinCoef(4)-1] += 1;
			}
			traverse(n.getLeft());
			traverse(n.getRight());
		} else {
			int x = ((Leaf) t).getX();
			setDevices(x, t.getId());
			matrix[t.getId()-1][data.getDeviceNumberWithMinCoef(3)-1] += 1;
		}		
	}
	
	private void setDevices(char operation, int vertex) {
		int devices[] = data.getDeviceNumbers(operation);
		for (int i=0; i<3; i++) {
			matrix[vertex-1][devices[i]-1] = 1;
		}
	}
	
	private void setDevices(int operation, int vertex) {
		int[] devices = data.getInputDeviceNumbers();
		for (int i=0; i<3; i++) {
			matrix[vertex-1][devices[i]-1] = 1;
		}
	}
	
	
}
