package algorithm.LeetCode;
/*
* 给定一个整数数组 asteroids，表示在同一行的行星。

对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。

找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

 

示例 1：

输入：asteroids = [5,10,-5]
输出：[5,10]
解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
示例 2：

输入：asteroids = [8,-8]
输出：[]
解释：8 和 -8 碰撞后，两者都发生爆炸。
示例 3：

输入：asteroids = [10,2,-5]
输出：[10]
解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 

提示：

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
*/

/*
思路：用栈存储，遍历一次数组
1.正值入栈,第一个是负值也直接入栈  // [-5,10]向左向右移动不会发生碰撞--不考虑
2.负值与栈内元素比较，大于stack.peek()，则pop(),并继续挨个与栈内元素比较；
  等于stack.peek()，则pop()；
  小于stack.peek()，不做处理
*/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LC_735_行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < asteroids.length; i++) {
            coll:{
                while (!stack.isEmpty() && asteroids[i] < 0 && 0 < stack.peek()) {
                    if (stack.peek() < Math.abs(asteroids[i])) {
                        stack.pop();
                        continue;//进入下一次while循环
                    }
                    else if (stack.peek() == Math.abs(asteroids[i])) stack.pop();
                    break coll;//跳出整个while
                }
                stack.push(asteroids[i]);
            }
        }
        //栈中剩余元素放入数组
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
