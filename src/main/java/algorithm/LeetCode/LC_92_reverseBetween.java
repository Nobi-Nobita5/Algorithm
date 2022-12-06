package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/29/20:35
 * @Version: 1.0
 */
public class LC_92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);//dummy.next永远指向新链表的第一个节点
        dummy.next = head;
        ListNode first = dummy;
        for (int i = 1; i < left; i++) {
            first = first.next;//找到第一段的最后一个节点
        }
        ListNode second = first.next;//操作前第二段的第一个节点
        if (second ==null) return dummy.next;

        ListNode l = second;
        ListNode r = l.next;

        for (int i = left; i < right; i++) {
            ListNode temp = r.next;
            r.next = l;
            l = r;
            r = temp;
        }

        first.next = l;
        second.next =r;
        return dummy.next;
    }
}
