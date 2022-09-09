package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/23/16:38
 * @Version: 1.0
 * 一、快速排序基本内容
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * 二、实现的原理
 * 找出一个基准值，这个基准值可以是数组的头元素，也可以是尾元素，中间元素或者其他元素
 * 设置两个头尾变量l，r，分别指向数组的头尾
 * 循环，头指针l往后遍历，尾指针r往前遍历，头指针所指元素如果小于基准元素则l++，尾指针所指元素如果大于基准元素则r–，如果不满足条件则停下来
 * 直到头指针所指向的元素大于基准元素，尾指针所指向的元素小于基准元素后，交换这两元素的值
 * 递归调用
 * 总的来说，快速排序算法体现了分支思想
 *
 * 由于题目只要求我们找出第K大的数，而快排，每次划分都可以确定一个元素的最终位置，根据这一特性，我们便可解决本题。在找第K大数过程中，我们无需对整个数组排序，只需要在每次划分中查看本次划分后的枢纽元素是否是第K大数，
 * 如果划分得到的枢纽元素正好就是我们需要的第K大数，就直接返回该元素；否则，如果 mid 比目标下标小，就递归右子区间，否则递归左子区间。这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。
 */
public class LC_215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int m = nums.length - k;//第k大，第m小
        return solve(nums, 0, nums.length - 1, m);
    }
    private static int solve(int[] a,int left,int right,int m){
        int i = left , j = right;
        if (left>=right) return a[left];
        while (i!=j){
            while (a[j] >= a[left] && i < j){//从右往左找到比基准值小的就退出
                j--;
            }
            while (a[i] <= a[left] && i < j){//从左往右找到比基准值大的就退出
                i++;
            }//要先从右往左，再从左往右
            if (i<j){//i,j下标对应的值进行交换
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[left];
        a[left] = a[i];
        //此处与a[left]交换的必须是a[i]
        //要把a[left]这个基准值，放到中间
        a[i] = t;

        //每一次递归就确定一个基准值的位置，两边再继续递归
        if(i>m)
            return solve(a,left,i-1,m);
        else if (i<m)
            return solve(a,i+1,right,m);
        else
            return a[i];
    }
}
