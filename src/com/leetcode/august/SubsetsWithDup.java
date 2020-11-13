package com.leetcode.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		permute(res, new ArrayList<>(), nums, 0);
		return res;
	}

	public void permute(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			tempList.add(nums[i]);
			permute(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		SubsetsWithDup thisClass = new SubsetsWithDup();
		int[] nums = { 1, 2, 2 };
		System.out.println(thisClass.subsetsWithDup(nums));
	}
}
