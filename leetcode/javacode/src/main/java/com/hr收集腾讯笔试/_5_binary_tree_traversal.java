package com.hr收集腾讯笔试;

import com.Util;
import com.tao.comm.TreeNode;

public class _5_binary_tree_traversal {
    public static void main(String[] args) {
        Util<TreeNode> util = new Util<>();
        TreeNode root = new TreeNode(5);
        for(int i = 1; i <= 10; i++) {
            if(i == 5) continue;
            util.insertTreeNode(i,root);
        }

        System.out.println("the preOrder is: ");
        preOrder(root);
        System.out.println();

        System.out.println("the inOrder is: ");
        inOrder(root);
        System.out.println();

        System.out.println("the postOrder is: ");
        postOrder(root);
        System.out.println();
    }

    public static void preOrder(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " -> ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.val + " -> ");
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " -> ");
        }
    }
}
