package algorithm;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] a  = new int[128];//ASCLL值的范围为[0,128)
        System.out.println(Integer.parseInt(""));
    }

    Map<Character, Integer> ori = new HashMap<Character, Integer>();//t中字符出现次数
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();//滑动窗口中字符出现次数

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            ori.put(s.charAt(i),ori.getOrDefault(s.charAt(i),0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen){
            ++r;
            cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            while (check() && l <= r){
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
        return ansL == -1?"":s.substring(ansL,ansR);
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
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (cnt.getOrDefault(key,0) < value) return false;
        }
        return true;
    }
}
