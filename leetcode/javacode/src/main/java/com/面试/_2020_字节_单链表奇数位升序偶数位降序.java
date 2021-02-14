package com.面试;

import com.Util;
import com.tao.comm.ListNode;
import com.tao.comm.Utils;

public class _2020_字节_单链表奇数位升序偶数位降序 {


    /**
     * 这道题可以分成三步：
     *
     * 首先根据奇数位和偶数位拆分成两个链表。
     *
     * 然后对偶数链表进行反转。
     *
     * 最后将两个有序链表进行合并。
     * https://www.cnblogs.com/DarrenChan/p/8764608.html
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = Utils.createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Utils.printList(head);
        ListNode reverse = reverse(head);
        Util.printList(reverse);
    }


    /**
     * 先看下链表反转
     *
     * @param head
     */
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;//p = 2
        head.next = null;//1.next = null
        ListNode newHead = reverse(p);
        System.out.println("reverse newhead: ");
        Util.printList(newHead);
        p.next = head;//2.next = 1;
        return newHead;
    }
}
