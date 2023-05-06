package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/22/15:40
 * @Version: 1.0
 *
 */
/*
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 * ----------------------------------------------
 * 思路：
 * 基于分治算法的归并排序。(最容易想到的实现方式是自顶向下的递归实现)
 *
 * 1.使用快慢指针，定位到mid将当前链表一分为二，再递归调用sortList和merge实现分治后归并。
 * 2.定义头尾指针，当两指针相遇时，断开节点，这样可以利用分治断开链表中所有节点。
 * ------------------------------------------
 * 时间复杂度：归并排序，O(NlogN),N是链表长度。
 * 空间复杂度：考虑到递归调用的栈空间，自顶向下归并排序的空间复杂度是 O(logN)
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
            head.next = null;//分治到两指针相遇，断开节点，因为合并时使用的merge方法的入参是两个链表
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
        ListNode mid = slow;//（分）
        ListNode list1 = sortList(head, mid);//自顶向下递归
        ListNode list2 = sortList(mid, tail);//不能写成sortList(mid + 1,tail)，因为mid～mid+1之间的指针也要考虑在分治过程之中。
        ListNode sorted = merge(list1, list2);//（合）
        return sorted;
    }
    //合并两个有序链表
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);//new一个节点，作为结果链表头节点的前置节点
        ListNode temp = dummyHead;//temp指针指向结果链表的尾节点
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;//指向较小节点的链表指针后移
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;//结果链表的尾指针后移
        }
        if (head1 != null) {
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }
        return dummyHead.next;
    }
}
