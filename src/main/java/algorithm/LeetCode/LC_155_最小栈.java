package algorithm.LeetCode;

import java.util.Stack;

/**
 * @Author: Xionghx
 * @Date: 2022/07/06/17:18
 * @Version: 1.0
 * 思路：
 * push{
 *    stack.push(val);
 *    MinStack.push(Math.min(MinStack.peek(),val));
 * }
 */
public class LC_155_最小栈 {
    Stack<Integer> stack;
    Stack<Integer> MinStack;
    public LC_155_最小栈() {
        stack = new Stack<>();
        MinStack = new Stack<>();
        MinStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        MinStack.push(Math.min(MinStack.peek(),val));
    }

    public void pop() {
        stack.pop();
        MinStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MinStack.peek();
    }
}
