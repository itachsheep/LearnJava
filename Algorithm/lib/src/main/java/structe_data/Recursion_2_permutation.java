package structe_data;

/**
 * Created by taowei on 2017/7/19.
 * 2017-07-19 23:45
 * Algorithm
 * structe_data
 */

public class Recursion_2_permutation {
    public static void main(String[] args){
        char[] arr = {'1','2','1','3'};
        /**
         1. 所有元素的全排列: ab的全排列是ab, ba(顺序相关);
         2. 所有元素的全组合: ab的全组合是a, b, ab(顺序无关);
         3. 求n个元素中选取m个元素的组合方式有哪些: abc中选2个元素的组合是ab, ac, bc;
         4. 求n个元素中选取m个元素的排列方式有哪些: abc中选2个元素的排列是ab, ba, ac, ca, bc, cb;
         */
        permutation(arr,0,arr.length-1);

    }


    /** 数组中从索引 start 到索引end之间的子数组参与到全排列 */
    private static void permutation(char[] buf,int start,int end){
        if(start == end){//只剩最后一个字符时为出口
            Utils.log(new String(buf));
            return;
        }
        for(int i = start; i <= end; i++){//每个字符依次固定到数组或子数组的第一个
            if(canSwap(buf,start,i)){//如果有重复的，说明已经放置到过第一个位置，不需要放置两次
                swap(buf,start,i);//和第一个位置进行交换
                permutation(buf,start+1,end);//交换后，后续元素全排列
                swap(buf,start,i);//交换后还原
            }
        }
    }

    private static boolean canSwap(char[] buf,int begin,int end){
        for(int i = begin; i < end; i++){
            if(buf[i] == buf[end]){
                return false;
            }
        }
        return true;
    }
    private static void swap(char[] buf,int from,int to){
        char temp = buf[from];
        buf[from] = buf[to];
        buf[to] = temp;
    }
}
