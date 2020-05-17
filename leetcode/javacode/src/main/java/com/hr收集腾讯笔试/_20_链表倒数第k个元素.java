package com.hr收集腾讯笔试;

import com.Util;
import com.tao.comm.ListNode;

public class _20_链表倒数第k个元素 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = Util.createList(arr);
        ListNode theLastKthNode = findTheLastKthNode(head, 3);
        System.out.println(theLastKthNode);

    }

    public static ListNode findTheLastKthNode(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        ListNode preNode = head;
        for (int i = 0 ; i < k; i++) {
            if(preNode.next != null) {
                preNode = preNode.next;
            } else {
                return null;
            }
        }

        ListNode targetNode = head;
        while (preNode.next != null) {
            preNode = preNode.next;
            targetNode = targetNode.next;
        }

        return targetNode;
    }
}
