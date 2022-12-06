package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/22/15:40
 * @Version: 1.0
 *
 */
/*
 * 归并排序基于分治算法。最容易想到的实现方式是自顶向下的递归实现，
 * 考虑到递归调用的栈空间，自顶向下归并排序的空间复杂度是 O(logn)
 */
public class LC_148_链表排序 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;//拆分成两个子链表（分）
        ListNode list1 = sortList(head, mid);//自顶向下递归
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);//（合）
        return sorted;
    }
    //合并两个有序链表
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;//三个指针：结果表尾指针、指向两个待合并链表指针
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;//指向较小节点的链表指针后移
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;//结果链表的尾指针后移
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
