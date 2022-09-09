package algorithm.JianZhiOffer;

import java.util.ArrayList;

public class Q3_1 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (listNode!=null){
            temp.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = temp.size()-1; i >=0 ; i--) {
            list.add(temp.get(temp.size()-1));
        }
        return list;
         //Collections.reverse(temp);
        //return temp;
    }
}
