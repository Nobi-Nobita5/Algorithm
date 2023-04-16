package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/23/16:49
 * @Version: 1.0
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * --------------------------------------
 * 思路一：指针，合并两个有序数组，再求中位数
 * 时间复杂度：遍历两个数组，O(M+N)
 * 空间复杂度：结果数组，O(M+N)
 * -------------------------------
 */
public class LC_4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = merge(nums1, nums2);
        int t = merge.length%2;
        if (merge.length == 0) return -1;
        if (merge.length == 1) return merge[0];
        double m = (merge[merge.length/2-1]*1.0+merge[merge.length/2]*1.0)/2,n = merge[merge.length/2];
        return t == 0 ? m:n;
    }
    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0,j = 0;
        int index = 0;
        while (i<nums1.length && j < nums2.length){
            if (nums1[i] <= nums2[j]){
                res[index++] = nums1[i++];
            }else res[index++] = nums2[j++];
        }
        while (i<nums1.length){
            res[index++] = nums1[i++];
        }
        while (j< nums2.length){
            res[index++] = nums2[j++];
        }
        return res;
    }
}
