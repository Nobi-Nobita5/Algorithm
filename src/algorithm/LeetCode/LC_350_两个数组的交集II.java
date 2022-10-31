package algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（
 * 如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *  
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 * 方法一：哈希表
 * 复杂度分析
 *
 * 时间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。需要遍历两个数组并对哈希表进行操作，哈希表操作的时间复杂度是 O(1)，因此总时间复杂度与两个数组的长度和呈线性关系。
 *
 * 空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个数组的长度。对较短的数组进行哈希表的操作，哈希表的大小不会超过较短的数组的长度。为返回值创建一个数组 intersection，其长度为较短的数组的长度。
 *
 */
public class LC_350_两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }//对较短的数组进行哈希表的操作
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        int index = 0;//创建res数组，用index下标记录插入的元素个数，最后用copyOfRange截取
        for (int num :
                nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            //getOrDefault：map中key对应的值不存在则提供默认值，存在则取key对应的value
            map.put(num,count);
        }
        for (int num :
                nums2) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                map.put(num,map.get(num)-1);
                res[index] = num;
                index++;
                }
            }
        return Arrays.copyOfRange(res,0,index);
    }
}
