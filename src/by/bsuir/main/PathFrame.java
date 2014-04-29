package by.bsuir.main;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class PathFrame extends JFrame {

	private static final long serialVersionUID = 4400217168733418770L;

	public PathFrame() {
		JPanel panel = new JPanel();  		
		Path p = new Path();
		ArrayList<String>[] paths = p.getPaths();
		panel.setLayout(new GridLayout(paths.length, 1));
		for (int i=0; i<paths.length; i++) {
			if (paths[i]==null) break;
			JTextField line = new JTextField();
			line.setFocusable(false);
			String str = "L"+(i+1)+": ";
			for (int j=paths[i].size()-1; j>=0; j--)
				str += paths[i].get(j) + ((j>0) ? ", " : ".");
			line.setText(str);
			panel.add(line);
		}
		Container pane = getContentPane();
        pane.add(panel);
	}
	
}
