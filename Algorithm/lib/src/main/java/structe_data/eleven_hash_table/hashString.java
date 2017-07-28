package structe_data.eleven_hash_table;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/23.
 * 2017-07-23 14:17
 * Algorithm
 * structe_data.eleven_hash_table
 */

public class hashString {
    public static void main(String[] args){
        /**
         * 将单词哈希化，每个单词都有唯一对应的key
         * 如 cats 转化成一个数字
         * key = 3* 27^3 + 1 * 27^2+ 20*27^1 + 19*27^0
         * 主要是比较两种算法 hashFunc1 和 hashFunc2
         */
//        String s = "abc";
//        Utils.log("fun1 -------- "+hashFunc1(s,100));
//        Utils.log("fun2 -------- "+hashFunc2(s,100));

        String s = "http:\\/\\/172.16.88.1:80";
    }

    /**
     *第一种方式算法运算多，且有int溢出没有处理
     */
    private static int hashFunc1(String key,int size){
        int hashVal = 0;
        int pow27 = 1;
        for(int j = key.length() -1 ; j >= 0; j--){
            int letter = key.charAt(j) - 96;
            hashVal = hashVal + pow27*letter;
            pow27 = pow27 * 27;
        }
        return hashVal%size;
    }

    private static int hashFunc2(String key,int size){
        int hashVal = 0;
        for(int j = 0; j < key.length(); j++){
            int letter = key.charAt(j) - 96;
            hashVal = (hashVal * 27 +letter) % size;
        }
        return hashVal;
    }
}
