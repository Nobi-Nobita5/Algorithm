package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/22/17:43
 * @Version: 1.0
 */
/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
 * 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * -------------------------------------------------------
 * 思路：双指针
 * TODO 把不等于val的元素从左到右依次放在数组里
 * right:判断该指针指向元素是否等于val
 * left:把不等于val的元素从左到右依次放在该指针位置
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class LC_27_移除数组中的元素 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
