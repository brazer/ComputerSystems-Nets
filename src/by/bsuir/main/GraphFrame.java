package by.bsuir.main;

import java.awt.Container;
import javax.swing.JFrame;

public class GraphFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private Graph graph;
	
	public GraphFrame() {
        Container content = getContentPane();
        graph = new Graph();
        content.add(graph);
        pack();
	}
	
}
