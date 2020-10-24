package com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	private Map<Node, Node> map = new HashMap<>();
	private boolean flag = true;
	private Node cloneHead = null;

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node clone = getClone(head);
		if (flag) {
			cloneHead = clone;
			flag = false;
		}
		clone.random = getClone(head.random);
		if (null != head.next) {
			clone.next = getClone(head.next);
			clone = clone.next;
			head = copyRandomList(head.next);
		}

		return cloneHead;

	}

	private Node getClone(Node head) {
		if (head == null)
			return null;
		Node clone = map.get(head);
		if (clone == null) {
			clone = new Node(head.val);
			map.put(head, clone);
		}
		return clone;
	}

	public static void main(String[] args) {
		CopyRandomList thisClass = new CopyRandomList();
		Node node1 = thisClass.new Node(7);
		Node node2 = thisClass.new Node(13);
		Node node3 = thisClass.new Node(11);
		Node node4 = thisClass.new Node(10);
		Node node5 = thisClass.new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;
		Node n = thisClass.copyRandomList(node1);
		System.out.println(n);
	}

}

class Solution {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		// first pass, each node in the original list,
		// insert a copied node, between the node and node.next;
		Node cur = head;
		while (cur != null) {
			Node copy = new Node(cur.val);
			copy.next = cur.next;
			cur.next = copy;
			cur = cur.next.next;
		}

		// second pass, linked the random pointer for the copied node.
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				Node newCur = cur.next;
				Node newRandom = cur.random.next;
				newCur.random = newRandom;
			}
			cur = cur.next.next;
		}

		// third pass, extra the new node
		Node dummy = new Node(0);
		Node newHead = dummy;
		cur = head;
		while (cur != null) {
			newHead.next = cur.next;
			cur.next = cur.next.next;
			cur = cur.next;
			newHead = newHead.next;
		}

		return dummy.next;
	}
}

class SolutionTwo {

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (null == head)
			return null;
//		Node dummy = new Node(0);
//		dummy.next = head;
		Node c=head;
		// first pass
		while (head != null) {
			Node curr = new Node(head.val);
			curr.next = head.next;
			head.next = curr;
			head = head.next.next;
		}

		// second pass
		head = c;
		while (head != null) {
			if (head.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}

		// third pass
		head = c;
		Node cloneHead = head.next;
		Node clone = cloneHead;
		while (clone != null && clone.next != null) {

			c.next = c.next.next;
			c = c.next;

			clone.next = clone.next.next;
			clone = clone.next;

		}
		c.next = c.next.next;
		return cloneHead;
	}

	public static void main(String[] args) {
		SolutionTwo thisClass = new SolutionTwo();
		Node node1 = thisClass.new Node(7);
		Node node2 = thisClass.new Node(13);
		Node node3 = thisClass.new Node(11);
		Node node4 = thisClass.new Node(10);
		Node node5 = thisClass.new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;
		Node n = thisClass.copyRandomList(node1);
		System.out.println(n);
	}
}
