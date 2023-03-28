package algorithm.LeetCode;

import java.util.*;

/**
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] 由小写英文字母组成。
 * k 的取值范围是 [1, 不同 words[i] 的数量]
 *  
 *
 * 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * --------------------------------------------------------------
 * 思路: 小顶堆
 * 对于前 k 大或前 k 小这类问题，有一个通用的解法：优先队列。优先队列可以在 O(logn) 的时间内完成插入或删除元素的操作（其中 n 为优先队列的大小），并可以 O(1) 地查询优先队列顶端元素。
 *
 * 在本题中，我们用HashMap记录字符串及其出现次数，创建一个小根优先队列（顾名思义，就是优先队列顶端元素是最小元素的优先队列）。堆中存储的元素是HashMap的Entry<String,Integer>。
 * 我们将每一个Entry中的字符串根据其出现次数插入到优先队列中，如果优先队列的大小超过了 k，那么我们就将优先队列顶端元素弹出。这样最终优先队列中剩下的 k 个元素就是前 k 个出现次数最多的单词。
 *--------------------------------------
 * 时间复杂度：O(nlogk)，n个元素插入小顶堆，每次插入都是O(logk)。
 * 空间复杂度：O(n),n是字符串数组的长度。存放结果的链表，存放字符串及其频率的Hashmap，存放 k 个元素的小顶堆。
 */
public class LC_692_前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        for (String word :
                words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //优先队列中存放Map.Entry<String,Integer>
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                //1.需要注意的是：本题要求最终返回的字符串集合需要降序排序，而优先级队列最终输出的前 k 个高频单词是升序排序的(小顶堆是升序的)。
                //  所以我们需要在最后使用Collections.reverse()方法反转一下字符串集合LinkedList。
                //2.另外，我们在处理出现频率相同的不同单词时，题目要求这些不同单词需要按字典顺序升序输出，
                //  所以此处需要先按字典顺序降序处理，用到了java.lang.String.compareTo(),即entry2.getKey().compareTo(entry1.getKey()),。
                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String,Integer> entry:
                map.entrySet()) {
            queue.offer(entry);
            //队列size大于k，此时已经将k+1个元素维护在小根堆中；每次都poll()掉最小的，最后得到的就是最高频次的小根堆
            if (queue.size()>k)
                queue.poll();
        }
        while (!queue.isEmpty()){
            res.add(queue.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
