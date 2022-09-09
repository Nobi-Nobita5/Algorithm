package algorithm.LeetCode;

import java.util.Stack;

/**
 * @Author: Xionghx
 * @Date: 2022/07/14/16:22
 * @Version: 1.0
 *
 * + - （ ） 的基本计算器
 * 思路：
 * 1.前面和后面的数一直依次相加即可；
 * 2.用一个sign标识每个操作数前面的正负号，
 *   因为一个字符串可能包含多个操作数，比如一对括号也算一个操作数“-()”，所以将标识存放在栈中，初始时stack.push(1)；
 * 3.遇到'+',改变栈中的这个标识，sign = stack.peek()，与下一个操作数相乘;遇到'-',sign = -stack.peek()，与下一个操作数相乘;
 * 4.遇到'('，将之前的sign标识再次入栈，如果括号前面是-，sign也会是-1，将sign入栈，就能保证后面每个操作数的sign标识都会变号
 *   遇到')',则将其出栈，是因为针对这个括号中改变sign标识的操作已经结束，出栈之后比如再sign = stack.peek()，那操作的就是外层的sign标识；
 * 这样括号中的+-都会和括号前的sign标识相乘，达到括号中每个元素都变号的效果
 *
 */
public class LC_224_基本计算器 {
    public int calculate(String s) {
        int sign = 1;//每个操作数前面的正负号标识
        int i = 0;//字符串下标
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        while (i < s.length()){
            if (s.charAt(i) == ' '){//为空时不操作
                i++;
            }else if (s.charAt(i) == '+'){//'+'不改变sign标识
                sign = stack.peek();
                i++;
            }else if (s.charAt(i) == '-'){//'-'改变sign标识
                sign = -stack.peek();
                i++;
            }else if (s.charAt(i) == '('){
                stack.push(sign);//不改变sign标识，将sign入栈；如果括号前面是-，sign也会是-1，将sign入栈，就能保证后面每个操作数的sign标识都会变号
                i++;
            }else if (s.charAt(i) == ')'){
                stack.pop();
                i++;
            }else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){//能计算出多位数的加数赋给num
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign*num;//每个元素相加的时候都乘以sign标识
            }
        }
        return res;
    }
}
