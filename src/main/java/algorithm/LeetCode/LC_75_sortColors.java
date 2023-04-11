package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/06/23/16:23
 * @Version: 1.0
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * --------------------------------------------------------
 * 思路：
   快速排序，原地更改
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * -------------------------------------------------------
 * 进阶解法：单指针，线性扫描两次
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class LC_75_sortColors {
    public void sortColors(int[] nums) {
        solve(nums,0,nums.length-1);
    }

    private void solve(int[] a, int left, int right) {
        if (left>=right) return;
        int i = left;
        int j = right;
        while (i<j) {
            while (a[j] >= a[left] && i < j) {//从右往左找到比基准值小的就退出
                j--;
            }
            while (a[i] <= a[left] && i < j) {//从左往右找到比基准值大的就退出
                i++;
            }
            //要先从右往左，再从左往右,
            // 因为我们一开始是使用a[left]作为基准值，left已经是数组中最左边的元素，要先在基准值右边寻找比基准值小的元素

            if (i<j){//i,j下标对应的值进行交换
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[left];
        a[left] = a[i];//此处与a[left]交换的必须是a[i]。将基准值放在i指针所在的位置，这一步操作可以保证：i指针左边都比基准值小，i指针右边都比基准值大，
        a[i] = t;

        //每一次递归就确定一个基准值的位置，两边再继续递归
        solve(a,left,i-1);
        solve(a,i+1,right);
    }
}

/**
 * 由于数组中只有0，1，2三个数。故进行常数次线性扫描就可以完成排序（3个元素，只需扫描2次）
 * */
class LC_75_sortColors_方法二 {
    public void sortColors(int[] nums) {
        int p = 0;
        int p1 = 0;
        //第一次线性扫描，遇到0则交换到数组前面
        while (p1 < nums.length){
            if (nums[p1] == 0){
                int t = nums[p];
                nums[p] = nums[p1];
                nums[p1] = t;
                p++;
            }
            p1++;
        }

        p1 = p;

        //第二次线性扫描，遇到1则交换到0后面
        while (p1 < nums.length){
            if (nums[p1] == 1){
                int t = nums[p];
                nums[p] = nums[p1];
                nums[p1] = t;
                p++;
            }
            p1++;
        }
    }
}
