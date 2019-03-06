package com.tao.javacode;
/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 *
 *
 * Created by SDT14324 on 2018/4/4.
 */


public class _21_merge_two_list {
   static class ListNode{
        int value;
        ListNode(int a){value = a;}
        ListNode next;
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
            System.out.print(head.value +" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode l1 = createList(new int[]{1,2,4});
        ListNode l2 = createList(new int[]{1,3,4});

        printList(l1);
        printList(l2);

        ListNode merge = mergeTwoLists(l1,l2);
        printList(merge);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.value > l2.value){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
}
