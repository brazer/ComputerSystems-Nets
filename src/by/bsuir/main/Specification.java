package by.bsuir.main;

public class Specification {

	private String[] columns;
	private Object[][] data;
	
	public String[] getColumns() {
		return columns;
	}
	
	public Object[][] getData() {
		return data;
	}
	
	public Specification() {
		int count = Tree.getCount();
		data = new Object[1][count];
		columns = new String[count];
		for (int i=0; i<count; i++)
			columns[i] = String.valueOf(i+1);
		Node root = Tree.getRoot();
		traverse(root);
	}
	
	private void traverse(Tree t) {
		if (t==null) return;
		if (t instanceof Node) {
			Node n = (Node) t;
			data[0][n.getId()-1] = String.valueOf(n.getOperation());
			traverse(n.getLeft());
			traverse(n.getRight());
		} else
			data[0][t.getId()-1] = "x"+String.valueOf(((Leaf) t).getX());
	}
	
}
