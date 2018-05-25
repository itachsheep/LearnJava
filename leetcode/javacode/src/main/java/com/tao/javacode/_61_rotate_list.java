package com.tao.javacode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
 * Created by SDT14324 on 2018/5/25.
 */

public class _61_rotate_list {
    public static class ListNode {
      int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
    public static void main(String[] args){
        ListNode list = createList(new int[]{1, 2, 3, 4, 5});
        printList(list);
        ListNode rotate = rotateRight(list, 2);
        printList(rotate);
    }

    /**
     * Since n may be a large number compared to the length of list.
     * So we need to know the length of linked list.After that,
     * move the list after the (l-n%l )th node to the front to finish the rotation.

     Ex: {1,2,3} k=2 Move the list after the 1st node to the front

     Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.

     So the code has three parts.

     Get the length

     Move to the (l-n%l)th node

     3)Do the rotation
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null) return  head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        //Get the length
        int i = 0;
        for (i = 0; fast.next != null ; i++){
            fast = fast.next;
        }

        //Move to the (length - n % length) th node
        for (int j = i - n % i; j > 0; j--){
            slow = slow.next;
        }

        //Do the rotation
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public static void printList(ListNode node){
        if(null == node) return;
        while (node != null){
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println();
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
}
