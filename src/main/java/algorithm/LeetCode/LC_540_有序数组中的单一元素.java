package algorithm.LeetCode;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *
 */
public class LC_540_有序数组中的单一元素 {//[1,1,2,2,3,4,4,8,8]

    /**
     * 方法一
     * --------------------------------------
     * 依题意可知：数组长度一定是奇数，返回值下标x左右两边都是偶数个元素
     * x左边：mid是偶数就跟mid+1相等，mid是奇数就跟mid-1相等；
     * x右边：mid是偶数就跟mid-1相等，mid是奇数就跟mid+1相等；
     *
     * 那么解题思路：mid是偶数就跟mid+1比，mid是奇数就跟mid-1比，
     *             如果相等，说明当前的mid在x左边，调整左边界；
     *             如果不等，说明当前的mid>=x，调整右边界；
     * 注：按位异或，mid为偶数：【mid ^ 1】 = 【mid + 1】；mid为奇数：【mid ^ 1】 = 【mid - 1】；
     * ----------------------------------------
     * 时间复杂度：O(logN)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == nums[mid ^ 1]){
                lo = mid + 1;//nums[mid] == nums[mid ^ 1]，说明nums[mid]不是单一元素
            }else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    /**
     * 方法二
     * -----------------------------------------------------------
     * 依题意可知：数组长度一定是奇数，返回值下标x左右两边都是偶数个元素
     * x左边：mid是偶数就跟mid+1相等，mid是奇数就跟mid-1相等；
     *
     * 那么解题思路：第一个mid肯定是偶数，跟mid+1比，找到第一个不等的偶数下标即为所求
     * // mid & 1，mid为偶数时=0，为奇数时=1;保证 mid -= mid & 1 是偶数
     * @param nums
     * @return
     */
    public int singleNonDuplicate1(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
