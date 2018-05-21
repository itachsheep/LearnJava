package com.tao.javacode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 * Created by SDT14324 on 2018/5/21.
 */

public class _56_merge_intervals {
    public class Interval {
       int start;
       int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    private class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 :a.start == b.start ? 0:1;
        }
    }
    public static void main(String[] args){

    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval:intervals) {
            if(merged.isEmpty() || merged.getLast().end < interval.start){
                merged.add(interval);
            }else {
                merged.getLast().end = Math.max(merged.getLast().end,interval.end);
            }
        }
        return merged;
    }
}
