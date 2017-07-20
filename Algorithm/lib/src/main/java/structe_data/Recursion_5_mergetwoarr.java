package structe_data;

/**
 * Created by taow on 2017/7/20.
 */

public class Recursion_5_mergetwoarr {
    public static void main(String[] args){
        int[] arr1 = {23,47,81,95};
        int[] arr2 = {7,14,39,55,62,74};
        merge(arr1,arr2);
    }

    private static void merge(int[] arr1,int[] arr2){
        int n1 = arr1.length, n2 = arr2.length, n3 = n1+n2;
        int[] mer = new int[n3];
        int i =0,j = 0,k = 0;
        while(i < n1 && j < n2){
            if(arr1[i] > arr2[j]){
                mer[k++] = arr2[j++];
            }else {
                mer[k++] = arr1[i++];
            }
        }
        while (i < n1){
            mer[k++] = arr1[i++];
        }
        while (j < n2){
            mer[k++] = arr2[i++];
        }
        Utils.printArr(mer);
    }
}
