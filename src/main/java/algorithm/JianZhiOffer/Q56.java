package algorithm.JianZhiOffer;
/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

解：定义两个相邻指针，判断p2.val是否等于p2.next.val：
   1.相等则p2后移至与当前值不相等的位置 p1.next = p2
   2.不相等则同时后移
 */
public class Q56 {
    //重复节点不保留
    //返回值是dummy.next
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode p1 = dummy;
        ListNode p2 = pHead;
        while (p2 != null) {

            while (p2.next!=null&&p2.val==p2.next.val){//遇到p2.val等于p2.next.val的就一直后移
                p2 = p2.next;
            }
            p2 =p2.next; //此处还要后移一位才能移至与当前值不相等的位置

            /*
            这里写一个判断是否遇到了重复的元素，进行两种不同的操作（p1.next = p2还是同时后移）
             */

            if (p1.next.next == p2){//此处判断如果p1.next.next == p2，则说明没有进行上面的while循环，即没有重复元素
                p1 = p1.next;
            }else p1.next = p2;//若有重复元素则p1.next = p2
        }
        return dummy.next;
    }
}
