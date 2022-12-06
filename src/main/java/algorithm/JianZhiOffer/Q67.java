package algorithm.JianZhiOffer;
/*
剪绳子，动态规划
最优子结构（最终结果是否能由各个子问题的最优解关联得到）
若满足，则求状态转化方程

长度为n的绳子剪成m段，求各段长度乘积最大值 n>1,m>1

例:n=8
int[] dp = new int[target+1];
子问题：dp[i]代表长度为i的绳子剪成若干段，求各段长度乘积最大值，即dp[i]为长度为i时的最优解

我们先剪一刀，那么这一刀可以有以下4种剪法
 dp[8] = max{dp[1]*dp[7],dp[2]*dp[6],dp[3]*dp[5],dp[4]*dp[4]};
其中dp[1],dp[2],dp[3],dp[4],dp[5],dp[6],dp[7]都是子问题，也都存在最优解，
状态转化方程已经给出，则用动态规划求解
 */
public class Q67 {
    public int cutRope(int target) {
        if (target==2) return 1;
        if (target==3) return 2;
        int[] dp = new int[target+1];
        //以下3种特殊情况作为初始条件时
        //他们剪了比不剪得到的乘积小
        // 我们要想得到最大值，那么就应取他们本身作为子问题
        //因为是作为子问题，所以可以不剪
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <=target ; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <=i/2 ; j++) {
                dp[i] = dp[j]*dp[i-j];
                if (dp[i]>max) max = dp[i];
            }
            dp[i] = max;
        }
        return dp[target];
    }
}
