package algorithm.LeetCode;

/**
 * 这是一个 交互式问题 ）
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *  
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 *  
 *
 * 注意：
 *
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 *
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 示例 2：
 *
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 *  
 *
 * 提示：
 *
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 *
 *
 *  * // This is MountainArray's API interface.
 *  * // You should not implement it, or speculate about its implementation
 *  * interface MountainArray {
 *  *     public int get(int index) {}
 *  *     public int length() {}
 *  * }
 *
 *  -------------------------------------------
 *  本题中的山脉数组，只有一个峰顶。
 *  * 1.先用二分法找到峰顶peak；
 *  * 2.再先左（升序）后右（降序）使用二分查找
 *  * 3.降序的二分查找，操作相反，所以定义flag标识
 */
public class LC_1095_山脉数组中查找目标值 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {//指针相遇，说明找到封顶peak
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;//此时mid可能就是peak
            }
        }
        //找到了峰顶peak
        int peak = l;
        int index = binarySearch(target, mountainArr, 0, peak, true);//对峰顶左边的升序数组进行二分查找
        if (index != -1) {
            return index;
        }
        return binarySearch(target, mountainArr, peak + 1, mountainArr.length() - 1, false);//对峰顶右边的降序数组进行二分查找
    }

    /***
     * //对峰顶左右两边的的有序数组分别进行二分查找
     * @param target
     * @param mountainArr
     * @param left
     * @param right
     * @param flag true是代表升序数组的查找，flase代表降序数组的查找
     * @return
     */
    public int binarySearch(int target, MountainArray mountainArr,int left,int right,Boolean flag){
        while (left <= right){//两个指针都会跳过mid，不保存mid(可能的最终答案)，所以left = right指针相遇时也要进行一次循环，以便执行int mid = (left + right)/2，返回mid下标。
            int mid = (left + right)/2;
            if (target < mountainArr.get(mid)){
                if (flag){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (target > mountainArr.get(mid)){
                if (flag){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                return mid;//返回mid下标。
            }
        }
        return -1;//找不到与target相等的元素下标就返回-1。
    }
}
