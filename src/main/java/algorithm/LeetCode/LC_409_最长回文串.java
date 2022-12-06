package algorithm.LeetCode;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输入:1
 *  
 *
 * 提示:
 *
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 *
 * ------------------------------------------
 * 思路：出现次数为偶数的元素可以都要、出现次数为奇数的元素最多只能要一个
 */
public class LC_409_最长回文串 {
    public int longestPalindrome(String s) {
        // 找出可以构成最长回文串的长度
        int[] a  = new int[128];//ASCLL值的范围为[0,128)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c]++;//字符出现次数加一
        }
        int count = 0;
        for (int i :
                a) {
            count += i % 2;//记录有几个元素出现次数为奇数
        }
        return count == 0 ? s.length():s.length() - count + 1;
    }
}
