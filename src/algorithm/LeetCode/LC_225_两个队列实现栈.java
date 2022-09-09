package algorithm.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Xionghx
 * @Date: 2022/07/05/14:55
 * @Version: 1.0
 * 思路：
 * 1.入栈的实现：
 * 先offer()元素到queue2中，将queue1中元素依次poll()到queue2中；
 * 再交换queue1和queue2，（就能得到队列queue1 : 3、2、1）；
 * 画个图就知道了
 * 2.出栈的实现：
 * 直接queue1.poll();
 * ----------------------------------
 * 两个栈实现队列的思路：(这个要简单点，不用交换)
 * 1.入队列的实现：
 * 直接stack1.push()
 * 2.出队列的实现：
 * if(!stack2.isEmpty()){
 *     while(!stack1.isEmpty()){
 *         stack2.push(stack1.pop())
 *          }
 *     }；
 * stack2.pop()
 */

public class LC_225_两个队列实现栈 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public LC_225_两个队列实现栈() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
