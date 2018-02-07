package com.tao.javacode;

/**
 * Created by SDT14324 on 2018/2/7.
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class _2_add_two_numbers {
    static class ListNode{
        ListNode(){}
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
        int val;
        ListNode next;
    }

    public static void main(String[] args){
        ListNode l1 = createList(342);
        ListNode l2 = createList(465);
        printList(l1);
        printList(l2);

        ListNode l3 = addTwoNumbers(l1,l2);
        System.out.print("the result is: ");
        printList(l3);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = l1, q = l2, curr = head;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

    private static ListNode createList(int target) {
        ListNode head = new ListNode();
        ListNode node = head;
        while (target > 0){
//            int temp = ;
            node.next = new ListNode(target % 10);
            node = node.next;
            target = target / 10;
        }
        return head.next;
    }

    private static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
