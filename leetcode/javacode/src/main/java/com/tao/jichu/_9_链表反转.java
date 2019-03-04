package com.tao.jichu;

import com.tao.comm.ListNode;

public class _9_链表反转 {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode newHead = reverse(p);
        p.next = head;
        return newHead;
    }
}
