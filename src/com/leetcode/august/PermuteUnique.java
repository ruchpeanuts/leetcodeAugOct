package com.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class PermuteUnique {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) {
			return res;
		}
		permute(nums, 0);
		return res;
	}

	public void permute(int[] nums, int k) {
		if (k == nums.length ) {
			List<Integer> sub = new ArrayList<Integer>();
			for (int i : nums) {
				sub.add(i);
			}
			res.add(sub);
			return;
		}
		for (int i = k; i < nums.length; i++) {
			if (i != k && !availableForPermute(nums, k, i))
				continue;
			swap(nums, k, i);
			permute(nums, k + 1);
			swap(nums, k, i);
		}
	}

	private boolean availableForPermute(int[] nums, int start, int chosen) {
		for (int i = start; i < chosen; i++) {
			if (nums[i] == nums[chosen]) {
				return false;
			}
		}
		return true;
	}

	private void swap(int[] nums, int s, int e) {
		int temp = nums[s];
		nums[s] = nums[e];
		nums[e] = temp;
	}

	public static void main(String[] args) {
		PermuteUnique thisClass = new PermuteUnique();
		int[] nums = { 1, 2, 3 };
		System.out.println(thisClass.permuteUnique(nums));
	}
}
