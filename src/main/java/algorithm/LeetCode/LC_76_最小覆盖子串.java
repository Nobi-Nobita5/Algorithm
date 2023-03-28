package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *---------------------------------------------
 *
 * 最小覆盖字串
 * 思路：滑动窗口
 * 在滑动窗口类型的问题中都会有两个指针，一个用于【延伸】现有窗口的r指针，和一个用于【收缩】窗口的l指针。
 * 在任意时刻，只有一个指针运动，而另一个指针保持净值。
 * 我们在s上移动窗口，通过移动r指针不断扩张窗口。当窗口包含t全部所需字符后，如果能收缩，我们就收缩得到最小窗口
 *
 * 时间复杂度：
 *      建立维护t中元素的哈希表，O(|t|)。
 *      最坏情况下左右指针对 s 的每个元素各遍历一遍，哈希表中对 s 中的每个元素各插入、删除一次，对 t 中的元素各插入一次。O(|s|)
 *      每次检查是否可行会遍历整个 t 的哈希表，哈希表的大小与字符集的大小有关，设字符集大小为 C。O(C)。
 *      故渐进时间复杂度为 O(|t| + |s|*C)。
 * 空间复杂度：这里用了两张哈希表作为辅助空间，每张哈希表最多不会存放超过字符集大小的键值对，我们设字符集大小为 C ，则渐进空间复杂度为 O(C)。
 */
public class LC_76_最小覆盖子串 {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();//t中字符出现次数
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();//滑动窗口中字符出现次数

    public String minWindow(String s, String t) {
        int tLen = t.length();
        //维护t中元素的哈希表
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        //两指针作为在s上的窗口边界
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {//字符也存在于t中,该条件可以不要，加上可以节省cnt的空间
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                //每次遇到可行的窗口，若窗口长度比之前更小，就维护左右下标，作为最后结果
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;//substring左闭右开，所以l+len
                }
                if (ori.containsKey(s.charAt(l))) {//左指针要右移，则动态哈希表中次数减一
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);//没有【可行的窗口】，则返回空字符串
    }

    /**
     * 动态维护的cnt中包含所有的t中字符，并且出现次数也相同，则返回true
     *
     * 如何判断当前的窗口包含所有 t 所需的字符呢？我们可以用一个哈希表表示 t 中所有的字符以及它们的个数，
     * 用一个哈希表动态维护窗口中所有的字符以及它们的个数，如果这个动态表中包含 t 的哈希表中的所有字符，
     * 并且对应的个数都不小于 t 的哈希表中各个字符的个数，那么当前的窗口是「可行」的。
     * @return
     */
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
