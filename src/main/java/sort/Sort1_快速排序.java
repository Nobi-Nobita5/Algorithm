package sort;

import static java.util.Arrays.sort;

/**
 * 一、快速排序基本内容
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * 二、实现的原理
 * 找出一个基准值，这个基准值可以是数组的头元素，也可以是尾元素，中间元素或者其他元素
 * 设置两个头尾变量l，r，分别指向数组的头尾
 * 循环，头指针l往后遍历，尾指针r往前遍历，头指针所指元素如果小于基准元素则l++，尾指针所指元素如果大于基准元素则r–，如果不满足条件则停下来
 * 直到头指针所指向的元素大于基准元素，尾指针所指向的元素小于基准元素后，交换这两元素的值
 * 递归调用
 * 总的来说，快速排序算法体现了分治思想
 *  ------------------------------------
 * 时间复杂度：平均O(nlogn)
 * 空间复杂度：O(logn)，因为快排的实现是递归调用的，而且每次函数调用中只使用了常数的空间，因此空间复杂度等于递归深度Θ(logn)。
 * */
public class Sort1_快速排序 {
    public int[] MySort (int[] arr) {
        // write code here
        int left = 0;
        int right = arr.length-1;
        solve(arr,left,right);
        return arr;
    }

    private void solve(int[] a,int left, int right) {
        if (left>=right) return;
        int i = left;
        int j = right;
        while (i!=j) {
            while (a[j] >= a[left] && i < j) {//从右往左找到比基准值小的就退出
                j--;
            }
            while (a[i] <= a[left] && i < j) {//从左往右找到比基准值大的就退出
                i++;
            }//要先从右往左，再从左往右
            if (i<j){//i,j下标对应的值进行交换
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //i,j两指针相遇，代表指针left所在基准值已经找到自己的归属位置
        int t = a[left];
        a[left] = a[i];//此处与a[left]交换的必须是a[i]。将基准值放在i指针所在的位置，这一步操作可以保证：i指针左边都比基准值小，i指针右边都比基准值大，
        a[i] = t;

        //每一次递归就确定一个基准值的位置，两边再继续递归
        solve(a,left,i-1);
        solve(a,i+1,right);
    }
}
