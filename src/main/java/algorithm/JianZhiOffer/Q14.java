package algorithm.JianZhiOffer;

public class Q14 {
    /*
    注意：这个题不能先反转再找第k个节点，因为反转链表的话，找到之后返回的以该节点为头节点的链表就不一样了
     */

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        /*
        快慢指针,p2比p1快k个节点
         */
        if (pHead==null||k==0) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        for (int i = 0; i < k; i++) {
            if (p1==null) return null;
            p1 = p1.next;
        }
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
