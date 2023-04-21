package algorithm.LeetCode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3：
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释："*" 先匹配 "." 为 ".." ，然后".." 再匹配 "ab"。

 * 提示：
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 * ------------------------------------------------
 * 思路：动态规划
 *
 * 状态：dp[i][j],表示 s 的前 n 个是否能被 p 的前 j 个匹配。
 * 状态方程：
 * 1. 如果 p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]；
 * 2. 如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
 * 3. 如果 p.charAt(j) == '*'：
 *      1）如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
 *      2）如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
 *          * dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
 *          * or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
 *          * or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
 *----------------------------------------------------
 * 状态方程对于 *号的情况，案例解释：
 * 假设：
 * s = # # a
 *         i
 * p = # # a *
 *           j
 *
 * 此时 p 的 a * 部分可以考虑用：（0次，1次，多次）
 *
 * 1. 如果用0次：
 *   p 的 a* 部分可以直接抛弃（想象成消消乐，并没有消去s中的字符，自己损失两位）。
 *   s = # # a
 *           i
 *   p = # # a *
 *         j
 *
 *   有：dp[i][j] = dp[i][j-2]
 *
 *
 * 2. 如果用1次：
 *   p 的 a* 部分消去了s的一个字符（p中的a*功能用完了，也应该丢弃--左移2位）
 *   s = # # a
 *         i
 *   p = # # a *
 *         j
 *   有：dp[i][j] = dp[i-1][j-2]
 *
 *   这种情况写成：dp[i][j] = dp[i][j-1]，其实是一样的，因为此时s[i] == p[j-1]，即下一步就是，dp[i][j-1] == dp[i-1][j-2]
 *   其实把 a* 理解为一个整体，要消去就全部消去，比较直观一点
 *
 * 3. 如果用多次：
 *   p的a*部分消去了s的末尾字符后，还要继续起作用，继续消除s前面的字符（不移动p的指针）
 *
 *   s = # # a
 *         i
 *   p = # # a *
 *             j
 *
 *   有：dp[i][j] = dp[i-1][j]
 *----------------------------------
 */
public class LC_10_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
        for (int i = 2; i <= n; i+= 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
