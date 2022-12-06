package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Xionghx
 * @Date: 2022/06/22/17:32
 * @Version: 1.0
 */
/*
思路：
1.先根据区间左边界排序
2.创建存放合并后区间的集合
3.left=0、right=0指针指向temp集合中的区间元素，第一个合并区间的左边界一定是leftBound = intervals[left][0]，求得右边界即可
4.循环求右边界，每次于后面区间的右边界比较取较大的值，循环条件：right不越界、且right指向的后面区间的左边界<=当前区间右边界
5.left = right;得到一个合并区间后，left指向right指针位置
 */
public class LC_56_merge_Intervals {
    public int[][] merge(int[][] intervals){
        //sort to get ordered array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> temp = new ArrayList<>();//按顺序存放合并后区间的集合
        int left = 0,right = 0;//left、right指向temp集合中的区间元素
        while (right<intervals.length){
            int leftBound = intervals[left][0];//区间左边界
            int rightBound = intervals[right][1];//区间右边界

            //合并区间
            while (right<intervals.length && intervals[right][0]<=rightBound){//right不越界、且right指向的后面区间的左边界<=当前区间右边界
                //合并后区间的右边界 = max{[right指向的后面区间的右边界]，[当前区间右边界]}
                rightBound = Math.max(intervals[right][1],rightBound);
                right++;//right指向temp中下一个区间元素
            }
            left = right;//得到一个合并区间后，left指向right指针位置
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
