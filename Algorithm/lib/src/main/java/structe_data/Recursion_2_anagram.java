package structe_data;

/**
 * Created by taowei on 2017/7/19.
 * 2017-07-19 23:45
 * Algorithm
 * structe_data
 */

public class Recursion_2_anagram {
    public static void main(String[] args){
        char[] arr = {'1','2','3','4'};
        permutation(arr,0,arr.length-1);
//        doAnagram(arr.length);
    }

    private static void doAnagram(int newSize) {
        if(newSize == 1)
            return;
        for (int j = 0 ; j < newSize ; j++){
            doAnagram(newSize - 1);

        }
    }

    private static void permutation(char[] buf,int start,int end){
        if(start == end){
            Utils.log(new String(buf));
            return;
        }

        for(int i = start; i <= end; i++){
            char temp = buf[start];//和第一个位置进行交换
            buf[start] = buf[i];
            buf[i] = temp;
            permutation(buf,start+1,end);//交换后，后续元素全排列

            temp = buf[start];//交换后还原
            buf[start] = buf[i];
            buf[i] = temp;
        }

    }
}
