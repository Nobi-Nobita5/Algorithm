package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/23/16:49
 * @Version: 1.0
 * 思路：指针，合并两个有序数组，再求中位数
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
    public int[] merge(int[] a,int[] b){
        int i = 0,j = 0,flag = 0;
        int[] res = new int[a.length+b.length];
        while (i<a.length && j<b.length) {
            if (i < a.length && j < b.length && a[i] <= b[j]) {
                res[flag] = a[i];
                flag++;
                i++;
            }
            if (j < b.length && i < a.length && a[i] > b[j]) {
                res[flag] = b[j];
                flag++;
                j++;
            }
        }
        if (i < a.length){
            for (int k = i; k < a.length; k++) {
                res[flag] = a[k];
                flag++;
            }
        }
        if (j < b.length){
            for (int k = j; k < b.length; k++) {
                res[flag] = b[k];
                flag++;
            }
        }
        return res;
    }
}
