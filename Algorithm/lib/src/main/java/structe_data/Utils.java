package structe_data;

/**
 * Created by taowei on 2017/7/15.
 * 2017-07-15 17:15
 * Algorithm
 * structe_data
 */

public class Utils {
    public static void printArr(int[] arr) {
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    public static void printArr(char[] buf,int begin,int end) {
        for(int i = 0 ; i <= end; i++){
            System.out.print(buf[i]+", ");
        }
        System.out.println();
    }

    public static void log(String mes){
        System.out.println(mes);
    }
}
