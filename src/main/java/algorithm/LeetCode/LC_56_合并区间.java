package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * -------------------------------------------------------------------------------
 * 思路：排序+双指针
 * 1.先根据区间左边界排序
 * 2.使用left,right两个指针指向 intervals 中的第n个数组元素。用于确定合并后区间的左右边界。
 * 3.while循环内指针进行一次线性扫描，不断向结果集合temp中添加合并后的区间。
 * 4.right指针越界后退出线性扫描。
 * ------------------------------------------------------------------
 * 时间复杂度：根据区间左边界排序的时间复杂度是O(nlogn),while循环内指针只进行了一次线性扫描O(n)，所以总的时间复杂度是O(nlogn)。n是区间个数。
 * 空间复杂度：O(n),n是区间大小。存放合并后区间的集合的空间复杂度是O(n)。
 *            Arrays.sort()排序的空间复杂度小于O(n),故总的时间复杂度是O(n)。
 * -----------------------------------------------------
 * Java 中的 Arrays.sort() 方法使用了 TimSort 算法（对于基本类型，如 int、long、float 等，使用的是 Dual-Pivot Quicksort 算法）。这里我们讨论 TimSort 算法的空间复杂度。
 * TimSort 算法是一种混合排序算法，结合了归并排序（Merge Sort）和插入排序（Insertion Sort）的优点。它的空间复杂度主要取决于所需的临时空间来执行归并操作。
 * 在最好的情况下，TimSort 算法可以在原地进行排序，空间复杂度为 O(1)。然而，在最坏的情况下，空间复杂度可能达到 O(n)，其中 n 是要排序的数组长度。
 * */
class LC_56_合并区间 {
    public int[][] merge(int[][] intervals){
        //sort to get ordered array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> temp = new ArrayList<>();//创建按顺序存放合并后区间的集合
        int left = 0,right = 0;//left、right指向temp集合中的第n个数组元素

        while (right<intervals.length){
            int leftBound = intervals[left][0];//合并后区间左边界
            int rightBound = intervals[right][1];//合并后区间右边界

            //合并区间
            while (right<intervals.length && intervals[right][0]<=rightBound){//right不越界、且right指向的后面区间的左边界<=当前区间右边界
                //合并后区间的右边界 = max{[下一个数组元素区间的右边界]，[当前区间右边界]}
                rightBound = Math.max(intervals[right][1],rightBound);
                right++;//right指向temp集合中的下一个数组元素
            }

            left = right;//得到一个合并区间后，left指向right指针位置，开始计算下一个可以合并的区间。
            temp.add(new int[]{leftBound, rightBound});//temp中添加合并后的区间
        }

        //copy the result to the array from List
        int[][] res = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            res[i][0] = temp.get(i)[0];
            res[i][1] = temp.get(i)[1];
        }
        return res;
    }
}
