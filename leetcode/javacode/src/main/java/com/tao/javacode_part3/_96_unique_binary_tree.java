package com.tao.javacode_part3;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class _96_unique_binary_tree {
    /**
     * 这道题实际上是 Catalan Number卡塔兰数的一个例子，
     * 我们先来看当 n = 1的情况，只能形成唯一的一棵二叉搜索树，
     * n分别为1,2,3的情况如下所示：
     *                                          n = 1
     *                      1                                 n = 2
     *                /          \
     *            2
     *         3     3      2      1           n = 3
     *     \       /     /      / \      \
     *     2     1      1   3      2
     *     /     /       \                 \
     *     1         2                 3
     *
     * 就跟斐波那契数列一样，我们把n = 0 时赋为1，因为空树也算一种二叉搜索树，
     * 那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，
     * 所以1乘1还是1。那么n = 2时，由于1和2都可以为跟，分别算出来，
     * 再把它们加起来即可。n = 2的情况可由下面式子算出：
     *
     * dp[2] =  dp[0] * dp[1]　　　(1为根的情况)
     *
     * 　　　　+ dp[1] * dp[0]　　  (2为根的情况)
     *
     * 同理可写出 n = 3 的计算方法：
     *
     * dp[3] =  dp[0] * dp[2]　　　(1为根的情况)
     *
     * 　　　　+ dp[1] * dp[1]　　  (2为根的情况)
     *
     *  　　　  + dp[2] * dp[0]　　  (3为根的情况)
     *
     * 由此可以得出卡塔兰数列的递推式为：
     *
     * C_0 = 1 \quad \mbox{and} \quad C_{n+1}=\sum_{i=0}^{n}C_i\,C_{n-i}\quad\mbox{for }n\ge 0.
     *
     * 我们根据以上的分析，可以写出代码如下：
     */
    public int numTrees(int n) {
     int[] dp = new int[n+1];
     dp[0] = 1;
     dp[1] = 1;
     for (int i = 2 ; i < n ; i++){
         for (int j = 0; j < i ; ++j){
             dp[i] += dp[j] * dp[i - j - 1];
         }
     }
     return dp[n];
    }
}
