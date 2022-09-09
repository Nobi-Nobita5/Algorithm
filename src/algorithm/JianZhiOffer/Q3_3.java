package algorithm.JianZhiOffer;

import java.util.ArrayList;

public class Q3_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode pre = null;
        ListNode p = null;
        while (listNode!=null){
            p = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = p;
        }
        while (pre!=null){//pre是头节点
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
}
