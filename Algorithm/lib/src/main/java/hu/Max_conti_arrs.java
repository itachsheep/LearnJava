package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 17:16
 * Algorithm
 * hu
 */

public class Max_conti_arrs {
    public static void main(String[] args){
        /**
         * 输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。 求所有子数组的和的最大值，要求时间复杂度为O(n)。

         例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2， 因此输出为该子数组的和18。
         */
        int[] a = { 1, -5, 4, 6, -3, 9 };
        Utils.log("a ------------------------- "+max_conti_arr(a));
    }

    private static int max_conti_arr(int[] arrs){
        /**
         * 事实上，当我们令currSum为当前最大子数组的和，maxSum为最后要返回的最大子数组的和，当我们往后扫描时，

         对第j+1个元素有两种选择：要么放入前面找到的子数组，要么做为新子数组的第一个元素；
         如果currSum加上当前元素a[j]后不小于a[j]，则令currSum加上a[j]，否则currSum重新赋值，置为下一个元素，即currSum = a[j]。
         同时，当currSum > maxSum，则更新maxSum = currSum，否则保持原值，不更新。
         即
         */
        int curSum = arrs[0], max = curSum;
        for(int i = 1; i < arrs.length; i++){
            curSum =  curSum+arrs[i] > arrs[i] ? curSum + arrs[i] : arrs[i] ;
            max = Math.max(curSum,max);
            Utils.log("curSum ---- "+curSum+", max: "+max);
        }
        return max;
    }
}
