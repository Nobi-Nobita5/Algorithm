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
 * 二分法查找的运用总不过两种情况：
 * 1.在不包含重复元素的有序数组查找到该元素的位置；
 * 2.在包含重复元素的有序数组查找到该元素第一次出现的位置；
 *   （查找最后一次出现的位置，也可以通过找到后面一个元素第一次出现的位置得到结果）
 */
public class LC_34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int lo = solve(nums,target);//第一次出现的位置
        int hi = solve(nums,target+1);//后面一个元素第一次出现的位置，就可以得到结果
        return (lo==nums.length||nums[lo]!=target)?new int[]{-1,-1}:new int[]{lo,hi-1};//
    }
    private  int solve(int[] array, int k) {
        int lo = 0;
        int hi = array.length;
        //因为最后一个元素可能是target，
        //那么用此方法查找target+1时，就要返回lo=hi=array.length,故hi初始化为array.length
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (array[mid]>=k){
                hi = mid;
            }else {
                lo = mid+1;
            }//保证返回的lo是k第一次出现的位置，如果不存在，返回的就是后面一个元素的位置
            //那么，如果返回的lo=array.length或者nums[lo]!=target就可以成为当前元素不存在的判断条件
        }
        return lo;
        /*
        hi只会在等于mid的数字中往前移动，当lo = hi时，lo，已经到了k第一次出现的位置，所以返回lo
         */
    }
}
