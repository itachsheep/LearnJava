package com.tao.javacode_part2;


import com.tao.comm.ListNode;
import com.tao.comm.Utils;

public class _82_remove_duplicated_from_sorted_list_2 {
    public static void main(String[] args){
        ListNode listNode = Utils.createList(new int[]{1, 2, 3, 3, 4, 4, 5});
        Utils.printList(listNode);

        listNode = deleteDuplicates(listNode);
        Utils.printList(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode FakeHead = new ListNode(0);
        FakeHead.next = head;

        ListNode pre = FakeHead;
        ListNode cur = head;

        while (cur != null){
            //循环找到不重复元素为止
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            //修改指针指向，删除元素
            if(pre.next == cur){
                pre = pre.next;
            }else {
                pre.next = cur.next;
            }

            cur = cur.next;
        }
        return FakeHead.next;
    }
}
