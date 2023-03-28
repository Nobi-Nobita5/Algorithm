package algorithm.LeetCode;

import algorithm.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * -------------------------
 * 思路：
 * 用一个小根堆维护当前每个链表没有被合并的元素的最前面一个，k个链表就最多有 k个满足这样条件的元素，
 * 每次在这些元素里面选取val属性最小的元素合并到堆中。
 *
 */

public class LC_23_合并K个升序链表 {
    class  Status implements Comparable<Status>{
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr){//自定义节点构造方法，方便创建独立的节点
            this.val = val;
            this.ptr = ptr;
        }

        /**
<<<<<<< HEAD
         * Comparable接口可以用于实现自定义类的排序规则（通过重写compareTo方法）。
         * Comparator接口可以在类外部定义排序规则（通过重写compare方法）。
         * ----------------------------------------------------
=======
>>>>>>> 9698dc7 (力扣提交)
         * 在重写方法compareTo()的是时候，会传对象，我们这里称其为比较对象，当前类为当前对象，如下：
         * 当前对象=比较对象，返回0；当前对象＞比较对象，返回1；当前对象＜比较对象，返回-1；这样是升序排序的。
         * 当前对象=比较对象，返回0；当前对象＞比较对象，返回-1；当前对象＜比较对象，返回1；这样是降序排序的
         *
<<<<<<< HEAD
         * 这里的Comparable.compareTo()方法中的参数是 【来比较的元素】，
         * 【return this.val - status2.val】 等同于 【待比较元素 - 来比较的元素(o1 - o2)】，
         *  即 【待比较元素 > 来比较的元素(o1 > o2)】返回正数，是升序。
=======
         * 这里的compareTo默认等同于 o1 - o2，即o1 > o2返回正数，是升序
>>>>>>> 9698dc7 (力扣提交)
         * @param status2
         * @return
         */
        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;//等同于o1 - o2，升序->小根堆
        }
    }
    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode node: lists){//维护每个链表head节点到小根堆中
            if (node!=null){
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);//新建链表
        ListNode tail = head;
        while (!queue.isEmpty()){
            Status f = queue.poll();
            tail.next = f.ptr;//最小的节点连接在新建的链表之后,并弹出队列
            tail = tail.next;
            if (f.ptr.next!=null){
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));//该最小节点所在队列之后的节点维护进队列(小根堆)
            }
        }
        return head.next;
    }

}


/**
 * 上面自定义一个Status类的做法，再将Status.val用于优先级队列的排序规则，实际上多此一举了。
 * 因为ListNode类中就有val变量，可以直接用它排序。
 * */
class LC_23_合并K个升序链表_简洁答案{
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    });

    public ListNode mergeKLists(ListNode[] list){
        for (ListNode node :
                list) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;
            if (poll.next!=null){
                queue.offer(poll.next);
            }
        }
        return head.next;
    }
}
