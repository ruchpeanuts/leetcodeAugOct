package com.leetcode.august;

public class MinCostToMoveChips {

	public int minCostToMoveChips(int[] position) {
		if (position.length == 1)
			return 0;
		int count = 0;
		int odds = 0;
		int evens = 0;
		for (int i = 0; i < position.length; i++) {
			if (position[i] % 2 != 0) {
				odds++;
			} else
				evens++;
		}

		return Math.min(odds, evens);
	}

	public static void main(String[] args) {
		MinCostToMoveChips thisClass = new MinCostToMoveChips();
		int[] nums = { 1, 2, 3 };
		System.out.println(thisClass.minCostToMoveChips(nums));
	}

}
