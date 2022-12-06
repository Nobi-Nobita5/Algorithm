package algorithm.JianZhiOffer;

public class Q36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;
        /*
        两个链表可能不一样长，遇到公共节点了后面的节点肯定就相同了；
        所以先让两个链表一样长（即先让以phead1和phead2之后的链表一样长）；
        这个过程就用快慢指针（与求链表的倒数第k个节点的思想相同）；

        之后同时遍历两个链表，找到相同的返回就可以了
         */
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1!=null&&p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1!=null){
            p1 = p1.next;
            pHead1 = pHead1.next;
        }
        while (p2!=null){
            p2 = p2.next;
            pHead2 = pHead2.next;
        }
        while (pHead1!=null&&pHead2!=null){
            if (pHead1==pHead2){
                return pHead1;
            }else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}
