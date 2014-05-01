package by.bsuir.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class JsonParser {
	
	private Data d;
	
	public Data getData() {
		return d;
	}
	
	public JsonParser() {
		File file = new File("res//data.json");
		getFromFile(file);
	}
	
	private void getFromFile(File f) {
		File file = (f==null) ? openFile() : f;		
		try {
			read(file);			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ошибка обработки");
		}
	}
	private File openFile() {
		JFileChooser fileopen = new JFileChooser();             
		int ret = fileopen.showDialog(null, "Открыть файл");
		if (ret==JFileChooser.APPROVE_OPTION)
			return fileopen.getSelectedFile();
		else return null;
	}
	private void read(File file) throws IOException, FileNotFoundException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		d = new Data();
		String line;
		while ((line=br.readLine())!=null) 
			d.parseLine(line);
		br.close();
	}
	
	
	class Data {
		
		private Operation operations[] = new Operation[5];
		private int currentOperation, currentString=3;
		private int currentField[];
		
		class Operation {
			public String name;
			public int number[] = new int[3];
			public int time[] = new int[3];
			public int coefficient[] = new int[3];
		}
		
		public Data() {
			for (int i=0; i<5; i++) 
				operations[i] = new Operation();			
			operations[0].name = "+/-";
			operations[1].name = "*/:";
			operations[2].name = "Function";
			operations[3].name = "Input";
			operations[4].name = "Output";
		}
		
		public void parseLine(String line) {
			// Operations
			if (line.contains("PlusMinus")) {
				currentOperation = 0; return;
			}
			if (line.contains("MultipleDivide")) {
				currentOperation = 1; return;
			}
			if (line.contains("Function")) {
				currentOperation = 2; return;
			}
			if (line.contains("Input")) {
				currentOperation = 3; return;
			}
			if (line.contains("Output")) {
				currentOperation = 4; return;
			}
			if (line.contains("Device")) {
				currentField = operations[currentOperation].number;
				currentString = 0;
				return;
			}
			// Fields
			if (line.contains("Time")) {
				currentField = operations[currentOperation].time;
				currentString = 0;
				return;
			}
			if (line.contains("Coefficient")) {
				currentField = operations[currentOperation].coefficient;
				currentString = 0;
				return;
			}
			// Values
			if (currentString<3) {
				currentField[currentString] = getNumber(line.trim());
				currentString++;
			}
		}
		
		private int getNumber(String s) {
			int buf;
			buf = Integer.parseInt(s.replace(",", ""));
			return buf;
		}
		
		public int getDeviceNumberWithMinCoef(int operNumber) {
			int min = 100, number=-1;
			for (int i=0; i<3; i++) {
				if (operations[operNumber].coefficient[i] < min) {
					min = operations[operNumber].coefficient[i];
					number = operations[operNumber].number[i];
				}
			}
			return number;
		}
		
		public int[] getDeviceNumbers(char operation) {
			int numbers[] = new int[3];
			if (operation=='-' | operation=='+')
				numbers = operations[0].number;
			if (operation=='*' | operation=='/')
				numbers = operations[1].number;
			if (operation=='F' | operation=='f')
				numbers = operations[2].number;
			if (operation=='=')
				numbers = getOutputDeviceNumbers();
			return numbers;
		}
		
		public int[] getInputDeviceNumbers() {
			return operations[3].number;
		}
		
		public int[] getOutputDeviceNumbers() {
			return operations[4].number;
		}
		
	}
}
