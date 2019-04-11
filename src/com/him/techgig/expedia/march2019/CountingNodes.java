package com.him.techgig.expedia.march2019;

import java.util.Scanner;
import java.util.Stack;

public class CountingNodes {

	class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}

	}



	public static String countNodes(Node currNode) {

		Stack<Node> stack=new Stack<>();
		stack.push(currNode);
		String result="";
		while (!stack.isEmpty()) {
			Node node=stack.pop();
			int ht = getHeight(node);
			//System.out.println("node:"+node.value);
			//System.out.println("ht:"+ht);
			if(node.left!=null) {
				stack.push(node.left);
			}
			
			if(node.right!=null) {
				stack.push(node.right);
			}
			
			
			 int noOfNodes = findNodesAtDepth(node, ht);
			 result=result+noOfNodes +" ";
			
		}
		return result.trim();
	}

	private static int findNodesAtDepth(Node currNode, int ht) {
		int noOfNodes = 0;

		if ((currNode.left == null || currNode.right == null) && ht == 1) {
			return 1;
		}
		if (currNode.left != null) {
			noOfNodes = noOfNodes + findNodesAtDepth(currNode.left, ht - 1);
		}
		if (currNode.right != null) {
			noOfNodes = noOfNodes + findNodesAtDepth(currNode.right, ht - 1);
		}

		return noOfNodes;
	}

	private static int getHeight(Node currNode) {
		if (currNode.left == null && currNode.right == null) {
			return 1;
		} else {
			int htLeft = 0;
			int htRight = 0;
			if (currNode.left != null) {
				htLeft = 1+getHeight(currNode.left);
			}
			if (currNode.right != null) {
				htRight = 1+getHeight(currNode.right);
			}
			return htLeft > htRight ? htLeft : htRight;
		}

	}

	public static void main(String[] args) {
		CountingNodes cn = new CountingNodes();
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine().trim());
		Node rootNode=null;
		//Node node=null;
		for(int i=0;i<n-1;i++) {
			String[] lineContent=scanner.nextLine().split(" ");
			int parent=Integer.parseInt(lineContent[0]);
			int child=Integer.parseInt(lineContent[1]);
			if(i==0) {
				 rootNode=cn.new Node(parent);
				 rootNode.left=cn.new Node(child);
				// node=rootNode;
			}else {
				Node node=getNode(rootNode,parent);
				addInNode(node,child,cn);
			}
		}
		System.out.println(countNodes(rootNode));
		
		scanner.close();
	}

	private static Node getNode(Node node, int val) {
		Node foundNode=null;
		while(foundNode==null) {
			if(node.value==val) {
				return node;
			}else {
				foundNode=getNode(node.left,val);
				if(foundNode==null) {
					foundNode=getNode(node.right,val);
				}
				
			}
		}
		return foundNode;
	}

	private static void addInNode(Node node, int child,CountingNodes cn) {
		if(node.left==null) {
			node.left=cn.new Node(child);
		}else {
			node.right=cn.new Node(child);
		}
	}

}
