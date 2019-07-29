package com.tao.interview;

import com.tao.comm.TreeNode;

import java.util.LinkedList;
import java.util.Map;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class microsoft_recover_binary_search_tree {

    /**
     * 题意：二叉搜索树中，有两个结点的位置被交换了，请找出这两个结点并交换回来。
     *
     * 直观的想法可能是中序遍历一遍二叉树，得到一个有序的二叉树，然后找出其中逆序的地方，
     * 交换回来就好了。但这样空间复杂度就是O(n)，题目要求O(1)。
     *
     * 我们来分析下有哪些情况：1) 被交换的两个结点相邻，如124356，
     * 这样只需要把相邻的3和4交换回来即可；2) 被交换的两个结点不相邻，如163452，
     * 这样我们需要找出两个逆序的地方，63和52，并交换第一个逆序的前者和第二个逆序的后者。
     *
     * 我们如何做到一次DFS即可找出两个结点呢，并且空间为O(1)，
     * 用p和q两个指针存放要交换的两个结点是必要的，
     * 还需要一个pre指针在DFS过程中标记当前结点的前一个结点，以判断前后是否为逆序关系。
     *
     * 当第一次找到逆序时，如43，把p=3，q=4，如果后面没有发现第二个逆序，
     * 那么最后交换p和q即可。如果有两个逆序，如63和52，当我们发现第一个逆序63时，
     * 把p=6，q=3，然后发现第二个逆序52时，把q=2，最后交换p和q。
     */
    TreeNode p, q,pre;
    public void revoerTree(TreeNode root){
        pre = p = q = null;
        dfs(root);
        int tmp = p.val;
        p.val = q.val;
        q.val = tmp;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre != null && pre.val > root.val){
            if(p == null){
                p = pre;
                q = root;
            }else {
                q = root;
            }
        }
        pre = root;
        dfs(root.right);
    }


    public static void main(String[] args){

    }
}
