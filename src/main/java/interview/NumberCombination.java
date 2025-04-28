package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 1-9这九个数字，写成三个三位数，不能有重复数字，第二个数是第一个数的二倍，第三个数是第一个数的三倍，
 * 例如327，654，981，输出所有可能的这三个数的组合。
 * --------------
 * 思路：回溯 + 剪枝优化
 */
public class NumberCombination {
    public static List<List<Integer>> getNumberCombinations() {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack("", new boolean[9], combinations);
        return combinations;
    }

    private static void backtrack(String combination, boolean[] used, List<List<Integer>> combinations) {
        if (combination.length() == 3) {
            // 剪枝，每找到一个三位数就提前判断它的两倍和三倍是否有重复数字，有重复就提前终止当前生成长度为9的combination的路径。
            // Check if the second number is twice the first number and the third number is three times the first number
            Integer first = Integer.valueOf(combination);
            if (!check(combination.toCharArray(),String.valueOf(first*2).toCharArray(),String.valueOf(first*3).toCharArray()))
                return;
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(first*2);
                list.add(first*3);
                combinations.add(list);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            //剪枝，Integer.valueOf(combination) > 333后，不可能再对结果集有贡献
            if (!combination.equals("")){
                if (Integer.parseInt(combination) > 333) return;
            }
            //剪枝，通过记录已经访问过的状态，避免重复搜索，也是剪枝可以起到的作用
            if (!used[i - 1]) {
                used[i - 1] = true;
                backtrack(combination + i, used, combinations);
                used[i - 1] = false;
            }
        }
    }

    private static boolean check(char[] chars, char[] chars2, char[] chars3) {
        HashSet<Character> set = new HashSet<>();
        set.add('0');
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        for (int i = 0; i < chars2.length; i++) {
            if (set.contains(chars2[i])) return false;
            else set.add(chars2[i]);
        }
        for (int i = 0; i < chars3.length; i++) {
            if (set.contains(chars3[i])) return false;
            else set.add(chars3[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> combinations = getNumberCombinations();
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
