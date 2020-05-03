package com.tencent;

import com.Util;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 10亿个数查重复
 */
public class _2_billion_count_query_repeats {
    public static void main(String[] args) {
        int[] arr = {7,4,1,2,3,5,6,8,3,5};
        Set<Integer> integers = bigNumberOfDataQuery(arr);
        new Util<Integer>().printHashSet(integers);
    }

    /**
     *
     * @param arr 理论上10亿个数字 应该从文件里面读取
     * @return
     */
    public static Set<Integer> bigNumberOfDataQuery(int[] arr) {
        Set<Integer> output = new HashSet<>();
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        int i = 0;
        while (i < arr.length) {
            int value = arr[i];
            if(bitSet.get(value)) {
                output.add(value);
            } else {
                bitSet.set(value,true);
            }
            i++;
        }

        return output;
    }

}
