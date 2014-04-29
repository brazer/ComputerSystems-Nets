package by.bsuir.main;

import java.util.Stack;

class Parser {
	
	private Stack<Tree> treeBuilding = new Stack<Tree>();
	private boolean highFlag = false, lowFlag = false;
	
	public Tree parse(char[] str) {
		Tree t = buildTree(str);
		addRoot((Node) t);
		return Tree.getRoot();
	}
	
	private Tree buildTree(char[] str) {
		for (int i=0; i<str.length; i++) {
			if (str[i]=='x' | str[i]=='X') {
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
				Parser p = new Parser();
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
	
	private void addRoot(Node t) {
		Node root = new Node('=');
		root.setLeft(t);
		Tree.setRoot(root);
	}
	
}