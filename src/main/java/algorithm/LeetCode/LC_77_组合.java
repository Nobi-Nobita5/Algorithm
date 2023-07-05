package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 注：
 * 排列和组合的区别就是有序无序。
 * 5个数中取三个，无序，称作组合。 比如（1,2,3）和（2,1,3）以及（3,1,2）都一样，没有区别。
 * 5个数中取三个，排成一排，有序，称作排列。
 * ------------------------
 * 思路：回溯，与面试题08_07_无重复字符串的排列类似，但本题是求组合。
 */
public class LC_77_组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(n,k,1,new ArrayList<Integer>(),res);

        return res;
    }
    public void dfs(int n, int k,int start,List<Integer> curr,List<List<Integer>> res){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start;i <= n;i++){
            curr.add(i);
            dfs(n,k,i+1,curr,res);
            curr.remove(curr.size() - 1);
        }
    }
}
