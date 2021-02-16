/**
 * @ClassName:
 * @Description:
 * @author taowei
 * @version V1.0
 * @Date
 */

package com.网络头条高频题;

import com.Util;
import com.tao.comm.ListNode;

import java.awt.HeadlessException;
import java.util.List;

public class _2_25_K个一组翻转链表 {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     *  
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     *  
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = Util.createList(new int[]{1, 2, 3, 4, 5});
        Util.printList(head);
        ListNode reverse = reverse(head);
        Util.printList(reverse);


    }

    /**
     * 1，我们需要把链表节点按照 k 个一组分组，所以可以使用一个指针 head 依次指向每组的头节点。
     * 这个指针每次向前移动 k 步，直至链表结尾。对于每个分组，我们先判断它的长度是否大于等于 k。
     * 若是，我们就翻转这部分链表，否则不需要翻转。
     *
     * 2，接下来的问题就是如何翻转一个分组内的子链表。翻转一个链表并不难，
     * 但是对于一个子链表，除了翻转其本身之外，
     * 还需要将子链表的头部与上一个子链表连接，以及子链表的尾部与下一个子链表连接。
     * 在翻转子链表的时候，我们不仅需要子链表头节点 head，还需要有 head 的上一个节点 pre，
     * 以便翻转完后把子链表再接回 pre。
     *
     * 3，
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head,int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        //循环中使用 pre tail head 三个变量,next 用于标识下个k分组的头
        // hair 用于返回
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++)  {
                tail = tail.next;
                if(tail == null) {
                    return hair.next;
                }
            }

            ListNode next = tail.next;
            //ListNode reverse = myReverse(head,tail);

        }

        return null;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail,head};
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode temp = reverse(p);
        p.next = head;
        return temp;
    }
}
