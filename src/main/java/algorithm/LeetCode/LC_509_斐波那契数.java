package algorithm.LeetCode;
/**
 * 斐波那契数 （通常用 f(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。即 f(n) = f(n-1) + f(n-2)。
 *
 * 青蛙跳台阶问题：青蛙一步可以跳1阶或者2阶，求青蛙跳到第n阶有几种跳法。
 * 由于青蛙跳到第n阶之前一定在第n-1阶或者第n-2阶，故青蛙跳到第n阶的跳法种数f(n) = f(n-1) + f(n-2);
 *
 * 可见两个问题要求的f(n)表达式相同，所以解法也类似（两个问题的递归出口不同）。
 * */
public class LC_509_斐波那契数 {
    //递归
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n-1) + fib(n-2);
    }
}

class LC_509_斐波那契数_方法二 {
    //动态规划
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

class LC_509_斐波那契数_优化 {
    //动态规划
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        //空间复杂度优化到O(1)
        int a = 0;
        int b = 1;
        int res = 1;
        for (int i = 3; i <= n; i++) {
            a = b;
            b = res;
            res = a + b;
        }
        return res;
    }
}