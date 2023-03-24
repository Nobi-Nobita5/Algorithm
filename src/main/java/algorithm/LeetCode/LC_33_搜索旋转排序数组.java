package algorithm.LeetCode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * ----------------------------------------------------
 * 思路：二分查找O(logn)
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能部分有序。就这样循环。
 *
 * 具体步骤：
 * 注意：原数组是【升序有序的】
 * 1.先通过比较nums[0]和nums[mid]，判断哪边是有序序列
 * 2.再判断target是否存在于有序序列中，如果存在，那么就调整边界范围到这个有序序列。如果不存在，就调整边界范围到无序序列中。
 * 3.在while循环中寻找不断有序序列，二分调整边界范围。
 */
public class LC_33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {//[3 4 5 6 1 2]
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int lo = 0, hi = n - 1;
        while (lo <= hi){//两个指针并没有保存答案下标（指针每次都会跳过mid），也不是返回值，所以当两个指针相遇时，还需要进行一次循环，以便得到int mid = (lo + hi)/2，作为返回值。
            int mid = (lo + hi)/2;//二分调整边界范围
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {//先用nums[0]和nums[mid]比较，判断哪一边是有序序列
                //左边序列是有序的
                //左边序列最小下标一定是【0】
                if (nums[0] <= target && nums[mid] > target) {
                    hi = mid - 1;//如果target在左边的有序序列中，调整右边界
                } else {
                    lo = mid + 1;//如果target不在左边的有序序列中，调整左边界，进行下一次分组判断。
                }
            } else {
                //右边序列是有序的
                //右边序列最大下标一定是【n-1】
                if (nums[mid] < target && nums[n - 1] >=target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
