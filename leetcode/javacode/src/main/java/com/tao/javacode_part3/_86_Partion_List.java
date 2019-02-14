package com.tao.javacode_part3;

import com.tao.comm.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 给定一个链表和一个值x，对其进行分区，使所有小于x的节点都排在大于或等于x的节点之前。
 * 您应该保持两个分区中每个节点的原始相对顺序。
 *
 */
public class _86_Partion_List {
    public static void main(String[] args){

    }
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        while (head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }
}
