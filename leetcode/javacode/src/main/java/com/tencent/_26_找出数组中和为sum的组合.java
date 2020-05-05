package com.tencent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _26_找出数组中和为sum的组合 {
    public static void main(String[] args) {
        int[] arr1 = {2,6,1,7,4,9};
        int target1 = 20;
        int sum1 = 0;
        Arrays.sort(arr1);
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        findSum(arr1,target1,sum1,temp,result);
        printResut(result);
    }

    /**
     *https://blog.csdn.net/andycpp/article/details/1796669
     *
     * 在n个数字中，找出所有和为SUM的组合
     *
     * //递归函数，每一次的动作很简单，
     * //在已经找到的n个元素的基础上，寻找第n+1个元素，
     * @param arr
     * @param target
     * @param sum
     * @param temp
     * @param result
     */
    public static void findSum(int[] arr, int target, int sum,
        List<Integer> temp,List<String> result) {
        int begin = temp.size() == 0 ? 0 :  temp.get(temp.size() - 1) +1;
        for (int i = begin; i < arr.length; i++) {
            sum += arr[i];
            if(sum < target) {
                temp.add(i);
                findSum(arr,target,sum,temp,result);
                sum -= arr[i];
                temp.remove(temp.size() - 1);
            } else if(sum == target) {
                StringBuilder sb = new StringBuilder();
                for (Integer e:temp) {
                    sb.append(arr[e] + " ");
                }
                sb.append(arr[i]);
                result.add(sb.toString());
                break;
            } else {
                break;
            }
        }
    }

    private static void printResut(ArrayList<String> result) {
        for (String res:result) {
            System.out.println(res);
        }
    }
}
