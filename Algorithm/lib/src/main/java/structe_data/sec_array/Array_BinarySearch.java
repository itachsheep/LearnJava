package structe_data.sec_array;


/**
 * Created by taowei on 2017/7/15.
 * 2017-07-15 14:58
 * Algorithm
 * structe_data
 */

public class Array_BinarySearch {
    public static void main(String[] args){
        int[] arr = new int[20];
//        Random random = new Random();
        for(int i = 0; i < 20 ; i++){
            arr[i] = (2+ i*5);
        }

        printArr(arr);
//        System.out.println("find ---------- 32 "+binarySearch(arr,0,19,32));
//        System.out.println("find ---------- 67 "+binarySearch(arr,0,19,67));
//        System.out.println("find ---------- 97 "+binarySearch(arr,0,19,97));

        System.out.println("find ---------- 32 "+find(arr,32));
        System.out.println("find ---------- 67 "+find(arr,67));
        System.out.println("find ---------- 97 "+find(arr,97));
    }

    public static void printArr(int[] arr) {
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    public static int find(int[] num, int value){
        int low = 0;
        int high = num.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high)/2;
            if(num[mid] == value){
                System.out.println("find ok return mid: " + mid);
                return mid;
            }else if(num[mid] > value){
                //value在右半边
                high = mid - 1;
            }else {
                //value 在左半边
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] num,int low, int high, int value){
        int mid = (low + high) / 2;
//        System.out.println("binarySearch low: "+num[low]+", high: "+num[high]+", mid: "+num[mid]);
        if (value == num[mid]) {
//            System.out.println("binarySearch find ok return mid: " + mid);
            return mid;
        } else if (value < num[mid]) {
            high = mid - 1;
            if (high < low) return -1;
            return binarySearch(num, low, high, value);
        } else {
            low = mid + 1;
            if (high < low) return -1;
            return binarySearch(num, low, high, value);
        }
    }
}
