package com.面试;

import com.tao.comm.TreeNode;

import java.util.Stack;

public class _2020_字节_判断合法二叉搜索树 {
    public static void main(String[] args) {
        System.out.println("111");
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preRoot = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(preRoot != null && root.val <= preRoot.val) {
                return false;
            }
            preRoot = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    /**
     * 先看下递归中序遍历实现
     */
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 再看下非递归中序遍历实现
     */
    public void inOrderNoRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;

        }
        System.out.println();
    }
}
