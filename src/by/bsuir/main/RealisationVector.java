package by.bsuir.main;

import by.bsuir.main.JsonParser.Data;

public class RealisationVector {

	private int vector[] = new int[Tree.getCount()];

	public int[] getVector() {
		return vector;
	}
	
	public RealisationVector() {
		int m[][] = ComplianceMatrix.getMatrixFromStatic();
		Data d = JsonParser.getDataFromStatic();
		for (int i=0; i<m.length; i++)
			for (int j=0; j<m[0].length; j++) 
				if (m[i][j]==2) 
					vector[i] = d.getTime(j+1);
	}
	
}
