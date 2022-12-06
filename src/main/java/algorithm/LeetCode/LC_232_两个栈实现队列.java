package algorithm.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Xionghx
 * @Date: 2022/07/11/12:10
 * @Version: 1.0
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
public class LC_232_两个栈实现队列 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public LC_232_两个栈实现队列() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
