package algorithm.LeetCode;

import java.util.*;

/**
 * @Author: Xionghx
 * @Date: 2022/09/05/15:40
 * @Version: 1.0
 */

/*方法二：用一个new int[26]数组记录每个字符出现次数，将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
* 时间复杂度O(n*m),n为strs数组元素个数，m为strs中元素的平均长度
* */
public class LC_49_字母异位词分组_方法2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i]!=0){
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();//为了使数组strs中的同一类字符串的hashcode相同(因为new String("相同内容的字符串")产生对象的hashcode相同)
            //注：String重写了hashcode()方法，String的hash值是根据字符串的内容来决定的，并不是内存地址，只要两个String类型的字符串内容一致，那么两者的hashcode就相同。
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

}
