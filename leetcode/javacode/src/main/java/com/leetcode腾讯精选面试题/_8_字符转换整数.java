package com.leetcode腾讯精选面试题;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _8_字符转换整数 {
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483647"));
    }


    /**
     * 这题的做法大概是这样：
     *
     * 去掉前导空格
     * 再是处理正负号
     * 识别数字，注意越界情况。
     * 这道题目如果只是简单地字符串转整数的话，就是简单地 ans = ans * 10 + digit。
     * 但是注意这道题目可能会超过integer的最大表示！
     * 也就是说会在某一步 ans * 10 + digit > Integer.MAX_VALUE。
     * *10 和 +digit 都有可能越界，那么只要把这些都移到右边去就可以了。
     * ans > (Integer.MAX_VALUE - digit) / 10 就是越界。
     *
     * 不过我的忠告是，等真正工作以后，尽可能地调用jdk的方法，比如Character.isDigit。如果没有你想要的api，也要尽量使用guava，apache common等常见的utils包，尽量不要自己造轮子，一是这样减少出错的可能，二是比较无脑，保护脑细胞~
     *
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int index = 0;
        while (index < n && chars[index] == ' ') index++;
        if(index == n) return 0;

        boolean negative = false;
        if(chars[index] == '-') {
            negative = true;
        } else if(chars[index] == '+') {
            negative = false;
        } else if(!Character.isDigit(chars[index])) {
            return 0;
        }

        int ans = 0;
        while (index < n) {
            int digit = chars[index] - '0';
            if(ans > (Integer.MAX_VALUE - digit)/10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
            // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。

            ans = ans * 10 + digit;
            index++;
        }
        return ans;
    }
}
