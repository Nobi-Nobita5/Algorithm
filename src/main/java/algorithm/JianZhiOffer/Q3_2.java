package algorithm.JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;

public class Q3_2 {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null){
            Collections.reverse(list);
            return list;
        }
        list.add(listNode.val);
        listNode = listNode.next;
        return printListFromTailToHead(listNode);
    }
}
