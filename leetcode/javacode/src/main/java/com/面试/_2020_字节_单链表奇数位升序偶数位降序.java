package com.面试;

import com.tao.comm.ListNode;
import com.tao.comm.Utils;

public class _2020_字节_单链表奇数位升序偶数位降序 {


    public static void main(String[] args) {
        ListNode head = Utils.createList(new int[]{1, 2, 3, 4, 5,6,7,8,9});
        Utils.printList(head);

    }




    /**
     * 先看下链表反转
     * @param head
     */
    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode newHead = reverse(p);
        p.next = head;
        return newHead;
    }
}
