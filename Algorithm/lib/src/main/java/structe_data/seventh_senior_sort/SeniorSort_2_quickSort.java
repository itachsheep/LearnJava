package structe_data.seventh_senior_sort;

import structe_data.Utils;

/**
 * Created by taow on 2017/7/21.
 */

public class SeniorSort_2_quickSort {
    public static void main(String[] args){
        int[] arr = {4,8,1,3,2,34,23};
        quickSort(arr,0,arr.length-1);
        Utils.printArr(arr);
    }

    /**
     * 在最好的情况下，每次我们进行一次分区，
     * 我们会把一个序列刚好分为几近相等的两个子序列，
     * 这个情况也我们每次递归调用的是时候也就刚好处理一半大小的子序列。
     * 这看起来其实就是一个完全二叉树，树的深度为 O(logn)，
     * 所以我们需要做 O(logn) 次嵌套调用。但是在同一层次结构的两个程序调用中，
     * 不会处理为原来数列的相同部分。
     * 因此，程序调用的每一层次结构总共全部需要 O(n) 的时间。
     * 所以这个算法在最好情况下的时间复杂度为 O(nlogn)。
     */
    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int pivot = arr[right];
        int partition = initPartition(arr,left,right,pivot);
        quickSort(arr,left,partition-1);
        quickSort(arr,partition+1,right);
    }

    private static int initPartition(int[] arr, int left, int right, int pivot) {
        int leftptr = left -1;
        int rightptr = right;
        while (leftptr < rightptr){
            while (arr[++leftptr] < arr[right]);
            while (arr[--rightptr] > arr[right]);
            if(leftptr >= rightptr)break;
            swap(arr,leftptr,rightptr);
        }
        swap(arr,leftptr,right);
        return leftptr;
    }

    private static void swap(int[]arr,int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }


//    private static void quickSort(int[] arr,int left,int right){
//        if(left >= right){
//            return;
//        }
//        int pivot = arr[right];
//        int partition = partitionIt(arr,left,right,pivot);
//        quickSort(arr,left,partition-1);
//        quickSort(arr,partition+1,right);
//    }
//
//    private static int partitionIt(int[] arr, int left, int right, int pivot) {
//        int leftPtr = left-1;
//        int rightPtr = right;
//        while (left < right){
//            while (arr[++leftPtr] < pivot);
//            while (arr[--rightPtr] > pivot);
//            if(leftPtr >= rightPtr) break;
//            swap(arr,leftPtr,rightPtr);
//        }
//        swap(arr,leftPtr,right);
//        return leftPtr;
//    }
//
//    private static void swap(int[] arr, int left, int right) {
//        int temp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = temp;
//    }
}
