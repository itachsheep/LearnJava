package com.leetcode腾讯精选面试题;

public class _7_整数反转 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        int x1 = -123;
        int x2 = 34982384;
        int x3 = -934233223;
        int x4 = 729999999;
        int x5 = 2147483647;
        System.out.println(x1 + " revers ---> " + reverse(x1));
        System.out.println(x2 + " revers ---> " + reverse(x2));
        System.out.println(x3 + " revers ---> " + reverse(x3));
        System.out.println(x4 + " revers ---> " + reverse(x4));
        System.out.println(x5 + " revers ---> " + reverse(x5));

    }

    /**
     *   2147483647
     *  -2147483648
     *
     * 反转整数的方法可以与反转字符串进行类比。
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 \text{rev}rev 的后面。最后，\text{rev}rev 将与 xx 相反。
     *
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     *
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            if(rev > Integer.MAX_VALUE / 10 ||
                    rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10) {
                return 0;
            }

            if(rev < Integer.MIN_VALUE / 10 ||
                    rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
