package by.bsuir.main;

import java.awt.*;
import javax.swing.*;

public class MatrixFrame extends JFrame {

	private static final long serialVersionUID = -4071794196257015578L;
	
	public MatrixFrame() {
		int matrix[][] = Matrix.buildMatrix();
		int length = matrix.length + 1;
		JPanel panel = new JPanel();     
        panel.setLayout(new GridLayout(length, length));  
        for (int i=0; i<length; i++) 
        	for (int j=0; j<length; j++) {
        		if (i==0) panel.add(new TextField(j));
        		else
        			if (j==0) panel.add(new TextField(i));
        			else
        				panel.add(new TextField(matrix[i-1][j-1]));
        	}
        Container pane = getContentPane();
        pane.add(panel);
	}
	
	public MatrixFrame(int matrix[][]) {
		int lenRow = matrix.length + 1;
		int lenColumn = matrix[0].length + 1;
		JPanel panel = new JPanel();     
        panel.setLayout(new GridLayout(lenRow, lenColumn));  
        for (int i=0; i<lenRow; i++) 
        	for (int j=0; j<lenColumn; j++) {
        		if (i==0) panel.add(new TextField(j));
        		else
        			if (j==0) panel.add(new TextField(i));
        			else {
        				char ch = ' ';
        				if (matrix[i-1][j-1]==1) ch = '-';
        				if (matrix[i-1][j-1]==2) ch = '+';
        				panel.add(new TextField(ch));
        			}
        	}
        Container pane = getContentPane();
        pane.add(panel);
	}
	
	class TextField extends JTextField {	
		private static final long serialVersionUID = 5950948330642467680L;
		public TextField(int s) {
			super(""+s);
			if (s>0) setBackground(Color.LIGHT_GRAY);		
			setFocusable(false);
		}	
		public TextField(char ch) {
			super(""+ch);
			if (ch=='+') 
				setBackground(Color.GREEN);				
			if (ch=='-')
				setBackground(Color.LIGHT_GRAY);
			setFocusable(false);
		}
	}
	
}
