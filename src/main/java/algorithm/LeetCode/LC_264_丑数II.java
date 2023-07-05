package algorithm.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3、5 的正整数。
 *  1 通常也被视为丑数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 * -------------------------------
 * 方法一：最小堆
 * 要得到从小到大的第 n 个丑数，可以使用最小堆实现。
 *
 * 初始时堆为空。首先将最小的丑数 1 加入堆。
 *
 * 每次取出堆顶元素 x，则 x 是堆中最小的丑数，由于 2x, 3x, 5x也是丑数，因此将 2x, 3x, 5x加入堆。
 *
 * 上述做法会导致堆中出现重复元素的情况。为了避免重复元素，可以使用哈希集合去重，避免相同元素多次加入堆。
 *
 * 在排除重复元素的情况下，第 n 次从最小堆中取出的元素即为第 n 个丑数。
 *
 * ------------------------
 * 堆中使用long类型存储，因为用int存储第n个丑数可能会溢出。返回要求int类型，我们（int）转换一下就好了。
 *
 * 时间复杂度：O(NlogN)，n次循环获取第n个丑数，每次操作堆的时间复杂度为O(logN)。
 * 空间复杂度：O(N)，取决于最小堆和哈希表的大小。
 *
 */
public class LC_264_丑数II {
    public static int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();//PriorityQueue默认是升序。
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();//用 long 类型变量 curr 接收，以便下方基本类型之间的转换 long -> int。
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {//add(),如果元素已存在，会返回false
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}

/**
 * 题意：找到第n个丑数
 * 丑数定义：丑数是由2、3、5三个质因子中任意几个组成的数。1 通常也被视为丑数。
 * 方法二：动态规划
 *
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
class LC_264_丑数II_方法二 {//[1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
    public int nthUglyNumber(int n) {
        if (n==0) return 0;
        int[] dp = new int[n];
        /*
        用三个指针表示用哪个位置的元素来乘以2，3，5
        p2，p3，p5的更新规则为：此前添加的丑数乘的是哪一个因数，哪个因数对应的指针就加1。
         */
        int p2 = 0,p3 = 0,p5 = 0;
        dp[0] = 1;//设置第一个丑数
        for (int i = 1; i < dp.length; i++) {
            //可以用动态规划，最优解（各个子问题不相互独立）
            //丑数顺序1      2...   后面要么是1*3，1*5，要么是2*2，三个里面的最小值
            //实现的方法就是定义三个指针p2，p3，p5，表示指向的数组的下标，第i次循环计算dp[i] = Math.min(dp[p2] * 2,Math.min(dp[p3] * 3, dp[p5] * 5))。
            //指针的更新规则为：此前添加的丑数乘的是哪一个因数，哪个因数对应的指针就加1。
            //那么进行比较的3个数就是    dp[0]*2，dp[0]*3，dp[0]*5 (dp[0] = 1,dp[1] = 2) 结果dp[0]*2 = 2最小，结果作为第i个丑数。由于得到该丑数是通过乘以因数2，则p2++
            //                         dp[1]*2，dp[0]*3，dp[0]*5 (dp[0] = 1,dp[1] = 2) 结果dp[0]*3 = 3最小，结果作为第i个丑数。由于得到该丑数是通过乘以因数3，则p3++
            //                         dp[1]*2，dp[1]*3，dp[0]*5 (dp[0] = 1,dp[1] = 2,dp[2] = 3) 结果dp[1]*2 = 4最小，结果作为第i个丑数。由于得到该丑数是通过乘以因数2，则p2++
            //                         dp[2]*2，dp[1]*3，dp[0]*5 (dp[0] = 1,dp[1] = 2,dp[2] = 3,dp[3] = 4) 结果dp[0]*5 =5最小，结果作为第i个丑数。由于得到该丑数是通过乘以因数5，则p5++
            //                         ......得到第n个最小
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i]==dp[p2] * 2) p2++;//TODO 让该指针下次参与的运算结果变大
            if (dp[i]==dp[p3] * 3) p3++;
            if (dp[i]==dp[p5] * 5) p5++;
        }
        return dp[n-1];//返回第n个丑数
    }
}
