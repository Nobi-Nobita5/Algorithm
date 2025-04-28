package interview;



import algorithm.ListNode;

import java.util.Stack;

/*
用栈判断正反遍历结果是不是一样的就完事了
 */
public class isPail_判断回文链表 {
    /**
     *
     * @param head
     * @return
     */
    public boolean isPail (ListNode head) {
        // write code here
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head!=null){
            if (head.val!=stack.pop().val) return false;
            head = head.next;
        }
        return  true;
    }
}
