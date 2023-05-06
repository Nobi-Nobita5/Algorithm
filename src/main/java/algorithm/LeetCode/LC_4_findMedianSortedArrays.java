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
 * 空间复杂度：额外数组开销，O(M+N)
 *
 * 思路二：无需合并两个有序数组，根据数组的长度，找到中位数的位置即可
 * 时间复杂度：O(M+N)
 * 空间复杂度：O(1)
 *
 * 思路三：上述两种方法，无法实现 O(log (m+n))的时间复杂度。很明显，要使用二分查找才能达到。实际上题目求中位数，就是求第 k 小数的一种情况。(具体实现没搞懂，以后看)
 * 时间复杂度：相当于在 m + n长度的数组中使用二分查找，O(log(M+N))
 * 空间复杂度：O(1)
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

class LC_4_findMedianSortedArrays_方法二 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }
}

class LC_4_findMedianSortedArrays_方法三 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
