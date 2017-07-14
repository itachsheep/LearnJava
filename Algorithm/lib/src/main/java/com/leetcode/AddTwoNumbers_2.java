package com.leetcode;

/**
 * Created by taowei on 2017/7/14.
 * 2017-07-14 09:12
 * Algorithm
 * com.leetcode
 */

public class AddTwoNumbers_2 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        printList(l1);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        printList(l2);

        ListNode res = addTwoNumbers(l1,l2);
        printList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //第一个节点
        ListNode head = new ListNode(0);
        ListNode tempNode = head;

        int carry = 0;
        while (l1 != null || l2 != null){
            int l1_val = (l1 != null) ? l1.val:0;
            int l2_val = (l2 != null) ? l2.val:0;

            int sum = l1_val + l2_val + carry;
            carry = sum / 10;

            tempNode.next = new ListNode(sum %10);
            tempNode = tempNode.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0){
            tempNode.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void printList(ListNode listNode){
        System.out.print("list : ");
        while (listNode != null){
            System.out.print(listNode.val+" -> ");
            listNode = listNode.next;
        }
        System.out.println();
    }


}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
