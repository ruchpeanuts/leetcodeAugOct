package com.leetcode.august;

public class SmallestDivisor {

	public int smallestDivisor(int[] nums, int threshold) {
		int th_lo = 1;
		int th_hi = nums[nums.length - 1];
		while (th_lo <= th_hi) {
			int med = th_lo + (th_hi - th_lo) / 2;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				count += nums[i] % med == 0 ? nums[i] / med : nums[i] / med + 1;
			}
			if (count > threshold)
				th_lo = med + 1;
			else {
				th_hi = med - 1;
			}

		}
		return th_lo;

	}

	private int computeSum(int[] nums, int x) {
		int s = 0;
		for (int n : nums) {
			s += n / x + (n % x == 0 ? 0 : 1);
		}
		return s;
	}

	public static void main(String[] args) {
		SmallestDivisor thisClass = new SmallestDivisor();
		int[] nums = { 2, 3, 5, 7, 11 };
		System.out.println(thisClass.smallestDivisor(nums, 11));
	}

}
