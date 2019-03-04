package com.tao.jichu;

import com.tao.comm.ListNode;
import com.tao.comm.Utils;

public class _9_链表反转 {

    public static void main(String[] args){
        ListNode head = Utils.createList(new int[]{1, 2, 3, 4, 5});
        Utils.printList(head);
        ListNode reverse = reverse(head);
        System.out.println("--------------------------");
        Utils.printList(reverse);
    }
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode newHead = reverse(p);
        p.next = head;
        return newHead;
    }
}
