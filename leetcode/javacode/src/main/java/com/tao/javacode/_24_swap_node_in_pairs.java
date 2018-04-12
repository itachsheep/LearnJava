package com.tao.javacode;

/**
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 * Created by SDT14324 on 2018/4/12.
 */

public class _24_swap_node_in_pairs {

    static class ListNode{
        int val;
        ListNode(int a){val = a;}
        ListNode next;
    }
    public static void main(String[] args){
        ListNode n1 = createList(new int[]{1,2,3,4});
        printList(n1);
        ListNode sn = swapPairs(n1);
        printList(sn);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(n.next);
        n.next = head;
        return n;
    }

    private static ListNode createList(int[] num){
        ListNode head = null, tail;
        if(num == null || num.length <=0 ) return null;
        if(num != null && num.length >= 1) {
            head = new ListNode(num[0]);
        }
        tail = head;
        for(int i = 1; i < num.length; i++){
            ListNode node = new ListNode(num[i]);
            tail.next = node;
            tail = node;
        }
        return head;
    }

    private static void printList(ListNode head){
        if(head == null)return;
        while (head != null){
            System.out.print(head.val +" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
