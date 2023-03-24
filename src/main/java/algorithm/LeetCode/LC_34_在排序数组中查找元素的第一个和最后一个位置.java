package algorithm.LeetCode;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * ---------------------------------
 * 思路：二分查找O(logn)
 * 先找到target第一次出现的位置，再找到target+1第一次出现的位置；
 *
 * 总结：
 * 二分法查找的两种情况：
 * 1.在不包含重复元素的有序数组查找元素的位置；
 * 2.在包含重复元素的有序数组查找元素【第一次】出现的位置；
 *   （查找最后一次出现的位置，可以通过找到后面一个元素【第一次】出现的位置得到结果）
 *   （所以如果既要找到元素第一次出现的位置，也要找到该元素最后一次出现的位置，例如本题，可以定义一个方法，调用两次。）
 */
public class LC_34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int lo = solve(nums,target);//第一次出现的位置
        int hi = solve(nums,target+1);//后面一个元素第一次出现的位置，就可以得到结果
        //lo==nums.length代表查找的元素超过了数组最大值，nums[lo]!=target代表查找的元素不存在。
        return (lo==nums.length||nums[lo]!=target)?new int[]{-1,-1}:new int[]{lo,hi-1};
    }
    /**
     * @param array
     * @param k
     * @return
     * 1.返回元素 k 在【非降序数组】中第一次出现的下标。
     * 2.如果元素 k 不存在，返回大于 k 的最小元素的下标。
     * 3.如果元素 k 超过了【非降序数组】的最大值。则大于 k 的最小元素的下标也不存在，返回数组长度array.length。
     * (这种情况返回数组长度array.length比较方便，我们只需要把 hi 初始化为array.length。
     *  如果元素 k 超过了【非降序数组】的最大值。那么 k 一定大于array[mid]，会一直调整左边界lo，直至两指针相遇，最后返回的 lo = hi = array.length)
     */
    private  int solve(int[] array, int k) {
        int lo = 0;
        int hi = array.length;
        while (lo < hi) {//hi指针保存了mid，所以当lo = hi时，直接返回 lo或者hi即可，不需要再进行一次循环。
            int mid = (hi + lo) / 2;
            if (array[mid]>=k){
                hi = mid;
            }else {
                lo = mid+1;//调整左边界
            }
        }
        return lo;//这里必须返回lo，因为hi记录的可能不是第一次出现的位置，但array[mid] < k时 lo = mid + 1，所以lo下标的元素如果等于target，那一定是第一次出现。
    }
}
