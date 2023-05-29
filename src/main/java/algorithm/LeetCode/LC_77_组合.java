package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * ------------------------
 * 思路：回溯，与面试题08_07_无重复字符串的排列组合类似。
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
