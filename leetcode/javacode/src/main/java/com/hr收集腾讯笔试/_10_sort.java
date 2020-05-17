package com.hr收集腾讯笔试;

import com.Util;

public class _10_sort {
    public static void main(String[] args) {
        int[] arr1 = {9, 23, 4, 32, 3, 1, 54, 7, 76, 34, 78, 89, 6, 45};
        int[] arr2 = {34, 45, 667, 23, 4, 56, 67, 8, 89, 6, 45};
        int[] arr3 = {10, 9, 8, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        /*bubleSort(arr1);
        bubleSort(arr2);
        bubleSort(arr3);*/

        /*selectSort(arr1);
        selectSort(arr2);
        selectSort(arr3);*/

        /*System.out.println("-------- insert sort -------");
        insertSort(arr1);
        insertSort(arr2);
        insertSort(arr3);*/

        System.out.println("-------- quick sort ---------");
        quickSort(arr1,0,arr1.length-1);
        quickSort(arr2,0,arr2.length-1);
        quickSort(arr3,0,arr3.length-1);
        Util.printArrays(arr1);
        Util.printArrays(arr2);
        Util.printArrays(arr3);


    }


    /**
     * 两两比较，较大放在后面
     * 第一轮将最大放到最后面
     * 最坏的情况，交换和比较需的次数，n(n-1),运行时间O(n^2)
     */
    public static void bubleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
    }

    /**
     * 第一趟，将最小的放到最前面 比较次数 i= 0， n - 0
     * 第二趟，将第二小的放在第二个位置，i= 1，比较次数 n - 1;
     *
     * 选择排序改进了冒泡排序，将必要的交换次数从O(N^2)减少到O(N)
     * 但是比较次数仍为O(n^2)
     */
    public static void selectSort(int[] arr) {
        int min, swap;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            if(min != i) {
                swap = arr[i];
                arr[i] = arr[min];
                arr[min] = swap;
            }
        }
    }

    /**
     * 插入排序第一趟最多比较一次，第二趟最多比较二次，
     * 最终最多次数 1+2+3.....+N-1 = N*(N-1)/2
     * 实际平均值 ： N*(N-1)/4
     * 移动复制次数大致等于比较次数，但是移动速度快于交换位置
     * 比冒泡快一倍，略快于选择排序
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pos = i;
            int element = arr[i];
            while (pos > 0 && arr[pos - 1] > element) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = element;
        }
    }


    /**
     *将关键字较大的记录从前面直接移动到后面，关键字较小的记录从后面直接移动到前面，
     * 从而减少了总的比较次数和移动次数。同时采用“分而治之”的思想，
     * 把大的拆分为小的，小的拆分为更小的，其原理如下：
     * 对于给定的一组记录，选择一个基准元素,通常选择第一个元素或者最后一个元素,
     * 通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,
     * 一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,
     * 然后再用同样的方法递归地排序划分的两部分，直到序列中的所有记录均有序为止。
     *
     * 最好情况是指每次区间划分的结果都是基准关键字的左右两边长度相等或者相差为1，
     * 即选择的基准关键字为待排序的记录的中间值。此时进行比较次数总共为 nlogn，
     * 时间复杂度O(nlogn) 平均复杂度 O(nlogn)
     *
     *在最坏的情况下，待排序的序列为正序或者逆序，
     * 每次划分只得到一个比上一次划分少一个记录的子序列，
     * 注意另一个为空。如果递归树画出来，它就是一棵斜树。此时需要执行n‐1次递归调用，
     * 且第i次划分需要经过n‐i次关键字的比较才能找到第i个记录，也就是枢轴的位置，
     * 因此其时间复杂度为O(n2)
     */
    public static void quickSort(int[] arr,int left,int right) {
        if(left >= right) {
            return;
        }
        int partition = partition(arr,left,right);
        quickSort(arr,left,partition - 1);
        quickSort(arr,partition + 1,right);
    }

    public static int partition(int[] arr,int left,int right) {
        int pivot = right;
        while (left < right) {
            while (arr[left] <= arr[pivot] && left < right) {
                left++;
            }

            while (arr[right] >= arr[pivot] && left < right){
                right--;
            }
            swap(arr,left,right);
        }

        swap(arr,left,pivot);
        return left;
    }

    public static void swap(int[] arr,int left,int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
