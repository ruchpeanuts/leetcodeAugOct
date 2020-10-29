package com.leetcode.august;

public class MaxDistToClosest {

	public int maxDistToClosest(int[] seats) {
		int ans = 0;
		int k = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				k = 0;
			} else {
				k++;
				ans = Math.max(ans, (k + 1) / 2);
			}
		}

		// left
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				ans = Math.max(ans, i);
				break;
			}
		}

		// right
		for (int i = seats.length - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				ans = Math.max(ans, seats.length - 1 - i);
				break;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		MaxDistToClosest thisClass = new MaxDistToClosest();
		int[] nums = { 1, 0, 0, 0, 1, 0, 1 };
		System.out.println(thisClass.maxDistToClosest(nums));
	}

}
