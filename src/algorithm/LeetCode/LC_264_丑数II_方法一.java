package algorithm.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
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
 */
public class LC_264_丑数II_方法一 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {//add()重复元素返回false
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
