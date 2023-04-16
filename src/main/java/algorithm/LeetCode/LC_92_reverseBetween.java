package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/29/20:35
 * @Version: 1.0
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * ------------------------
 * 思路：
 * 1.定位到给定区间的前一个节点和后一个节点
 * 2.切断该区间，调用206题的反转链表方法，反转该区间
 * 3.最后再接回到原来的链表中
 * -------------------------
 * 时间复杂度：O(N),N是链表长度，最坏情况下需要遍历整个链表
 * 空间复杂度：O(1)
 */
public class LC_92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;//pre指向区间的末尾节点
        leftNode.next = curr;//区间开头节点指向curr
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode p = null;
        ListNode pre = null;
        //一个循环反转一个指针
        while (head!=null){
            p = head.next;
            head.next = pre;//反转一个指针
            pre = head;//pre指针移动到head，不会影响上一步head.next指向的位置，即指针移动与物理位置无关
            head = p;
        }
    }
}
