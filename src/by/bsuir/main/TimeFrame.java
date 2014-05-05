package by.bsuir.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimeFrame extends JFrame {

	private static final long serialVersionUID = 3846038183192474896L;
	private int max = 0;	
	
	public TimeFrame() {
		JPanel panel = new JPanel();  
		TimeOfDevice tDev = new TimeOfDevice();
		ArrayList<Integer>[] times = tDev.getTimes();
		panel.setLayout(new GridLayout(times.length, 1));
		for (int i=0; i<times.length; i++) {
			if (times[i]==null) break;
			JTextField line = new JTextField();
			line.setFocusable(false);
			String str = "T"+(i+1)+" = ";
			int sum = 0;
			for (int j=0; j<times[i].size(); j++) {
				str += times[i].get(j) + ((j<times[i].size()-1) ? " + " : " = ");
				sum += times[i].get(j);
			}
			str += ""+sum;
			line.setText(str);
			panel.add(line);
			if (sum>max) max = sum;
		}
		Container pane = getContentPane();
        pane.add(panel);
        JLabel label = new JLabel("Tmax = "+max);
        pane.add(label, BorderLayout.EAST);
	}
	
}
