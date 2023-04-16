package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/07/04/14:14
 * @Version: 1.0
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * ----------------------------------------------
 * 思路：
 * 1.第一个节点指针指向下下个节点，第二个节点指针指向下下个节点，两个指针向后移动一位，以此类推；
 * 2.断开最后奇偶节点的交界
 * 3.奇数段链接偶数段，奇数段最后节点上的指针，可能是p1(偶数个节点),p2(奇数个节点)。要判断节点个数奇偶性
 *
 * 时间复杂度：O(n) 
 * 空间复杂度：O(1) 
 */

public class LC_328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next;
        ListNode p4 = head;
        int count = 1;
        while (p4.next != null){
            p4 = p4.next;
            count++;//记录节点个数，用于最后判断个数奇偶性
        }
        while (p2!=null && p2.next!=null){
            p1.next = p2.next;
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = null;//断开最后奇偶节点的交界，否则会出现环
        if (count % 2==0) p1.next = p3;//奇数段链接偶数段
        else p2.next = p3;

        return head;
    }
}
