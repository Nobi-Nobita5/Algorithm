package algorithm.LeetCode;
import java.util.*;

/*
迭代字符串：

如果当前字符与前一个相同，栈顶元素加 1。

否则，往栈中压入 1。
如果栈顶元素等于 k，则从字符串中删除这 k 个字符，并将 k 从栈顶移除。

注意：因为在 Java 中 Integer 是不可变的，需要先弹出栈顶元素，然后加 1，再压入栈顶。
 */
public class LC_1209_删除字符串中的所有相邻重复项II {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i==0 || sb.charAt(i) != sb.charAt(i-1)){
                stack.push(1);
            }else {
                int incremented = stack.pop() + 1;
                if (incremented == k) {
                    sb.delete(i-k+1,i+1);//删除sb中的字符串
                    i = i-k;
                }else{
                    stack.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
