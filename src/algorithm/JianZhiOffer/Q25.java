package algorithm.JianZhiOffer;

import java.util.HashMap;
/*
深拷贝和浅拷贝的区别在于：
    浅拷贝只是增加了一个指针指向已存在的内存地址
    浅拷贝是增加了一个指针并且申请了一块新的内存，使得增加的指针指向这个新的内存。
 */
public class Q25 {
    /*
    思路是定义map，key存放原来节点的指针，value存放新创建的节点，
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode cur = pHead;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while (cur!=null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);//实现value每个节点的指针指向（深拷贝）
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
}
