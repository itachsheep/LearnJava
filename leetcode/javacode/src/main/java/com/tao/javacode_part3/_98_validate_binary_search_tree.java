package com.tao.javacode_part3;

import com.tao.comm.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class _98_validate_binary_search_tree {
    /**
     * 这道验证二叉搜索树有很多种解法，可以利用它本身的性质来做，
     * 即左<根<右，也可以通过利用中序遍历结果为有序数列来做，
     * 下面我们先来看最简单的一种，就是利用其本身性质来做，
     * 初始化时带入系统最大值和最小值，在递归过程中换成它们自己的节点值，
     * 用long代替int就是为了包括int的边界条件，代码如下
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean valid(TreeNode root,long low,long high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return valid(root.left,low,root.val) && valid(root.right,root.val,high);
    }
}
