package com;

import com.tao.comm.ListNode;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Util<T> {

    public void printHashSet(Set<T> integers) {
        Iterator<T> iterator = integers.iterator();
        System.out.println("the set is: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " -> ");
        }
        System.out.println();
    }

    public void printArrays(T[] arr){
        System.out.println("the arr is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void printArrayList(List<T> list){
        System.out.println("the list is: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public void printList(ListNode head){
        if(head == null)return;
        while (head != null){
            System.out.print(head.val +" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode createList(int[] num){
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
