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

public class _链表反转 {
    public static void main(String[] args) {
        ListNode head = Util.createList(new int[]{1, 2, 3, 4, 5});
        Util.printList(head);
        ListNode reverse = reverseNoRecursion(head);
        Util.printList(reverse);

    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode temp = reverse(p);
        p.next = head;
        return temp;
    }

    /**
     * 非递归
     *
     *   假设链表为1→2→3→∅，我们想要把它改成 ∅←1←2←3。
     *
     * 在遍历链表时，将当前节点的 \textit{next}next 指针改为指向前一个节点。
     * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，
     * 还需要存储后一个节点。最后返回新的头引用。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public static ListNode reverseNoRecursion(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
