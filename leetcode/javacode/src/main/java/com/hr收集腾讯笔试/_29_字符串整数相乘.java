package com.hr收集腾讯笔试;

public class _29_字符串整数相乘 {
    public static void main(String[] args) {
        System.out.println(mutiplyString("11","22"));
        System.out.println(mutiplyString("11","99"));
        System.out.println(mutiplyString("99","99"));
    }

    public static String mutiplyString(String num1,String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m -1; i >= 0; i--) {
            for (int j = n -1; j >=0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                /**
                 * 注意： pos[i+j+1] 代表结果中的低位，i+j 代表高位
                 * 在数组中也是如此
                 */
                int sum = multi + pos[i + j +1];
                pos[i+j] += sum / 10;
                pos[i+j+1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a:pos) {
            if(a==0 && sb.length() == 0) {
                continue;
            }
            sb.append(a);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
