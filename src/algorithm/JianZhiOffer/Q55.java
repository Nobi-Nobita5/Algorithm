package algorithm.JianZhiOffer;

import java.util.HashSet;

/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Q55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashSet<ListNode> set = new HashSet<>();

        while (pHead.next!=null){
            if (set.contains(pHead)) return pHead;
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }
}
