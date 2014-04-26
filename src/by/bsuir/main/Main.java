package by.bsuir.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {

	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton showGraph = new JButton("Показать граф");
	private JLabel label = new JLabel("Введите функцию:");
	private JTextField functionField = 
			new JTextField("Y = x1*x2+x3*x4+x7*x5+x6/F(x8/x9-x10)");
	
	public static void main(String[] args) {
		System.out.println("Hi");
		new Main();
	}
	
	public Main() {
		JFrame frame = new JFrame();
		frame.setTitle("Основное окно");
		frame.setSize(500, 200);
		showGraph.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				show();				
			}
		});
		panel.add(label);
		panel.add(functionField);
		buttonPanel.add(showGraph);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	private void show() {
		GraphFrame frame = new GraphFrame(functionField.getText().toCharArray());
		frame.setTitle("Граф");
		frame.setSize(550, 550);
		frame.setVisible(true);
	}
	
}
