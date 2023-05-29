package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class 面试题08_07_无重复字符串的排列组合 {
    /**
     * 具体的实现步骤如下：
     * -----------------------
     * 1.将字符串转换为字符数组，并创建一个与字符数组长度相同的布尔数组visited，用于记录字符是否已经被访问过。
     * 2.调用dfs方法进行回溯。
     * 3.如果当前排列的长度等于字符数组的长度，表示已经生成了一个完整的排列，将其加入到结果集中。
     * 4.遍历字符数组，如果当前字符已经被访问过，则跳过；否则，将当前字符添加到当前排列中，将对应的visited标记为已访问，然后进行下一层的递归。
     * 5.递归完成后，将当前字符从当前排列中删除，并将对应的visited标记为未访问，以便继续生成其他排列。
     * 最终，所有的排列组合都会被生成，并存储在permutations列表中。
     * @param S
     * @return
     */
    public String[] permutation(String S) {

        List<String> permutations = new ArrayList<>();
        dfs(S.toCharArray(), new boolean[S.length()], new StringBuilder(), permutations);

        //返回结果数组
        return permutations.toArray(new String[0]);
    }

    private void dfs(char[] chars, boolean[] visited, StringBuilder current, List<String> permutations) {
        if (current.length() == chars.length) {
            permutations.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.append(chars[i]);
            dfs(chars, visited, current, permutations);
            /**
             * 回溯的具体操作：
             * 1。dfs找到一个组合'abc'，方法退出，（当前dfs方法的for循环中i = 2）; visited[2] = false; current 删除对应字符，current = 'ab'。
             * 2。回溯到上一层，（当前dfs方法的for循环中i = 1）; visited[1] = false; current 删除对应字符，current = 'a'。
             * 3。由于方法还未退出，所以此时暂不回溯，继续下一层for循环，i = 2; visited[2] = true; current 添加对应字符，current = 'ac'。
             * 4。继续调用dfs方法，dfs找到下一个组合'acb'，方法退出，回溯到上一层；
             * 重复上述步骤，直到最先调用的dfs方法走完3次循环,详细如下：
             * 第一次循环得到：abc,acb
             * 第二次循环得到：bac,bca
             * 第三次循环得到：cab,cba
             */
            visited[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}
