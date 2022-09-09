package algorithm.LeetCode;

/*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

 

示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109*/


import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Xionghx
 * @Date: 2022/08/26/15:55
 * @Version: 1.0
 *  思路：
 *  1. 先把数组存放在hashSet去重,O(n)；且这样查看一个数是否存在即能优化至 O(1) 的时间复杂度，无需暴力遍历。
 *  2. 外层循环遍历每个元素，内层循环：寻找x+1,x+2......是否存在，更新记录值longestStreak。
 *     如此这般，最坏的时间复杂度是O(n^2)
 *  3. 因为如果已知有一个 x, x+1, x+2,⋯,x+y 的连续序列，而我们却重新从 x+1，x+2 或者是 x+y 处开始尝试匹配，
 *     那么得到的结果肯定不会优于枚举 x 为起点的答案。因此我们在外层循环的时候碰到这种情况跳过即可。
 *  4. 那么如何判断跳过呢，由于我们要枚举的数一定是在数组中不存在前驱数x-1的，因此我们每次在哈希表中检查是否存在
 *     x-1即能判断是否需要跳过内层循环了。
 *  5. 增加了判断跳过内层循环的逻辑后，只有当一个数是连续序列的第一个数的情况下才会进入内层循环，然后在内层循环中匹配连续序列中的数，
 *      因此数组中的每个数只会进入内层循环一次。则总时间复杂度为O(n)。
 *
 */
public class LC_128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        //先把数组存放在hashSet去重,O(n)
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }
        int longestStreak = 0;

        //遍历每个元素
        for (int num :
                numSet) {
            //增加判断前驱条件
            if (!numSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum+1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(currentStreak,longestStreak);
            }
        }
        return longestStreak;
    }
}
