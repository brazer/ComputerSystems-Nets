package by.bsuir.main;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class EdgeFrame extends JFrame {

	private static final long serialVersionUID = 7211949511231058150L;
	
	public EdgeFrame() {
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setLineWrap(true);
		area.setText(getDescription());
		area.setBackground(Color.lightGray);
		area.setFocusable(false);
		Container pane = getContentPane();
		pane.add(area);
	}
	
	private String getDescription() {
		String s = "";
		for (int i=0; i<Edge.edges.size(); i++) {
			Edge e = Edge.edges.get(i);
			if (i>0) s += ", ";
			s += e.getId()+"("+e.getIdVertex1()+","+e.getIdVertex2()+")";
		}
		return s;
	}
	
}
