package structe_data;

/**
 * Created by taowei on 2017/7/20.
 * 2017-07-20 23:08
 * Algorithm
 * structe_data
 */

public class Recursion_7_knapsack {
    public static void main(String[] args){
        int[] arr = {11,8,7,6,5};

        int total = 20;
        find(arr,0,arr.length-1,total);
    }
    private static void find(int[] arr,int start,int end,int total){

        for(int i = start; i < end; i++){
            int temp = arr[start];
            //System.out.println("-------"+total);
            if(temp == total){
                System.out.println("--- "+temp);
            }
            find(arr,start+1,end,total - temp);
        }

    }

    /*private static void knapsack(int[] arr,int start,int end,int total,
                               int[] cont,int num){
        if(start == end){
            cont = new int[arr.length];
        }
        for(int i = start; i<= end;i++){
            int temp = arr[start];
            cont[num++] = temp;
            if(temp == total){
                return;
            }
            knapsack(arr,start+1,end,total-temp,cont,num);
        }
    }
*/

}
