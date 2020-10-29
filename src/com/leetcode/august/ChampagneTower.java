package com.leetcode.august;

public class ChampagneTower {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] A = new double[1 + query_row][1 + query_row];
		A[0][0] = poured;
		for (int i = 0; i < query_row; i++) {
			for (int j = 0; j <= i; j++) {
				if (A[i][j] > 1) {
					A[i + 1][j] += (A[i][j] - 1) / 2;
					A[i + 1][j + 1] += (A[i][j] - 1) / 2;
					A[i][j] = 1;
				}
			}
		}
		return Math.min(1, A[query_row][query_glass]);
		// explained solution
		/*
		 * A[0][0] = (double) poured; for (int r = 0; r <= query_row; ++r) { for (int c
		 * = 0; c <= r; ++c) { double q = (A[r][c] - 1.0) / 2.0; if (q > 0) { A[r +
		 * 1][c] += q; A[r + 1][c + 1] += q; } } }
		 */

//		return Math.min(1, A[query_row][query_glass]);

		// wrong solution my solution

		/*
		 * poured *= 2; for (int i = 1;; i++) { if (poured < (i * i) + i) { int filled =
		 * i - 1; int rem = poured - (filled * filled + filled); rem /= 2; if (rem == 0)
		 * { if (query_row + 1 <= filled) { return 1; } else { return 0; } } double p =
		 * filled / rem; if (query_glass == 0 || query_glass == query_row) return p / 2;
		 * return p; } }
		 */
	}

	public static void main(String[] args) {
		ChampagneTower thisClass = new ChampagneTower();
		System.out.println(thisClass.champagneTower(24, 8, 1));

	}

}
