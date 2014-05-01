package by.bsuir.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {

	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton showGraph = new JButton("Показать граф");
	private JButton showMatrix = new JButton("Показать матрицу смежности");
	private JButton showEdges = new JButton("Показать дугами");
	private JButton showSpecification = new JButton("Показать спецификацию");
	private JButton showPaths = new JButton("Показать пути");
	private JButton showComplianceMatrix = new JButton("Показать матрицу соответствия");
	private JButton showFunctionVector = new JButton("Показать вектор назначения");
	private JButton showRealisationVector = new JButton("Показать вектор реализации");
	private JLabel label = new JLabel("Введите функцию:");
	private JTextField functionField = 
			new JTextField("Y = x1*x2+x3*x4+x7*x5+x6/F(x8/x9-x10)");
	private JButton parseButton = new JButton("Обработать строку");
	
	public static void main(String[] args) {
		System.out.println("Hi");
		new Main();
	}
	
	public Main() {
		JFrame frame = new JFrame();
		frame.setTitle("Основное окно");
		frame.setSize(500, 200);
		parseButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				parseString();
				showGraph.setEnabled(true);
				showMatrix.setEnabled(true);
				showEdges.setEnabled(true);
				showSpecification.setEnabled(true);
				showPaths.setEnabled(true);
				showComplianceMatrix.setEnabled(true);
			}
		});
		showGraph.setEnabled(false);
		showGraph.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				showGraph();				
			}
		});
		showMatrix.setEnabled(false);
		showMatrix.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				showMatrix();
			}
		});
		showEdges.setEnabled(false);
		showEdges.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				showEdges();
			}
		});
		showSpecification.setEnabled(false);
		showSpecification.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				showSpecification();
			}
		});
		showPaths.setEnabled(false);
		showPaths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPaths();
			}
		});
		showComplianceMatrix.setEnabled(false);
		showComplianceMatrix.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				showComplianceMatrix();
				showFunctionVector.setEnabled(true);
				showRealisationVector.setEnabled(true);
			}
		});
		showFunctionVector.setEnabled(false);
		showFunctionVector.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				showFunctionVector();
			}
		});
		showRealisationVector.setEnabled(false);
		showRealisationVector.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				showRealisationVector();
			}
		});
		panel.add(label);
		panel.add(functionField);
		panel.add(parseButton);
		buttonPanel.add(showGraph);
		buttonPanel.add(showMatrix);
		buttonPanel.add(showEdges);
		buttonPanel.add(showSpecification);
		buttonPanel.add(showPaths);
		buttonPanel.add(showComplianceMatrix);
		buttonPanel.add(showFunctionVector);
		buttonPanel.add(showRealisationVector);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	private void parseString() {
		Parser pf = new Parser();
		pf.parse(functionField.getText().toCharArray());		
		Edge.buildEdges();
	}
	
	private void showGraph() {
		GraphFrame frame = new GraphFrame();
		frame.setTitle("Граф");
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
	
	private void showMatrix() {
		MatrixFrame frame = new MatrixFrame();
		frame.setTitle("Матрица смежности");
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	private void showEdges() {
		TextAreaFrame frame = new TextAreaFrame();
		frame.setTitle("Описание дугами");
		frame.setSize(545, 70);
		frame.setVisible(true);
	}
	
	private void showSpecification() {
		Specification spec = new Specification();
		final JTable table = new JTable(spec.getData(), spec.getColumns());
		final TablePanel panel = new TablePanel(table);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TablePanel.createAndShowGUI(panel);
            }
        });
	}
	
	private void showPaths() {
		PathFrame frame = new PathFrame();
		frame.setTitle("Пути");
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	private void showComplianceMatrix() {
		ComplianceMatrix matrix = new ComplianceMatrix();
		MatrixFrame frame = new MatrixFrame(matrix.getMatrix());
		frame.setTitle("Матрица соответствия");
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	private void showFunctionVector() {
		FunctionVector vector = new FunctionVector();
		TextAreaFrame frame = new TextAreaFrame(vector.getVector(), "P(");
		frame.setTitle("Вектор назначения");
		frame.setSize(500, 70);
		frame.setVisible(true);
	}
	
	private void showRealisationVector() {
		RealisationVector vector = new RealisationVector();
		TextAreaFrame frame = new TextAreaFrame(vector.getVector(), "T(");
		frame.setTitle("Вектор реализации");
		frame.setSize(500, 70);
		frame.setVisible(true);
	}
	
}
