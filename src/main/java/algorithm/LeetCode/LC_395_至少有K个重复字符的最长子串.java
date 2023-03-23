package algorithm.LeetCode;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 *
 */
public class LC_395_至少有K个重复字符的最长子串 {
    /**
     * 方法一：分治法（递归实现）
     * 题意是要求计算最长子串（连续）的长度 max，这个最长子串要满足：每个字符的出现次数 大于等于 k。
     *
     * 那么我们可以用出现次数小于 k的字符 对给定字符串 s 进行分割，切分成若干段，
     * 则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。
     *
     * 因此，可以考虑分治的方式对字符串进行递归切分，统计max的最大值，
     * 递归方法的退出条件是，入参 String s 中的字符全部大于 k，直接返回 s.length()。
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String s, int k) {
        //统计每个字符出现的次数
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        //统计大于0小于k的字符
        String split = "";
        for (int i = 0; i < charCount.length; i++) {
            int count = charCount[i];
            if (count> 0 && count < k) {
                split = String.valueOf((char) (i + 'a'));
                break;//找到一个次数大于 0 且小于 k的就退出
            }
        }

        if (split.equals("")) {
            //全部都>k
            return s.length();
        }

        final String[] split1 = s.split(split);
        int max = 0;
        for (final String currentString : split1) {//继续对分割后的每一段字符串递归，答案一定在某一段内
            final int currentMax = dfs(currentString, k);
            //用每一次递归最终的退出值currentMax，作为一个最大值max的候选人进行比较。
            max = Math.max(max, currentMax);
        }

        return max;
    }


    /**
     * 方法二：滑动窗口
     */
}
