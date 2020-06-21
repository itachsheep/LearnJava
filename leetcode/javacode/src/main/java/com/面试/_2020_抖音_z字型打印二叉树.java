package com.面试;

import com.tao.comm.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

class _2020_抖音_z字型打印二叉树 {
    public static void main(String[] args) {

    }

    /**
     *
     *  * 请实现一个函数按照之字形打印二叉树，
     *  * 即第一行按照从左到右的顺序打印，
     *  * 第二层按照从右至左的顺序打印，
     *  * 第三行按照从左到右的顺序打印，其他行以此类推
     * https://blog.csdn.net/zhou15755387780/article/details/79228616
     * @param root
     */
    public static void printTree(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int index = 1;
        stack.push(root);

        while (!stack.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (index % 2 == 1 && !stack.isEmpty()) {
                TreeNode node = stack.pop();
                if(node != null) {
                    temp.add(node.val);
                    stack2.push(node.left);
                    stack2.push(node.right);
                }
            }

            while (index % 2 == 0 && !stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                temp.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }

            index++;
            arrayList.addAll(temp);
        }
    }
}
