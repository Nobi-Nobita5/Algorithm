package algorithm.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: s = "aaab"
 * 输出: ""
 *  
 *
 * 提示:
 *
 * 1 <= s.length <= 500
 * s 只包含小写字母
 *
 * -----------------------------------
 * 方法：基于最大堆的贪心 多写两遍
 * 详细思路见官方图解
 */
public class LC_767_重构字符串 {
    public String reorganizeString(String s) {
        if (s.length() < 2){
            return s;
        }
        int[] counts = new int[26];//记录每个字母的出现次数
        int maxCount = 0;//出现最多次字母的次数
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c-'a']++;
            maxCount = Math.max(maxCount,counts[c - 'a']);
        }
        if (maxCount > (length + 1) /2){//返回空字符串的唯一情况
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        //将字符串元素维护进大顶堆
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
