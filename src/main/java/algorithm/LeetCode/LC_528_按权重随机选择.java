package algorithm.LeetCode;

import java.util.Random;

/**
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 *
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 * 示例 2：
 *
 * 输入：
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * 输出：
 * [null,1,1,1,1,0]
 * 解释：
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
 *
 * 由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * 诸若此类。
 *  
 *
 * 提示：
 *
 * 1 <= w.length <= 104
 * 1 <= w[i] <= 105
 * pickIndex 将被调用不超过 104 次
 *
 * -------------------------------------------------
 * [1,2,3,4]:根据权重划分0-10区间，[1,1],[2,3],[4,6],[7,10],返回下标3的概率是40%。前缀和数组可以表示出这种权重。
 *
 * 思路：
 * 用一个数组表示数组w[i]的前缀和:sum[i] = {1,3,6,10}。
 * 那么我们可以在{1-sum[w.length-1]}之间生成随机数x。
 * 然后使用二分查找，找到【满足sum[i] >= x的最小值】返回【其下标】即可。
 * 注：我们需要根据随机数 x 在前缀和数组中找到一个下标，所以使用二分查找会快一点。
 * -----------------------------------------------------
 * 时间复杂度：初始化前缀和数组sum的开销O(n)，每次查找是Log(n),故O(n)。
 * 空间复杂度：O(n)，即前缀和数组sum的空间开销
 */
public class LC_528_按权重随机选择 {

    private int[] sum;//前n为权重的和
    private Random random;//随机生成器

    public LC_528_按权重随机选择(int[] w) {
        random = new Random();
        //前缀和数组:sum[i]
        sum = new int[w.length];
        sum[0] = w[0];
        for(int i=1; i < w.length; i++){
            sum[i] = sum[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int x = random.nextInt(sum[sum.length-1]) + 1;
        //一定要加一，比如random.nextInt(10)最大只能得到9,要得到随机数10得加一
        return binarySearch(x);
    }

    public int binarySearch(int x){
        int lo = 0,hi = sum.length - 1;
        //lo<hi，代表lo = hi时 sum[mid] >= x 的 最小下标i已经确定。
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (sum[mid] >= x){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}
