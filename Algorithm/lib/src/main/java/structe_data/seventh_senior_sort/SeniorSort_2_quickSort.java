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
