package com.jeet.ds.tree;

public class BinaryTree {

	private Node root;

	public BinaryTree(Node root) {
		super();
		this.root = root;
	}

	public void addNode(Node newNode) {
		addNode(root, newNode);

	}

	private void addNode(Node pNode, Node newNode) {
		if (newNode.getData() < pNode.getData()) {
			if (pNode.getLeftNode() == null) {
				pNode.setLeftNode(newNode);
				newNode.setParentNode(pNode);
			} else {
				addNode(pNode.getLeftNode(), newNode);
			}
		} else {
			if (pNode.getRightNode() == null) {
				pNode.setRightNode(newNode);
				newNode.setParentNode(pNode);
			} else {
				addNode(pNode.getRightNode(), newNode);
			}
		}
	}

	public void preOrderTraversal() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.getData() + ", ");
			preOrder(node.getLeftNode());
			preOrder(node.getRightNode());
		}
	}

	public void postOrderTraversal() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeftNode());
			postOrder(node.getRightNode());
			System.out.print(node.getData() + ", ");
		}
	}

	public void inOrderTraversal() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.getLeftNode());
			System.out.print(node.getData() + ", ");
			inOrder(node.getRightNode());
		}
	}

	public void deleteNode(Node node) {
		// Node is a leaf node //
		if( node.getLeftNode() == null && node.getRightNode() == null){
			if(isRightNode(node.getParentNode(), node)){
				node.getParentNode().setRightNode(null);
			}else{
				node.getParentNode().setLeftNode(null);
			}
			// Only left child is there//
		}else if( node.getLeftNode() != null && node.getRightNode() == null){
			if(isRightNode(node.getParentNode(), node)){
				node.getParentNode().setRightNode(node.getLeftNode());
			}else{
				node.getParentNode().setLeftNode(node.getLeftNode());
			}
			// Only Right child is there //
		}else if( node.getLeftNode() == null && node.getRightNode() != null){
			if( isRightNode(node.getParentNode(), node)){
				node.getParentNode().setRightNode(node.getRightNode());
			}else{
				node.getParentNode().setLeftNode(node.getRightNode());
			}
			
		}else{
			Node psNode = predessor(node);
			deleteNode(psNode);
			psNode.setParentNode(node.getParentNode());
			psNode.setLeftNode(node.getLeftNode());
			psNode.setRightNode(node.getRightNode());
			if( isRightNode(node.getParentNode(), node)){
				node.getParentNode().setRightNode(psNode);
			}else{
				node.getParentNode().setLeftNode(psNode);
			}
		}

	}
	
	private boolean isRightNode(Node n1, Node n2){
		if( n1.getRightNode() == n2){
			return true;
		}
		return false;
	}

	// Find Successor
	public Node sucessor(Node node) {
		Node sucessor = null;
		if (node.getRightNode() != null) {
			Node newNode = node.getRightNode();
			while (newNode != null) {
				sucessor = newNode;
				newNode = newNode.getLeftNode();
			}
		} else {
			sucessor = findRightParent(node);
		}
		return sucessor;
	}

	private Node findRightParent(Node node) {
		Node newNode = null;
		if (node.getParentNode() != null) {
			if (node.getParentNode().getLeftNode() == node) {
				newNode = node.getParentNode();
			} else {
				newNode = findRightParent(node.getParentNode());
			}
		}
		return newNode;
	}

	// Find Predessor
	public Node predessor(Node node) {
		Node pNode = null;
		if (node.getLeftNode() != null) {
			Node newNode = node.getLeftNode();
			while (newNode != null) {
				pNode = newNode;
				newNode = newNode.getRightNode();
			}
		} else {
			pNode = findLeftParent(node);
		}
		return pNode;
	}

	private Node findLeftParent(Node node) {
		Node pNode = null;
		if (node.getParentNode() != null) {
			if (node.getParentNode().getRightNode() == node) {
				pNode = node.getParentNode();
			} else {
				pNode = findLeftParent(node.getParentNode());
			}
		}
		return pNode;
	}

}
