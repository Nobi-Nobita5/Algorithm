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
 *
 * 1.先a~z存在的字符维护进大顶堆中，大顶堆根据出现次数排序。
 * 2.将大顶堆 堆顶的两个元素弹出，并加入sb，对应字母的出现次数减1。
 *   若对应字母的出现次数仍 大于 0，继续向大顶堆中offer该元素，大顶堆会自动排序。
 * 3.无论排序后的大顶堆 堆顶元素 是什么，都可以循环上述操作，实现重构字符串使得两相邻的字符不同的目的。
 * ------------------------------------------------------
 * 时间复杂度：O(Nlog|Σ| + |Σ|),N是字符串长度，|Σ|是字符集。
 *            重构字符串需要对大顶堆进行取出和添加元素的操作，取出元素和添加元素的次数不会超过n次，每次操作的时间复杂度是O(log|Σ|)，因为大顶堆的元素最多|Σ|个。
 *            因此总时间复杂度是O(Nlog|Σ| + |Σ|)。
 * 空间复杂度：O(|Σ|)，|Σ|是字符集
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
            counts[c-'a']++;//s 只包含小写字母
            maxCount = Math.max(maxCount,counts[c - 'a']);
        }
        if (maxCount > (length + 1) /2){//返回空字符串的唯一情况，出现最多次字母的次数 大于 (length + 1) /2
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                //按字符的出现次数降序排序
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];// o2 - o1，当前元素o1 大于 比较元素o2时，返回负数 --> 降序，大顶堆
            }
        });
        //将a~z存在字符维护进大顶堆
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        /*
        * 将大顶堆 堆顶的两个元素弹出，并加入sb，对应字母的出现次数减1。
        * 若对应字母的出现次数仍 大于 0，继续向大顶堆中offer该元素，大顶堆会自动排序。
        *
        * 无论排序后的大顶堆 堆顶元素 是什么，都可以循环上述操作，实现重构字符串使得两相邻的字符不同的目的。
        * */
        while (queue.size() > 1) {//while循环的逻辑 要保证大顶堆最少有两个元素
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
        if (queue.size() > 0) {//添加大顶堆剩余的最后一个元素
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
