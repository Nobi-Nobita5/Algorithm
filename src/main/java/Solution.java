import algorithm.ListNode;

import java.util.*;
/*
*
* */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode tail = null;
        return sortList(head,tail);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null){
            return head;
        }
        if (head == tail){
            head.next = null;
            return head;
        }
        //使用快慢指针找到中间节点，用于分治。
        ListNode slow = head,fast = head;
        while (fast!=tail){//fast ～ tail 为当前处理的链表
            slow = slow.next;
            fast = fast.next;
            if (fast!=tail) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return mergeTwoLists(list1,list2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode phead = new ListNode(0);//new一个节点，作为结果链表头节点的前置节点
        ListNode temp = phead;//作为结果链表的尾节点
        while (list1!=null && list2!=null){
            if (list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1!=null){//不能使用while
            temp.next = list1;
        }else if (list2!=null){
            temp.next = list2;
        }
        return phead.next;
    }
}
