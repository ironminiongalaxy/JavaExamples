package com.dj.example;

import com.dj.example.MyBinaryTree.Node;

public class MyBinaryTreeEg {
	public static void main(String args[]) {

		MyBinaryTree myTree = new MyBinaryTree();

		myTree.insert(2);
		myTree.insert(3);
		myTree.insert(5);
		myTree.insert(10);
		myTree.insert(20);
		myTree.insert(7);
		myTree.insert(1);

		System.out.println("Height of Tree: " + myTree.height);

		for (int i = 1; i <= myTree.height; i++) {
			System.out.print("Level " + (i - 1) + ": ");
			String levelNodes = printLevel(myTree.root, i);
			System.out.print(levelNodes + "\n");
		}

	}

	public static String printLevel(Node t, int level) {
		if (t == null) {
			return "";
		}
		if (level == 1) {
			return t.data + " ";
		} else if (level > 1) {
			String leftStr = printLevel(t.left, level - 1);
			String rightStr = printLevel(t.right, level - 1);
			return leftStr + rightStr;
		} else
			// you need this to get it to compile
			return "";
	}

}