package hu;

import java.util.ArrayList;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 11:03
 * Algorithm
 * hu
 */

public class Joseph_ring_4 {
    public static void main(String[] args){
        /**
         * n个人围成一个圆圈，编号为1~n，从第一号开始报数，报到m的倍数的人离开，
         * 一直数下去，直到最后只有一个人， 求此人编号
         */
        joseph(10,1,3);

    }

    public static void joseph(int n,int startNo,int m){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        //从下标为 k的人开始计数
        int k = startNo-1;
        while (list.size() > 0){
            //报到 m的人下标
            k = k+m ;
            k =  k % (list.size()) -1;
            if(k < 0){//到队尾了
                Utils.log("remove ----- "+list.get(list.size()-1));
                list.remove(list.size()-1);
                k = 0;
            }else {
                Utils.log("*** remove ----- "+list.get(k));
                list.remove(k);
            }
        }

    }
}
