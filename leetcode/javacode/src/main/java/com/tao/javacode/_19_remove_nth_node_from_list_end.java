package com.tao.javacode;

import java.util.Random;

/**
 *
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Created by SDT14324 on 2018/3/29.
 */

public class _19_remove_nth_node_from_list_end {
    public static void main(String[] args){
        ListNode head = new ListNode(100);
        ListNode first = head;
        Random random = new Random();

        for(int i = 0 ; i < 10; i++){
            int a = random.nextInt(100);
            ListNode node = new ListNode(a);
            head.next = node;
            head = node;
        }
        printList(first);
        first = removeNthFromEnd(first,4);
        printList(first);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 1; i <= n+1; i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    private static void printList(ListNode head){
        while (head != null){
            System.out.print(head.n + " -> ");
            head = head.next;
        }
        System.out.println();
    }
    static class ListNode{
        int n;
        ListNode next;
        public ListNode(int m){
            n = m;
        }
    }
}
