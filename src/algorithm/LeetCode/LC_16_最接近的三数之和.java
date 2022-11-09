package algorithm.LeetCode;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * -------------------------------------------------
 * 思路：同 LC_15_三数之和
 */
public class LC_16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int ChaZhi = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int left = i+1,right = n - 1;
            while (left < right){
                int curr = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - curr) < ChaZhi) {
                    ChaZhi = Math.abs(target - curr);
                    res = curr;
                }
                if (curr > target){
                    right--;
                }else if (curr < target){
                    left++;
                }else return target;
            }
        }
        return res;
    }
}
