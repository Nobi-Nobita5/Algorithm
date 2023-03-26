package algorithm.LeetCode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 回文子串：从左往右和从右往左输出都是一样，这样的子串叫回文子串
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class LC_5_最长回文子串 {
    
    /**
     * 方法一：双指针的中心扩散
     * 1.遍历所有可能是回文子串的中心位置（中心位置可能是一个元素或者两个元素）
     * 2.从中心出发，指针向两边扩散，记录当前中心位置的最长回文子串的初始位置start和长度maxLen
     *
     * 时间复杂度：O (n^2)，枚举中心位置有 2N 个（这里我们没有分析得特别细致），每一次向两边扩散检测是否回文，时间复杂度都是O(n)。
     * 空间复杂度：O(1)，只使用到常数个临时变量，与字符串长度无关。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length()<=1) return s;
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int oddLen = expandAroundCenter(s, i, i);//回文中心是一个字符
            int evenLen = expandAroundCenter(s, i, i+1);//回文中心两个字符
            int currLen = Math.max(oddLen,evenLen);
            if (currLen > maxLen){
                maxLen = currLen;
                start = i - (maxLen-1) / 2;//(maxLen-1)
            }
        }
        return s.substring(start,start + maxLen);
    }
    /**
     * 回文子串的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expandAroundCenter(String s,int left,int right){
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length()){
            if (s.charAt(i) == s.charAt(j)){
                j++;
                i--;
            }else break;
        }
        //返回该回文子串的长度，退出while时s.charAt(i) != s.charAt(j)
        return j - i -1;
    }

    /**
     * ===========================================================================
     * 方法二：暴力解法（超时）
     * 遍历所有子串，依次记录回文子串，
     * 最后返回最长的回文子串。
     */
    public static String longestPalindrome2(String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                String currentString  = s.substring(i,j);
                boolean equals = currentString.equals(new StringBuilder(currentString).reverse());
                if (equals && currentString.length() > t.length())
                    t = currentString;
            }
        }
        return t;
    }

    /**
     * 方法三：动态规划
     * 1. 能想到“动态规划”解法，是因为“回文串”是天然具有“状态转移”性质的：一个回文去掉两头以后，剩下的部分依然是回文；
     * 2. 因此，我们可以使用“动态规划”的方法快速判断一个子串是否是回文子串。“动态规划”的方法，在判断子串的过程中使用，
     *    参考子串的子串是否是回文的结果。
     *     1)、如果一个字符串的头尾两个字符都不相等，那么这个字符串一定不是回文串；
     *     2)、如果一个字符串的头尾两个字符相等，才有必要继续判断下去：
     *         （1）如果里面的子串是回文，整体就是回文串；
     *         （2）如果里面的子串不是回文串，整体就不是回文串。
     *     即在头尾字符相等的情况下，里面子串的回文性质据定了整个子串的回文性质，这就是状态转移。于是我们把“状态”定义为原字符串的一个子串是否为回文子串。
     *
     *     状态 dp[i][j] ：子串 s[i, j] 是否为回文子串，这里 i 和 j 分别表示字符串 s 的左右边界，并且是可以取到的。
     *     状态转移方程：dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     *
     * 参考博客 https://blog.csdn.net/lw_power/article/details/104066936
     *
     * 动态规划”方法，实际上是“暴力解法”的优化，在判断是否回文这一步，我们“用空间换时间”，把时间复杂度降低了一个数量级
     *
     * 时间复杂度：O (n^2)
     * 空间复杂度：O (n^2)
     */
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len <= 1) return s;
        int start = 0;
        int maxLen = 1;
        //为了存放左右指针圈定的子串的回文性质，需要定义长宽都为len的二维数组dp[][]。因为左右指针都可能指向字符串的最后一个元素。
        //dp[left][right]用于表示子串 s[left, right] 是否为回文子串，这里 left 和 right 分别表示字符串 s 的左右边界。
        boolean[][] dp = new boolean[len][len];
        //初始化,左右指针相同时，指向同一个字符，该字符表示的字符串一定是回文串。
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int right = 1; right < len; right++) {
            //双重循环的写法要保证状态转移方程有效，
            //即两指针圈定的范围需要由小到大：
            // 1.外层循环的right指针从1开始不断变大，每次界定内层循环的右边界。
            // 2.内层循环的left指针从左边界0开始向又移动，每次界定内层循环的左边界。
            // 3.相当于双重循环圈定的子串范围在不断变大。
            // 4.如果通过左右指针能直接判断当前子串是否为回文串，则直接返回。如果不能通过左右指针直接判断，则调用状态转移方程，依据子串的子串判断回文性。
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) != s.charAt(right)){
                    dp[left][right] = false;//该子串不是回文子串
                }else {
                    if ((right - left) <= 2){
                        dp[left][right] = true;//中间只夹着一个字符,肯定是回文子串
                    }else {
                        dp[left][right] = dp[left + 1][right - 1];//状态转移
                    }
                }
                //每次内层循环，更新最长回文子串的长度 和 回文子串初始下标
                if (dp[left][right]){
                    int currLen = right - left + 1;
                    if (currLen > maxLen) {
                        maxLen = currLen;//记录最长回文子串的长度
                        start = left;//记录初始下标
                    }
                }
            }
        }
        //substring截取，左边界元素包含，右边界元素不包含
        return s.substring(start,start + maxLen);
    }
}
