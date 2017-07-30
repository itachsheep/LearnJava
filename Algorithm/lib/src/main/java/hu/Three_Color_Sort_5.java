package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 14:43
 * Algorithm
 * hu
 */

public class Three_Color_Sort_5 {
    public static void main(String[] args){
        /**
         * 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，
         * 请通过两两交换任意两个球，使得从左至右，依次是一些红球、一些白球、一些蓝球
         */
        int[] arr = {2,0,2,0,0,2,1,1,0,2,1,0,1,2,0,1,2,0,1,0,2,1,0,2,0,1,2,0,1,2,0,2,1,0};
        threeColorSort(arr);
        Utils.printArr(arr);
    }

    public static void threeColorSort(int[] arr){
        int begin = 0,current = 0,end = arr.length -1;
        while (current <= end){
            if(arr[current] == 0){
                //红球放在左边
                swap(arr,begin,current);
                begin++;
                current++;
            }else if(arr[current] == 1){
                //白球放中间
                current++;
            }else {
                //蓝球放在右边
                swap(arr,current,end);
                end--;
            }
        }
    }

    private static void swap(int[] arr, int begin, int current) {
        int temp = arr[begin];
        arr[begin] = arr[current];
        arr[current] = temp;

    }
}
