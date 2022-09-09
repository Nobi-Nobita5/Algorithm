package algorithm.LeetCode;

import java.util.*;

/**
 * @Author: Xionghx
 * @Date: 2022/08/26/17:17
 * @Version: 1.0
 * 思路：
 * 使用哈希表，让List集合删除任意一个元素的时间复杂度为O(1)。
 */
public class LC_380_O1时间插入_删除和获取随机元素 {
    List<Integer> nums;
    Map<Integer, Integer> indices;//map集合中键存放元素值，值存放元素的下标
    Random random;


    public LC_380_O1时间插入_删除和获取随机元素() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    //insert可以直接插入末尾
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    //remove需要与哈希表配合
    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);//List集合被删掉的元素的位置上，现在放的是原来最后一个元素
        indices.put(last, index);//map集合中存放该被删除元素的下标，现在该下标对应的键是最后一个元素
        nums.remove(nums.size() - 1);//删除List集合中原来的最后一个元素
        indices.remove(val);//删除map中原来的该元素
        return true;
    }

    //Random类获取随机数作为下标，数组查找时间O(1)
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());//获取size大小内的一个随机数作为nums下标
        return nums.get(randomIndex);
    }
}
