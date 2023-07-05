package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2023/07/03/20:16
 * @Version: 1.0
 *
 */

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 * ----------------------------------------
 * 思路：相向双指针，记录最大值
 */
public class LC_11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max,area);
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
