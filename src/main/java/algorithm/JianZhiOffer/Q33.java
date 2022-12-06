package algorithm.JianZhiOffer;
/*
定义：丑数是由2、3、5三个质因子中任意几个组成的数。
 */
public class Q33 {
    public int GetUglyNumber_Solution(int index) {
        if (index==0) return 0;
        int[] dp = new int[index];
        /*
        用三个指针表示用哪个位置的元素来乘以2，3，5
        p2，p3，p5的更新规则为：此前添加的丑数乘的是哪一个因数，哪个因数对应的指针就加1。
         */
        int p2 = 0,p3 = 0,p5 = 0;
        dp[0] = 1;//设置第一个丑数
        for (int i = 1; i < dp.length; i++) {
            //可以用动态规划，最优解（各个子问题不相互独立）
            //丑数顺序1      2...   后面要么是1*3，1*5，要么是2*2，三个里面的最小值
            //实现的方法就是定义三个指针p2，p3，p5，  更新规则为：此前添加的丑数乘的是哪一个因数，哪个因数对应的指针就加1。
            //那么下次进行比较的3个数就是1*3，1*5，2*2
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i]==dp[p2] * 2) p2++;
            if (dp[i]==dp[p3] * 3) p3++;
            if (dp[i]==dp[p5] * 5) p5++;
        }
        return dp[index-1];//返回第n个丑数

    }
}
