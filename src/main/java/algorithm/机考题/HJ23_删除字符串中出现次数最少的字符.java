package algorithm.机考题;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 保证输入的字符串中仅出现小写字母
 *
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 */
public class HJ23_删除字符串中出现次数最少的字符 {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            char[] chars = s.toCharArray();
            //统计每个字母的数量
            HashMap<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                map.put(aChar, (map.getOrDefault(aChar, 0) + 1));
            }

            //找到出现次数最少的字符,map.values(),Collections.min()
            Collection<Integer> values = map.values();
            Integer min = Collections.min(values);

            //用空格批量替换该字符,map.keySet(),s = s.replaceAll()
            for (Character ch:
                    map.keySet()) {
                if (map.get(ch) == min) s = s.replaceAll(String.valueOf(ch),"");
            }
            System.out.println(s);
        }
    }
}
