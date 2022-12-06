package algorithm.JianZhiOffer;

import java.util.Stack;
//思路就是直接模拟就完了
// 新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.
public class Q21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;//出栈数组下表
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
