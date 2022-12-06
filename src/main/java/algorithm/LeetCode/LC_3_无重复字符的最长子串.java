package algorithm.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * --------------------------------------
 * 思路：同向双指针（滑动窗口）
 * 使用两个指针表示字符串中的某个子串（或窗口）的左右边界，
 * 右指针依次递增，直至遇到出现过的字符
 * 左指针依次递增（因为每个字符开头的子串都有可能是最终解）
 *
 *
 * 时间复杂度：每个指针都会遍历一遍字符串，O（N）
 */
public class LC_3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> characters = new HashSet<>();
        int n = s.length();
        int right = 0;
        int res = 0;
        for (int left = 0; left < n; ++left) {
            // 左指针向右移动一格，移除一个字符
            if (left!=0) characters.remove(s.charAt(left - 1));
            while (right < n && !characters.contains(s.charAt(right))){
                // 不断地移动右指针,并添加元素至哈希集合
                characters.add(s.charAt(right));
                right++;
            }
            // 第 left 到 right 个字符是一个极长的无重复字符子串
            res = Math.max(res,right - left);
        }
        return res;
    }
}
