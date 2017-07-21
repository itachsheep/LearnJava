package structe_data;

/**
 * Created by taow on 2017/7/21.
 */

public class SeniorSort_1_shellSort {
    public static void main(String[] args){
        int[] arr = {4,8,1,3,2,34,23};
        selectSort(arr);
        Utils.printArr(arr);
    }
    private static void selectSort(int[] arr){
        int n = arr.length;
        int h = n/2;
        while (h > 0){
            for(int out = h; out < n; out++){
                //从arr[h]开始，h+1,h+2,.......arr[n]
                int temp = arr[out];
                int in = out;
                while (in > h-1 && arr[in - h] > temp){
                    //然后，对序列 in-h,in-2h,in-3h...这样的间隔序列排列，每次移动间隔为h
                    arr[in] = arr[in-h];
                    in = in -h;
                }
                arr[in] = temp;
            }
            //缩小移动间隔h
            h = h/2;
        }
    }
}
