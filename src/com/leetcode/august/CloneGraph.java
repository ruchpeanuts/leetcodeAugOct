package com.leetcode.august;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	Map<Node, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);
		Node n = new Node(node.val);
		map.put(node, n);
		for (Node neighbor : node.neighbors) {
			n.neighbors.add(cloneGraph(neighbor));
		}
		return n;
	}

	public static void main(String[] args) {
		CloneGraph thisClass = new CloneGraph();
		Node node1 = thisClass.new Node(1);
		Node node2 = thisClass.new Node(2);
		Node node3 = thisClass.new Node(3);
		Node node4 = thisClass.new Node(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		for (Node n : node1.neighbors) {
			System.out.println(n.val + "  " + n);
		}
		Node clone = thisClass.cloneGraph(node1);
		for (Node n : clone.neighbors) {
			System.out.println(n.val + "  " + n);
		}

	}

}
