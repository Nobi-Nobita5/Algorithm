package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个长度为n的数组，数组中的数字不重复，实现一个函数，打印从数组的n个数中选取m个数的所有组合情况。
 *
 * 例如，给定数组为：[1, 3, 5, 8, 9]，m=3，打印结果如下：
 * 5 8 9
 * 3 8 9
 * 1 8 9
 * 3 5 9
 * 1 5 9
 * 1 3 9
 * 3 5 8
 * 1 5 8
 * 1 3 8
 * 1 3 5
 */
public class 网易三面面试题 {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,8,9};

        ArrayList<List<Integer>> res = new ArrayList<>();

        backtrack(a,0,new ArrayList<Integer>(),res,3);

        for (List<Integer> curr:
             res) {
            System.out.println(curr + " ");
        }
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result, int m) {
        if (current.size() == m) {//当长度等于m时，结束当前递归
            result.add(new ArrayList<>(current));//添加元素近结果集合
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result, m);
            //剪枝
            current.remove(current.size() - 1);
        }
    }
}

