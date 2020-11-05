package com.leetcode.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindMinHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) return Collections.singletonList(0);
		ArrayList<Set<Integer>> neighbors = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			neighbors.add(new HashSet<>());
		}

		for (int[] edge : edges) {
			neighbors.get(edge[0]).add(edge[1]);
			neighbors.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (neighbors.get(i).size() == 1)
				leaves.add(i);
		}

		while (n > 2) {
			n = n - leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				int j = neighbors.get(i).iterator().next();
				neighbors.get(j).remove(i);
				if (neighbors.get(j).size() == 1)
					newLeaves.add(j);
			}
			leaves = newLeaves;
		}

		return leaves;

	}

	public static void main(String[] args) {
		FindMinHeightTrees linkedList = new FindMinHeightTrees();
		int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
		System.out.println(linkedList.findMinHeightTrees(6, edges));
	}
}
