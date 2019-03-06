package com.tao.jichu;

import com.tao.comm.ListNode;

public class _10_链表合并 {
    public ListNode mergeList(ListNode ln1,ListNode ln2){
        if(ln1 == null) return ln2;
        if(ln2 == null) return ln1;
        if(ln1.val > ln2.val){
            ln2.next = mergeList(ln1,ln2.next);
            return ln2;
        }else {
            ln1.next = mergeList(ln1.next,ln2);
            return ln1;
        }
    }
}
