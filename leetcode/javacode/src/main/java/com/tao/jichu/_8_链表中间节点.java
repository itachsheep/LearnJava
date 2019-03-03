package com.tao.jichu;

import com.tao.comm.ListNode;

public class _8_链表中间节点 {
    /**
     * 寻找链表的中间节点的方法，就是用两个指针一快一慢，一个走两步，
     * 一个走一步，快指针先走到底了，这时候慢指针就指向中间节点。
     */
    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
