package algorithm.LeetCode;

import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 *
 * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
 *
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 *
 * 示例：
 * 输入：points = [[1,3],[-2,2]], k = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 *
 * 思路：
 * 用优先级队列（一个大顶堆array2[0] - array1[0]），
 * 实时维护前 k 个最小的距离平方和前 k 个点的编号（为了方便最后直接得到答案points[pq.poll()[1]）
 *  *
 */
public class LC_973_最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        for (int i = 0; i < points.length; i++) {
            //平方是用Math.pow()
            int p = (int) ((Math.pow(points[i][1],2)) + Math.pow(points[i][0],2));
            if (pq.size() >= k){
                pq.offer(new int[]{p,i});
                //System.out.println(Arrays.toString(pq.poll()));
                pq.poll();
            }else {
                pq.offer(new int[]{p,i});
                //System.out.println(Arrays.toString(pq.peek()));
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[pq.poll()[1]];
        }
        return res;
    }

}
