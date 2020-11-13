package com.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		permute(res, new ArrayList<>(), nums, target, 0);
		return res;
	}

	public void permute(List<List<Integer>> list, List<Integer> tempList, int[] nums, int target, int start) {

		if (target == 0) {
			list.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (target - nums[i] < 0)
				continue;
			tempList.add(nums[i]);
			permute(list, tempList, nums, target - nums[i], i);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum thisClass = new CombinationSum();
		int[] nums = { 2, 3, 5 };
		System.out.println(thisClass.combinationSum(nums, 8));
	}
}
