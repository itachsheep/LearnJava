package com.tao.javacode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Created by SDT14324 on 2018/5/23.
 */

public class _57_insert_interval {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String[] args){

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i  = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(Math.min(newInterval.start,intervals.get(i).start)
            ,Math.max(newInterval.end,intervals.get(i).end));
            i++;
        }
        result.add(newInterval);
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }
}
