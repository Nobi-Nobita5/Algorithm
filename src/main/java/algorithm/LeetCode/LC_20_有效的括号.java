package algorithm.LeetCode;

import java.util.Stack;

/**
 * @Author: Xionghx
 * @Date: 2022/07/14/17:25
 * @Version: 1.0
 *
 * 先进后出用栈实现
 * 1.先把左括号入栈
 * 2.遇到右括号，直接判断当前栈顶元素是不是map对应的左括号，是则出栈栈顶元素，否返回false
 * 3.最后判断，栈为空则返回true
 */
public class LC_20_有效的括号 {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
                i++;
            }else if (s.charAt(i) == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    i++;
                }else return false;
            }else if (s.charAt(i) == ']'){
                if (!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                    i++;
                }else return false;
            }else if (s.charAt(i) == '}'){
                if (!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                    i++;
                }else return false;
            }
        }
        return stack.isEmpty();
    }
}
