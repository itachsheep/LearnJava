package com.hr收集腾讯笔试;

import com.Util;
import com.tao.comm.ListNode;

public class _4_linked_list_reversal {
    public static void main(String[] args) {
       Util<Integer> util = new Util<Integer>();
       int[] num = {1,2,3,4,5,6,7,8,9};
        ListNode head = util.createList(num);
        util.printList(head);
        ListNode reverse = reverseList(head);
        util.printList(reverse);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode preListNode = null;
        ListNode curListNode = head;
        while (curListNode != null) {
            ListNode nextListNode = curListNode.next;
            curListNode.next = preListNode;
            preListNode = curListNode;
            curListNode = nextListNode;
        }
        return preListNode;
    }
}
