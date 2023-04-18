package algorithm.JianZhiOffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 暴力解法会超时。
 * -------------------------------------------
 * 思路：利用基于分治的归并排序思想。在完成归并排序的同时，统计逆序对数量
 * 时间复杂度：O(NlogN)
 * 空间复杂度：O(N),额外数组的空间开销
 */
public class Q51_数组中的逆序对 {
    public int count = 0;
    public int reversePairs(int[] nums) {
        int lo= 0,hi = nums.length - 1;
        solve(nums,lo,hi);
        return count;
    }

    private void solve(int[] nums, int lo, int hi) {
        if (lo >= hi) return ;
        int mid = lo + (hi - lo) / 2;
        solve(nums,lo,mid);
        solve(nums,mid+1,hi);
        count(nums,lo,mid,hi);
    }

    private void count(int[] nums, int lo, int mid, int hi) {
        int[] temparr = new int[hi - lo + 1];
        int index = 0;
        int p1 = lo, p2 = mid + 1;

        while (p1 <= mid && p2 <= hi) {
            if (nums[p1] <= nums[p2]) {
                temparr[index++] = nums[p1++];
            } else {
                //TODO 统计逆序对的个数
                //解题的关键就是这一步，如果左边数组p1指针之前的元素都小于nums[p2],
                //代表左边数组p1指针到mid指针之间的元素和num[p2]组成的(mid - p1 + 1)个组合都是逆序对。
                count += (mid - p1 + 1);
                temparr[index++] = nums[p2++];
            }
        }
        //把左边剩余的数移入数组
        while (p1 <= mid) {
            temparr[index++] = nums[p1++];
        }
        //把右边剩余的数移入数组
        while (p2 <= hi) {
            temparr[index++] = nums[p2++];
        }

        //TODO 为了统计逆序对个数，也必须完整的完成对元素组nums的归并排序
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < temparr.length; k++) {
            nums[k + lo] = temparr[k];
        }
    }
}
