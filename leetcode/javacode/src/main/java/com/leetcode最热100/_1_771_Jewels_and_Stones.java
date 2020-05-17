package com.leetcode最热100;

import java.util.HashSet;

public class _1_771_Jewels_and_Stones {
    /**
     * 我们用HashSet来优化时间复杂度，将珠宝字符串J中的所有字符都放入HashSet中，
     * 然后遍历石头字符串中的每个字符，到HashSet中查找是否存在，
     * 存在的话计数器自增1即可，
     */
    public static int numJewelsInStones(String J, String S) {
        int res = 0;
        HashSet set = new HashSet();
        for (char j:J.toCharArray()) {
            set.add(j);
        }
        for (char s:S.toCharArray()){
            if(set.contains(s)){
                res++;
            }
        }
        return res;
    }
}
