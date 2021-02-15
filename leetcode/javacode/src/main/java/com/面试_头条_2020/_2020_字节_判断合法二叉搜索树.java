package com.面试_头条_2020;

import com.tao.comm.TreeNode;

import java.util.Stack;

public class _2020_字节_判断合法二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);//2.left
        root.left.right = new TreeNode(3);//2.right

        root.right.left = new TreeNode(5);//6.left
        root.right.right = new TreeNode(7);//6.right
        /**
         *              4
         *          2        6
         *        1   3    5    7
         */
        System.out.println("isValidBST : " + isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preRoot = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println("push -> " + root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(preRoot != null && root.val <= preRoot.val) {
                return false;
            }
            System.out.println("root: " + (root == null ? -1 : root.val)
                    + ", preRoot:" + (preRoot == null ? -1 : preRoot.val)
                     + ", root.right: " + (root.right == null ? -1: root.right.val));
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
