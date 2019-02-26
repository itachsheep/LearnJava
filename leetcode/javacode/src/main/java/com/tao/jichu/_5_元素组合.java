package com.tao.jichu;

import com.tao.comm.Utils;

public class _5_元素组合 {

    /**
     * 所有元素的全组合: ab的全组合是a, b, ab(顺序无关);
     *  n个元素选m个元素的组合问题的实现. （m = n 时候，就是全组合）原理如下:
     *  从后往前选取, 选定位置i后, 再在前i-1个里面选取m-1个.
     *  如: 1, 2, 3, 4, 5 中选取3个元素.
     *     1) 选取5后, 再在前4个里面选取2个, 而前4个里面选取2个又是一个子问题, 递归即可;
     *     2) 如果不包含5, 直接选定4, 那么再在前3个里面选取2个, 而前三个里面选取2个又是一个子问题, 递归即可;
     *     3) 如果也不包含4, 直接选取3, 那么再在前2个里面选取2个, 刚好只有两个.
     *      纵向看, 1与2与3刚好是一个for循环, 初值为5, 终值为m.
     *      横向看, 该问题为一个前i-1个中选m-1的递归.
     */
    public void combination(char[] arr){
        char[] buf = new char[arr.length];
        for (int i = 0; i < buf.length; i++){
            int m = i+1;
            combinat_sub_nums(arr,arr.length,m,buf,m);
        }
    }
    public void combinat_sub_nums(char[] arr,int length,int mElements,char[] buf
    ,int lenElements){
        if(mElements == 0){//出口，所有元素都选好了
            printArr(buf,0,lenElements);
        }else {
            for (int i = length; i >= mElements; --i){
                buf[mElements - 1] = arr[i-1];
                combinat_sub_nums(arr,i-1,mElements-1,buf,lenElements);
            }
        }
    }

    public void printArr(char[] buff,int start,int end){
        for (int i = 0;i<buff.length;i++){
            if(i >= start && i <= end){
                System.out.print(buff[i]+" ");
            }
        }
        System.out.println();
    }

}
