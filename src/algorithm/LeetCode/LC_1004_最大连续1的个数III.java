package algorithm.LeetCode;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 *
 * ----------------------------------------
 * 思路：滑动窗口
 * 右指针不断右移；zeros > k时，左指针会和右指针一起右移，左指针遇到0，则zeros--；
 * 后面左指针就不会右移了，还是继续右指针右移，尝试扩大窗口；
 * 重复上述操作，直到右指针越界，返回right - left。
 *
 * 解法同Leetcode 424. Longest Repeating Character Replacement
 * 时间复杂度:O(N)
 *  [1,1,1,0,0,0,1,1,1,1,0]
 */
public class LC_1004_最大连续1的个数III {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0,right = 0;
        int zeros = 0;
        while (right < len){
            if (nums[right] == 0){
                zeros++;
            }
            if (zeros > k && nums[left++] == 0){//zeros > k 才会执行left++
                zeros--;
            }
            right++;
        }
        return right - left;
    }
}
