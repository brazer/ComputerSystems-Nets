package by.bsuir.main;

import java.util.ArrayList;

import by.bsuir.main.JsonParser.Data;

public class TimeOfDevice {

	@SuppressWarnings("unchecked")
	private ArrayList<Integer>[] times = new ArrayList[10];
	
	public ArrayList<Integer>[] getTimes() {
		return times;
	}
	
	public TimeOfDevice() {
		Data d = JsonParser.getDataFromStatic();
		ArrayList<String>[] paths = Path.getPathsFromStatic();
		int m[][] = ComplianceMatrix.getMatrixFromStatic();
		if (paths[0]==null) {
			Path path = new Path();
			paths = path.getPaths();
		}
		for (int i=0; i<paths.length; i++) {
			times[i] = new ArrayList<Integer>();
			for (int j=0; j<paths[i].size(); j++) {
				int number = Integer.parseInt(paths[i].get(j));	
				for (int k=0; k<m[number-1].length; k++) {
					if (m[number-1][k]==2) {
						int time = d.getTime(k+1);
						times[i].add(time);
						break;
					}
				}				
			}
		}
	}
	
}
