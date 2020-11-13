package com.leetcode.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		permute(res, new ArrayList<>(), nums, target, 0);
		return res;
	}

	public void permute(List<List<Integer>> list, List<Integer> tempList, int[] nums, int target, int start) {

		if (target == 0) {
			list.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (target - nums[i] < 0 || (i > start && nums[i] == nums[i - 1]))
				continue;
			tempList.add(nums[i]);
			System.out.println(tempList+ ".."+nums[i]+" added");
			permute(list, tempList, nums, target - nums[i], i + 1);
			System.out.println(tempList+ ".."+tempList.get(tempList.size()-1)+" removing");
			tempList.remove(tempList.size() - 1);
			
		}
	}

	public static void main(String[] args) {
		CombinationSum2 thisClass = new CombinationSum2();
		int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(thisClass.combinationSum2(nums, 10));
	}
}
