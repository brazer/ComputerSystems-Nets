package by.bsuir.main;

public class FunctionVector {
	
	private int vector[] = new int[Tree.getCount()];

	public int[] getVector() {
		return vector;
	}
	
	public FunctionVector() {
		int m[][] = ComplianceMatrix.getMatrixFromStatic();
		for (int i=0; i<m.length; i++)
			for (int j=0; j<m[0].length; j++) 
				if (m[i][j]==2) vector[i] = j + 1;
	}
	
}
