package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/07/05/14:41
 * @Version: 1.0
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * ------------------------------------------------------------
 * 思路：
 * 1、先用双指针同步起点
 * 2、再找相交的节点
 * ---------------------------------------
 * 时间复杂度：O(M+N),M和N分别是两个链表的长度
 * 空间复杂度：O(1)
 */
public class LC_160_链表相交起始节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=null&&p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1!=null){
            headA = headA.next;
            p1 = p1.next;
        }
        while (p2!=null){
            headB = headB.next;
            p2 = p2.next;
        }
        //现在起点一致了
        while (headA!=null&&headB!=null){
            if (headA==headB) return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            };
        }
        return null;
    }
}
