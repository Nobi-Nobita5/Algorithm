package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/23/18:01
 * @Version: 1.0
 * 反转链表
 */
public class LC_206_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode pre = null;
        //一个循环反转一个指针
        while (head!=null){
            p = head.next;
            head.next = pre;//反转一个指针
            pre = head;//pre指针移动到head，不会影响上一步head.next指向的位置，即指针移动与物理位置无关
            head = p;
        }
        return pre;//返回反转后的头节点
    }
}
