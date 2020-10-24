package com.leetcode.august;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public int minMeetingRoomsii(Interval[] intrs) {
		if (intrs == null || intrs.length == 0)
			return 0;
		if (intrs.length == 1)
			return 1;
		Arrays.sort(intrs, (o1, o2) -> o1.start - o2.start);
		PriorityQueue<Interval> queue = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
		for (int i = 0; i < intrs.length - 1; i++) {
			Interval tmp = queue.poll();
			if (tmp == null || tmp.end > intrs[i].start) {
				queue.offer(intrs[i]);
				if (tmp == null)
					continue;
			} else {
				tmp.end = intrs[i].end;
			}
			queue.offer(tmp);
		}
		return queue.size();

	}

	public static void main(String[] args) {
		MinMeetingRooms thisClass = new MinMeetingRooms();
		Interval i1 = thisClass.new Interval(1, 3);
		Interval i2 = thisClass.new Interval(4, 5);
		Interval i3 = thisClass.new Interval(5, 7);
		Interval i4 = thisClass.new Interval(9, 11);
		Interval i5 = thisClass.new Interval(2, 8);
		Interval i6 = thisClass.new Interval(6, 10);
		Interval[] i = { i1, i2, i3, i4, i5, i6 };
		System.out.println(thisClass.minMeetingRoomsii(i));
	}

}
