package com.tencent;

import com.Util;
import com.tao.comm.TreeNode;

public class _6_height_of_binary_tree {
    public static void main(String[] args) {
        Util<TreeNode> util = new Util<>();
        TreeNode root = new TreeNode(5);
        for(int i = 1; i <= 10; i++) {
            if(i == 5) continue;
            util.insertTreeNode(i,root);
        }

        System.out.println(heightOfTree(root));
    }

    public static int heightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftTreeHeight = heightOfTree(root.left);
        int rightTreeHeight = heightOfTree(root.right);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
