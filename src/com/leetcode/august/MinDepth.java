package com.leetcode.august;

public class MinDepth {

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

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		MinDepth thisClass = new MinDepth();
		TreeNode root = thisClass.new TreeNode(3);
		TreeNode left1 = thisClass.new TreeNode(9);
		TreeNode right1 = thisClass.new TreeNode(20);
		root.left = left1;
		TreeNode left2 = thisClass.new TreeNode(15);
		TreeNode right2 = thisClass.new TreeNode(7);
		right1.left = left2;
		right1.right = right2;
		root.right = right1;
		System.out.println(thisClass.minDepth(root));
	}

}
