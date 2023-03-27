package algorithm.LeetCode;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 *
 * ------------------------------------------
 * 思路：双指针相向移动判断 "A man, a plan, a canal: Panama"；
 *       遇到非字母或数字的字符，跳过。
 * 时间复杂度：两个指针最多只会移动N次，N是字符串长度，所以时间复杂度是O(N)
 */
public class LC_125_验证回文串 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right){
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right){//该字符是否是数字或字母
                left ++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right){
                right --;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){//忽略大小写
                return false;
            }else {
                left ++;
                right --;
            }
        }
        return true;
    }
}
