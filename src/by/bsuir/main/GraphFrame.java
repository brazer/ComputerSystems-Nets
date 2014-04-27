package by.bsuir.main;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;

public class GraphFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	public static ArrayList<Edge> edges;
	private Graph graph;
	private static char[] function;
	
	class Edge	{
		public final String name1, name2;
		public Edge(String n1, String n2) {
			name1 = n1;
			name2 = n2;
		}
	}
	
	public GraphFrame(char[] charArray) {
		function = charArray;
		ParsingFunction pf = new ParsingFunction();
		Tree tree = pf.parseFunction(function);
        Container content = getContentPane();
        graph = new Graph();
        content.add(graph);
        pack();
	}

	public static char[] getFunction() {
		return function;
	}
	
}

class ParsingFunction {
	
	private Stack<Tree> treeBuilding = new Stack<Tree>();
	private boolean highFlag = false, lowFlag = false;
	
	public Tree parseFunction(char[] str) {
		return buildTree(str);
	}
	
	private Tree buildTree(char[] str) {
		for (int i=0; i<str.length; i++) {
			if (str[i]=='x') {
				char[] number = {str[i+1], str[i+2]};
				Leaf l = new Leaf(getNumber(number));
				if (highFlag) {
					Node n = (Node) treeBuilding.pop();
					Tree t = treeBuilding.pop();
					n.setLeft(l);
					n.setRight(t);
					treeBuilding.push(n);
					highFlag = false;
				} else treeBuilding.push(l);
			}
			if (str[i]=='*') processHigh(str[i]);
			if (str[i]=='/') processHigh(str[i]);
			if (str[i]=='+') processLow(str[i]);
			if (str[i]=='-') processLow(str[i]);
			if (str[i]=='F' | str[i]=='f') {
				Node f = new Node(str[i]);
				i += 2;
				char arg[] = getArgument(str, i);
				ParsingFunction p = new ParsingFunction();
				Tree t = p.buildTree(arg);
				f.setLeft(t);
				treeBuilding.push(f);
				i += arg.length + 1;
			}
		}		
		while(treeBuilding.size()>1) processStack();		
		return treeBuilding.pop();
	}
	
	private static int getNumber(char[] s) {
		int n = -1;
		try {
			if (s[1]=='0')
				n = Integer.parseInt(String.valueOf(s));
			else n = Integer.parseInt(String.valueOf(s[0]));
		} catch(NumberFormatException ex) {
			ex.printStackTrace(); 
		}
		return n;			
	}
	
	private void processHigh(char ch) {
		highFlag = true;
		Node node = new Node(ch);
		treeBuilding.push(node);
	}
	
	private void processLow(char ch) {
		Node n = new Node(ch);
		checkLowFlag();
		treeBuilding.push(n);
	}
	
	private void checkLowFlag() {
		if (lowFlag) processStack();
		else lowFlag = true;
	}
	
	private void processStack() {
		Tree tRight = treeBuilding.pop();
		Node tOper = (Node) treeBuilding.pop();
		Tree tLeft = treeBuilding.pop();
		tOper.setLeft(tLeft);
		tOper.setRight(tRight);
		treeBuilding.push(tOper);
	}
	
	private char[] getArgument(char[] expr, int i) {		
		int len = 0, beg = i;
		while(expr[i]!=')') {
			len++; i++;
		}
		char ch[] = new char[len];		
		for (int j=0, k=beg; j<len; k++, j++) 
			ch[j] = expr[k];
		return ch;
	}
	
}
