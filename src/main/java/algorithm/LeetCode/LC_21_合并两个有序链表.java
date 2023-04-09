package algorithm.LeetCode;

import algorithm.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * -----------------
 * 定义两个指针：
 * 1. new一个节点，作为结果链表头节点的前置节点
 * 2. 结果链表的尾节点
 * */
public class LC_21_合并两个有序链表 {
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
