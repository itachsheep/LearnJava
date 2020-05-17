package com.leetcode腾讯精选面试题;

import com.Util;
import com.tao.comm.ListNode;

public class _1_两数通过链表相加 {
    public static void main(String[] args) {
        ListNode l1 = Util.createList(new int[]{2, 4, 3});
        ListNode l2 = Util.createList(new int[]{7,0,8});
        Util.printList(l1);
        Util.printList(l2);
        Util.printList(addTwoNums(l1,l2));
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head, p = l1, q = l2;
        int carry = 0, sum;
        while (p != null || q != null) {
            int x = (p == null ? 0 : p.val);
            int y = (q == null ? 0 : q.val);
            sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            if(p != null) {
                p = p.next;
            }

            if(q != null) {
                q = q.next;
            }

            cur = cur.next;
        }
        if(carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
