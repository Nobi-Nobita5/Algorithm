import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
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
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });

        for (int i = 0; i < counts.length; i++) {
            queue.offer((char)('a' + i));
        }

        StringBuffer sb = new StringBuffer();
        /*
         * 将大顶堆 堆顶的两个元素弹出，并加入sb，对应字母的出现次数减1。
         * 若对应字母的出现次数仍 大于 0，继续向大顶堆中offer该元素，大顶堆会自动排序。
         *
         * 无论排序后的大顶堆 堆顶元素 是什么，都可以循环上述操作，实现重构字符串使得两相邻的字符不同的目的。
         * */
        while (queue.size() > 1){
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            counts[letter1 - 'a']--;
            counts[letter2 - 'a']--;
            if (counts[letter1 - 'a'] > 0){
                queue.offer(letter1);
            }
            if (counts[letter2 - 'a'] > 0){
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
