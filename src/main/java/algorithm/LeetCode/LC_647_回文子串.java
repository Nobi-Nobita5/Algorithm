package algorithm.LeetCode;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * --------------------------------------------
 * 思路：与 LC_5_最长回文子串 相同
 */
public class LC_647_回文子串 {
    /**
     * 方法一：背向双指针
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s.length() <= 1) return s.length();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int s1 = expandAroundCenter(s, i, i);
            int s2 = expandAroundCenter(s, i, i + 1);
            count += s1+s2;
        }
        return count;
    }

    /**
     * 返回当前中心扩散的回文子串个数
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int i = left, j = right;
        int res = 0;
        while (i>=0 && j<=s.length() - 1){
            if (s.charAt(i) == s.charAt(j)){
                i--;j++;res++;
            }else break;
        }
        return res;
    }

    /**
     * 方法二：动态规划（暴力解法优化）
     * 状态转化方程：dp[left][right] = (s.charAt(left) == s.charAt(right)) && dp[left][right] = dp[left + 1][right - 1];
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int len = s.length();
        if (len <= 1) return len;
        boolean[][] dp = new boolean[len][len];
        int res = len;
        for (int right = 1; right < len; right++) {//遍历所有子串
            for (int left = 0; left < right; left++) {
                //left < right,这里没考虑left==right，所以初始res默认为s的长度
                if (s.charAt(left) != s.charAt(right)){
                    dp[left][right] = false;
                }else {
                    if ((right - left) <= 2){
                        dp[left][right] = true;
                    }else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if (dp[left][right]){
                    res += 1;//是回文子串，则res计数加一
                }
            }
        }
        return res;
    }
}
