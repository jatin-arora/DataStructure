package com.jeet.ds.tree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		BinaryTree bTree = new BinaryTree(n1);
		Node n5 = new Node(5);
		Node n7 = new Node(7);
		Node n2 = new Node(2);
		Node n11 = new Node(11);
		Node n8 = new Node(8);
		Node n15 = new Node(15);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		bTree.addNode(n5);
		bTree.addNode(n7);
		bTree.addNode(n2);
		bTree.addNode(n11);
		bTree.addNode(n8);
		bTree.addNode(n15);
		bTree.addNode(n13);
		bTree.addNode(n14);
		System.out.println("Pre Order");
		bTree.preOrderTraversal();
		System.out.println(" \n\nNow Iost Order");
		bTree.postOrderTraversal();
		System.out.println(" \n\nNow In Order");
		bTree.inOrderTraversal();
		Node n = n2;
		System.out.println("\n\nSucessor of "+n +" is "+bTree.sucessor(n));
		System.out.println("\nPredessor of "+n +" is "+bTree.predessor(n));
		bTree.deleteNode(n5);
		System.out.println(" \n\nNow In Order");
		bTree.inOrderTraversal();
	}

}
