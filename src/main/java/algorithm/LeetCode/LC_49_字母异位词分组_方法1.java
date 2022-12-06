package algorithm.LeetCode;

import java.util.*;

/**
 * @Author: Xionghx
 * @Date: 2022/08/31/17:42
 * @Version: 1.0
 */
/*
*
* 注：HashMap不允许key的【hashcode和值】都相同，即hashmap插入一条相同的key的数据，会覆盖原来的数据。

* 思路肯定是将结果存入Map<String,List<String>> map 中，key是一组字母异位词的标志，最后返回map.values即可。

* key是排序后的标识，通过23、24行可以帮str找到key相同的组织list，再通过map.put(key,list)覆盖之前的键值对。

* 时间复杂度O(n * nlogn)
* */
public class LC_49_字母异位词分组_方法1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //HashMap不允许key的hashcode和value值都相同
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);//O(nlogn)
            String key = new String(array);
            //getOrDefault：map中key对应的值不存在则提供默认值，存在则取key对应的value
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
