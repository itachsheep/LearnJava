package com.hr收集腾讯笔试;

import java.util.Arrays;
import java.util.List;

public class _37_36进制加法 {
    public static void main(String[] args) {
        String s1 = "23413";
        String s2 = "23232";
        System.out.println(customHexAdd(s1,s2));
    }

    /**
     * https://www.jianshu.com/p/a98caf83e67b
     *
     * 36进制由0-9，a-z，共36个字符表示，最小为'0'
     * '0''9'对应十进制的09，'a''z'对应十进制的1035
     * 例如：'1b' 换算成10进制等于 1 * 36^1 + 11 * 36^0 = 36 + 11 = 47
     * 要求按照加法规则计算出任意两个36进制正整数的和
     * 如：按照加法规则，计算'1b' + '2x' = '48'
     *
     *要求：不允许把36进制数字整体转为10进制数字，计算出10进制数字的相加结果再转回为36进制
     *
     *
     * 1,将'0'-'9'映射到数字0-9，将'a'-'z'映射到数字10-35的方法
     * 将'0'-'9'，'a'-'z'存储到List中，index是0-35为其对应的数字
     *
     * 2,
     */
    static Character[] nums = { '0','1','2','3','4','5','6','7','8','9'
            ,'a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z' };
    static List<Character> list = Arrays.asList(nums);
    private static String customHexAdd(String s1,String s2) {

        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        int i = char1.length - 1;
        int j = char2.length -1;
        int temp = 0, sum = 0;
        char c1, c2;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            c1 = char1[i--];
            c2 = char2[j--];
            sum = list.indexOf(c1) + list.indexOf(c2) + temp;
            temp = sum >= 36 ? 1 : 0;
            sb.append(list.get(sum % 36));
        }

        while (i >=0) {
            sum = list.indexOf(char1[i--]) + temp;
            temp = sum >= 36 ? 1 : 0;
            sb.append(list.get(sum % 36));
        }

        while (j >= 0) {
            sum = list.indexOf(char2[j--]) + temp;
            temp = sum >= 36 ? 1 : 0;
            sb.append(list.get(sum % 36));
        }

        if(temp > 0) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}

