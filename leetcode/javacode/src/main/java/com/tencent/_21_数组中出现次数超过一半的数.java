package com.tencent;

public class _21_数组中出现次数超过一半的数 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr2 = {1, 2, 3, 4,5,6,75,2,2,3,3,3,4,4};
        int[] arr3 = {1, 1,2, 3,1 ,1,1,1,1,1,1,1,1,1,1,1, 2, 1,1,2, 5,1,1,1, 4, 2};

        System.out.println(moreThanHalf(arr1));
        System.out.println(moreThanHalf(arr2));
        System.out.println(moreThanHalf(arr3));

    }

    /**
     *
     *我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。
     * 当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；
     * 如果下一个数字和我们之前保存的数字不同，则次数减1.如果次数为0，我们需要保存下一个数字，
     * 并把次数设置为1.由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
     * 那么要找的数字肯定是最后一次把次数设置为1时对应的数字。
     *
     * 原文链接：https://blog.csdn.net/u013132035/java/article/details/80662018
     *
     * @param arr
     * @return
     */
    public static int moreThanHalf(int[] arr) {
        if(arr == null || arr.length < 0) {
            return -1;
        }

        int result = arr[0];
        int times = 0;

        for (int i = 0; i < arr.length; i++) {
            if(times == 0) {
                result = arr[i];
                times = 1;
            } else if(result == arr[i]) {
                times++;
            } else {
                times--;
            }
        }

        if(times > 0) {
            return result;
        } else {
            return -1;
        }
    }
}
