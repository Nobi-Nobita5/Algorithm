package algorithm.LeetCode;

import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 * ---------------------------------
 * 方法一：滑动窗口，用TreeMap(有序) 多敲两遍
 * 思路：
 * 用滑动窗口解决，需要返回窗口的最大值：
 * 用TreeMap(有序)存储数字和出现的次数；
 * left = 0, right = 0两个下标代表滑动窗口的左右边界，不断更新ret，取最大值
 *-----------------------------------------------
 * 时间复杂度：O(NlogN),N是数组长度，滑动窗口的时间复杂度是O(N),有序集合Treemap插入和删除都是O(logN)。
 * 空间复杂度：O(N),N是数组长度，最坏的情况下，Treemap和原数组一样大。
 */
public class LC_1438_绝对差不超过限制的最长连续子数组 {
    public int longestSubarray(int[] nums, int limit) {
        /**
         * HashMap和TreeMap的区别
         * • 排序区别：
         * 	 hashmap无序，Treemap有序，TreeMap在添加和删除节点的时候会进行重排序，会对性能有所影响。
         * • 性能区别：
         * 	 hashmap底层是数组加链表，查找O(1)添加O(1)删除O(1)会很快，Treemap底层是红黑树结构，会比较慢。
         * • null值区别：
         *   hashmap可以有一个null key和多个null value。而TreeMap不允许null key，但是可以允许多个null value。
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //用TreeMap(有序)存储数字和出现的次数
        //本题中用TreeMap只有一个作用，就是让窗口内的元素随时有序，可以通过map.lastKey() - map.firstKey()求得窗口最大差值。
        int n = nums.length;
        int left = 0, right = 0;//两个下标代表滑动窗口的左右边界
        int res = 0;//right - left + 1为返回值
        while (right < n){
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);
            //内层while：每一次右窗口右移put元素之后，都需要循环找出满足限制的子数组
            while (map.lastKey() - map.firstKey() > limit){//当前子数组不满足限制
                map.put(nums[left],map.get(nums[left]) - 1);//则子数组第一个元素，其对应TreeMap的value(次数)减一
                if (map.get(nums[left]) == 0){
                    //若减一后，次数为0，则在map中删除该元素，避免后续再被使用；
                    //之所以要维护TreeMap，就是为了在能够随时求得窗口最大差值的同时，也要能够删除不存在于窗口中的元素，避免后续再被使用。
                    map.remove(nums[left]);
                }
                left++;//左窗口右移
            }
            //每次内层while结束，更新一次res
            res = Math.max(res,right - left + 1);
            right++;//子数组满足限制之后，右窗口右移，继续put下一个元素
        }
        return res;
    }
}
