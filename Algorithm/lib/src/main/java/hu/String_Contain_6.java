package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 14:56
 * Algorithm
 * hu
 */

public class String_Contain_6 {
    public static void main(String[] args){
        /**
         * 判断字符s1 是否包含s2中全部出现的字母
         */
        String str1 = "abcdej";
        String str2 = "cdeej";
        Utils.log(" -------- "+isContain(str1,str2));
    }



    private static boolean isContain(String s1,String s2){
        int hash = 0;
        for(int i = 0 ; i < s1.length(); i++){
            hash = hash | (1 << (s1.charAt(i) - 'a'));
        }

        for(int j = 0; j < s2.length(); j++){
            if( (hash & (1 << (s2.charAt(j) - 'a'))) == 0){
                return false;
            }
        }
        return true;
    }
}
