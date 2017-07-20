package structe_data;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by taow on 2017/7/20.
 */

public class Recursion_6_mergeSort {
    public static void main(String[] args){
        long ms = 100*1000;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        TimeZone china = TimeZone.getTimeZone("GMT+:08:00");
        formatter.setTimeZone(china);
        String res = formatter.format(ms);
        Utils.log("res: "+res);
       /* int[] arr = {23,47,81,95,7,14,39,55,62,74};
        mergeSort(arr,0,arr.length-1);
        Utils.printArr(arr);*/
    }

    private static void mergeSort(int[] arr, int low,int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid+1, k = 0;
        while (i <= mid && j <= high){
            if(arr[i] > arr[j]){
                temp[k++] = arr[j++];
            }else {
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= high){
            temp[k++] = arr[j++];
        }

        for(int x = 0; x< temp.length;x++){
            arr[x+low] = temp[x];
        }

    }
}
