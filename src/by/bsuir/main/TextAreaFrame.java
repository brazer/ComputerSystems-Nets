package by.bsuir.main;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class TextAreaFrame extends JFrame {

	private static final long serialVersionUID = 7211949511231058150L;
	
	public TextAreaFrame() {
		JTextArea area = new JTextArea();
		area.setText(getDescription());
		setArea(area);
	}
	
	public TextAreaFrame(int vector[]) {
		JTextArea area = new JTextArea();
		area.setText(getString(vector));
		setArea(area);
	}
	
	private void setArea(JTextArea area) {
		area.setEditable(false);
		area.setLineWrap(true);
		area.setBackground(Color.lightGray);
		area.setFocusable(false);
		Container pane = getContentPane();
		pane.add(area);
	}
	
	public String getString(int vector[]) {
		String s = "P(";
		for (int i=0; i<vector.length; i++)
			s += ""+vector[i]+((i==vector.length-1) ? ")" : ", ");
		return s;
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
