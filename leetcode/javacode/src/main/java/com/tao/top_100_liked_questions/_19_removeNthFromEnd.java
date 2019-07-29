package com.tao.top_100_liked_questions;

import com.tao.comm.ListNode;
import com.tao.comm.Utils;

public class _19_removeNthFromEnd {
    public static void main(String[] args){

        ListNode list = Utils.createList(new int[]{1, 2, 3, 4, 5});
        Utils.printList(list);
        ListNode removeNthFromEnd = removeNthFromEnd(list, 2);
        Utils.printList(removeNthFromEnd);
    }

    public static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++){
            first = first.next;
        }
        System.out.println("first : " + first.val);

        while (first!= null) {
            first = first.next;
            second = second.next;
        }
        System.out.println("second : " + second.val);

        second.next = second.next.next;
        return dummy.next;
    }
}
