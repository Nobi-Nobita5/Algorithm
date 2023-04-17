import algorithm.ListNode;

import java.util.*;
/*
*
* */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode p1 =head;
        ListNode p2 =head.next;
        ListNode p3 =head.next;
        ListNode p4 =head;
        int count = 1;

        while (p4.next!=null){
            p4 = p4.next;
            count += 1;
        }

        while (p2!=null && p2.next!=null){
            p1.next = p2.next;
            p1 = p2;
            p2 = p2.next;
        }

        p1.next = null;

        if (count%2 == 0) p2.next = p3;
        else p1.next = p3;

        return head;
    }
}
