package algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/*
 *思路：HashMap
 * 新建一个哈希表，判断target - nums[i]是否存在于该哈希表中；
 * 存在则返回下标，不存在则把元素存进HashMap中，
 */
public class LC_1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
