package com.tao.javacode;

/**
 * Created by SDT14324 on 2018/4/13.
 */

public class _25_reverse_node_in_k_group {
    static class ListNode{
        int val;
        ListNode(int a){val = a;}
        ListNode next;
    }
    public static void main(String[] args){
        ListNode n1 = createList(new int[]{1,2,3,4,5});
//        printList(n1);
        ListNode sn = reverseKGroup(n1,3);
//        printList(sn);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }

        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
//            if(curr != null) System.out.println("curr = "+curr.val);
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
//            if(head != null) System.out.println("head = "+head.val);
            System.out.print("curr : ");
            printList(curr);
            System.out.print("head : ");
            printList(head);
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
                System.out.println("count = "+count);
                printList(curr);
                printList(head);
            }
            head = curr;
        }
        return head;
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
