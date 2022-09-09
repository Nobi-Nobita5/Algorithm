package algorithm.MianShi;

import static java.util.Arrays.sort;

public class Sort_快速排序 {
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
        int t = a[left];
        a[left] = a[i];//此处与a[left]交换的必须是a[i]
        a[i] = t;

        //每一次递归就确定一个基准值的位置，两边再继续递归
        solve(a,left,i-1);
        solve(a,i+1,right);
    }
}
