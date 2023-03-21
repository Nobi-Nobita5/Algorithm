package algorithm.LeetCode;

import java.util.*;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 *
 *  
 * 示例 1：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *  
 *
 * 提示：
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 *
 * --------------------------------------------------------
 * 无向图中两个顶点之间的最短路径的长度，可以通过广度优先遍历得到；
 * 为什么 BFS 得到的路径最短？可以把起点和终点所在的路径拉直来看，两点之间线段最短；
 * 思路：bfs+优化建图
 *
 * 建图方法：尝试对 currentWord 修改每一个字符，改变后的字符串包含在wordSet，该字符串就是currentWord的邻居
 *
 * 时间复杂度：
 * 设单词长度为wordLen，单词列表长度为N；
 *  遍历的时候构建图，每一次得到在单词列表里可以转换的所有单词，复杂度是 O(26×wordLen)；
 *  Bfs寻找最短路径的最坏情况是O（26×wordLen*N），即遍历了图的每个单词。
 */
public class LC_127_单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size()==0 || !wordSet.contains(endWord)) return 0;
        //删除beginWord，方便第一次beginWord与wordSet元素的比较，不删会出问题
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()){
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则直接返回 step + 1
                if (changeWordEveryOneLetter(currentWord,endWord,queue,visited,wordSet)){
                    return step+1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配,
     * 能匹配说明下一次bfs就能遍历到endWord，返回true
     *
     * 1.如果一开始就构建图，每一个单词都需要和除它以外的另外的单词进行比较(从而构建邻接表)，时间复杂度是 O(N×wordLen)，这里 N 是单词列表的长度；
     *   为此，我们一开始把所有的单词列表放进一个哈希表中，然后在遍历的时候构建图，每一次得到在单词列表里可以转换的所有单词，时间复杂度是 O(26×wordLen)，
     *   【借助哈希表，找到邻居与 N 无关】；
     * 2.使用 BFS 进行遍历，需要的辅助数据结构是：
     *   1)队列；
     *   2)visited 集合。说明：可以直接在 wordSet (由 wordList 放进集合中得到)里做删除。但更好的做法是新开一个哈希表，遍历过的字符串放进哈希表里。
     *                         这种做法具有普遍意义。绝大多数在线测评系统和应用场景都不会在意空间开销。
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray  = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存当前字符串的第i个字符，然后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (originChar == k) continue;//要改变charArray[i]，那么跟它相等的字符就跳过
                charArray[i] = k;
                //看看当前字符串是不是能与 endWord 匹配
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)){//改变后的字符串包含在wordSet，该字符串就是currentWord的邻居
                    if (nextWord.equals(endWord)){
                        return true;
                    }
                    //该邻居不是endWord则标记已访问
                    if (!visited.contains(nextWord)){
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }
}
