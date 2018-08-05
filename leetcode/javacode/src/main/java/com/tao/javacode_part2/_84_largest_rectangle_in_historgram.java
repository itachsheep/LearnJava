package com.tao.javacode_part2;


import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */

public class _84_largest_rectangle_in_historgram {
    public static void main(String[] args){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len) ? 0 : heights[i];
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else {
                int tp = s.pop();
                maxArea = Math.max(maxArea,heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
