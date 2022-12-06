package algorithm.JianZhiOffer;
/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
窗口大于数组长度的时候，返回空
 */
import java.util.ArrayList;

public class Q64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (size==0||size>num.length){
            return list;
        }
        for (int i = 0; i <= num.length - size; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+size; j++) {
                if (num[j]>max) max = num[j];
            }
            list.add(max);
        }
        return list;
    }
}
