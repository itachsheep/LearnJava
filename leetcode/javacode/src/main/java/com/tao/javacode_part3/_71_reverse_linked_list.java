package com.tao.javacode_part3;

import com.tao.comm.ListNode;

/**
 * 单链表的反转
 * 方法2：使用3个指针遍历单链表，逐个链接点进行反转。
 * 方法4:   递归(相信我们都熟悉的一点是，对于树的大部分问题，
 * 基本可以考虑用递归来解决。但是我们不太熟悉的一点是，对于单链表的一些问题，
 * 也可以使用递归。可以认为单链表是一颗永远只有左(右)子树的树，因此可以考虑用递归来解决。
 * 或者说，因为单链表本身的结构也有自相似的特点，所以可以考虑用递归来解决)
 */
public class _71_reverse_linked_list {

    /**
     * 使用p和q两个指针配合工作，使得两个节点间的指向反向，同时用r记录剩下的链表
     */
    public ListNode revers_linked_list_fun2(ListNode head){
        if(null == head || null == head.next)return head;
        ListNode p = head, q = head.next, r;
        head.next = null;
        while (q != null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
    }

    /**
     * 方法4:  递归
     *
     * updated: 2014-01-24
     *
     * 因为发现大部分问题都可以从递归角度想想，所以这道题目也从递归角度想了想。
     *
     * 现在需要把A->B->C->D进行反转，
     * 可以先假设B->C->D已经反转好，已经成为了D->C->B,那么接下来要做的事情就是将D->C->B看成一个整体，
     * 让这个整体的next指向A，所以问题转化了反转B->C->D。那么，
     * 可以先假设C->D已经反转好，已经成为了D->C,那么接下来要做的事情就是将D->C看成一个整体，
     * 让这个整体的next指向B，所以问题转化了反转C->D。那么，
     * 可以先假设D(其实是D->NULL)已经反转好，已经成为了D(其实是head->D),
     * 那么接下来要做的事情就是将D(其实是head->D)看成一个整体，让这个整体的next指向C，所以问题转化了反转D。
     * 上面这个过程就是递归的过程，这其中最麻烦的问题是，如果保留新链表的head指针呢？想到了两个办法。
     */
    public ListNode revers_Linked_list_fun3(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode newTail = revers_Linked_list_fun3(head.next);
        newTail.next = head;
        head.next = null;
        return head;
    }
}
