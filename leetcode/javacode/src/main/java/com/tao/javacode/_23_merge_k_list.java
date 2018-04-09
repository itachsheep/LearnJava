package com.tao.javacode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.
 Space complexity :O(n)O(n) Creating a new linked list costs O(n)O(n) space.
 * Created by SDT14324 on 2018/4/9.
 */

public class _23_merge_k_list {

    static class ListNode{
        int val;
        ListNode(int a){val = a;}
        ListNode next;
    }

    public static void main(String[] args){
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for (int i = 1; i < 11; i++){
            ListNode node = new ListNode(i);
            queue.add(node);
        }
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            System.out.print(poll.val+" -> ");
        }
        System.out.println();
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
