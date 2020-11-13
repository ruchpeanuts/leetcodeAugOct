package com.leetcode.august;

public class MaxAncestorDiff {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int maxAncestorDiff(TreeNode root) {

		return a(root, root.val, root.val);
	}

	private int a(TreeNode node, int max, int min) {
		if (node == null)
			return Math.abs(max - min);
		max = Math.max(max, node.val);
		min = Math.min(min, node.val);
		return Math.max(a(node.left, max, min), a(node.right, max, min));
	}

	public static void main(String[] args) {
		MaxAncestorDiff thisClass = new MaxAncestorDiff();
		TreeNode root = thisClass.new TreeNode(1);
		TreeNode left1 = thisClass.new TreeNode(2);
		TreeNode right1 = thisClass.new TreeNode(0);
		TreeNode left2 = thisClass.new TreeNode(3);
		root.right = left1;
		left1.right = right1;
		right1.left = left2;
//		root.right = right1;
		System.out.println(thisClass.maxAncestorDiff(root));
	}

}
