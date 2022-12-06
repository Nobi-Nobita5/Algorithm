package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/22/17:43
 * @Version: 1.0
 */
/*
双指针：
把不等于val的元素从左到右依次放在数组里
right:判断该指针指向元素是否等于val
left:把不等于val的元素从左到右依次放在该指针位置
 */
class LC_27_remove_element {
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
