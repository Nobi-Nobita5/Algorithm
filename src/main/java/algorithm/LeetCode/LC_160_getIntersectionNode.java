package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/07/05/14:41
 * @Version: 1.0
 * 思路：
 * 1、先用双指针同步起点
 * 2、再找相交的节点
 */
public class LC_160_getIntersectionNode {
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
