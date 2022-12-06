package algorithm.JianZhiOffer;
/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

因为各个子问题的最优解不相互独立，存在最优子结构，所以用动态规划解题
boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1]；
子问题：dp[i][j]表示str的前i个能否匹配pattern的前j个

转化方程：1.若pattern[j]==str[i] 或 pattern[j]=='.' 则dp[i][j] = dp[i - 1][j - 1];
        2. 若pattern[j]=='*',则分两种情况：
                                （1）直接把pattern[j]和pattern[j-1]当作空字符，即dp[i][j] = dp[i][j - 2];
                                （2）若dp[i][j - 2]不为true，则如果pattern[j-1]匹配str[i]（pattern[j-1]==str[i]||pattern[j-1]=='.'），dp[i][j] == dp[i - 1][j]；
                                这两种情况，只要有一种是true，则dp[i][j]==true
 */
public class Q52 {
    //使用动态规划求解
    public boolean match(String str, String pattern) {
        // write code here
        int s = str.length();
        int p = pattern.length();
        boolean[][] dp = new boolean[s + 1][p + 1];//00 用于存放两个空字符串的结果 dp[i][j] 表示模式串前j个是否与字符串前i个匹配
        for (int i = 0; i <= s; i++) {//实际上模式串和字符串的起点为1(所以后面的下标都是i-1 j-1)
            for (int j = 0; j <= p; j++) {
                if (j == 0) {
                    dp[i][j] = (i == 0);//只有字符串和模式串都为空的时候才匹配，当模式串为空，字符串不为空则返回false
                } else {
                    if (pattern.charAt(j - 1) != '*') {//如果第j-1个字符不是*
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                            //正常匹配
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {//如果第j个是* 那么分两种情况，有一种成立即可
                        //case 1 可以直接忽略*前模式的那个元素（*代表出现0次 比如a* 这两个元素做空字符串）
                         //那么dp[i][j]==true 只需满足 dp[i][j-2]==true即可
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        //case 2 如果dp[i][j-2]不等于true那么要满足第j-1个字符(这个字符也可以为‘.’)与第i个字符匹配即可
                        //下标多减1是因为dp是从1开始记录的
                        if (i > 0 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];//使用或等于 两种情况有一种符合就行
                        }
                    }
                }


            }
        }
        return dp[str.length()][pattern.length()];
    }
}
