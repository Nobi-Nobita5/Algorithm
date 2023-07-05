package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2023/07/04/22:09
 * @Version: 1.0
 */

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LC_19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd_方法一_双指针(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = head;
        //先确定两个指针之间的距离
        for(int i = 1;i < n;i++){
            fast = fast.next;
        }
        //然后同时向链表尾部移动，最后慢指针所在位置就是要删除的元素
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        //本题慢指针从dummyHead出发，所以slow.next才是要删除的元素
        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public ListNode removeNthFromEnd_方法二_计算链表长度(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode p = head;
        int length = 0;

        while(p!=null){
            p = p.next;
            length += 1;
        }

        ListNode p1 = dummyHead;

        for(int i = 1 ; i < length - n + 1; i ++){
            p1 = p1.next;
        }

        p1.next = p1.next.next;

        return dummyHead.next;
    }
}
