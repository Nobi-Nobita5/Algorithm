package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * @Author: Xionghx
 * @Date: 2022/07/05/14:51
 * @Version: 1.0
 * 思路：快慢指针
 */
public class LC_141_hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
