package algorithm.JianZhiOffer;

import java.util.Stack;

public class Q20 {
    //定义两个栈，min用于存放最小值
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min  = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.size()==0){
            min.push(node);
        }else {
            if (min.peek() > node) {
                min.push(node);
            } else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {//既然定义了两个栈，那么栈的基本操作都得实现
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
