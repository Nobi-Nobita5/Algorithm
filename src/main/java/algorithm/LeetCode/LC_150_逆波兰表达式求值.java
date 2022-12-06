package algorithm.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Xionghx
 * @Date: 2022/07/11/16:51
 * @Version: 1.0
 *
 * 思路：
 * 使用栈
 * 遇到数字入栈，遇到字符，pop出栈顶两个元素进行计算，将结果再次入栈；
 * 最后返回栈顶元素即可
 */
public class LC_150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
