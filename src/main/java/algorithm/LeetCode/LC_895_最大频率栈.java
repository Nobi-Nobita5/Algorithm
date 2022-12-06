package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 设计一个类似堆栈的数据结构，将元素推入堆栈(栈)，并从堆栈中弹出出现频率最高的元素。
 *
 * 实现 FreqStack 类:
 *
 * FreqStack() 构造一个空的堆栈。
 * void push(int val) 将一个整数 val 压入栈顶。
 * int pop() 删除并返回堆栈中出现频率最高的元素。
 * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * FreqStack = new FreqStack();
 * freqStack.push (5);//堆栈为 [5]
 * freqStack.push (7);//堆栈是 [5,7]
 * freqStack.push (5);//堆栈是 [5,7,5]
 * freqStack.push (7);//堆栈是 [5,7,5,7]
 * freqStack.push (4);//堆栈是 [5,7,5,7,4]
 * freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
 * freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
 * freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
 *  
 *
 * 提示：
 *
 * 0 <= val <= 109
 * push 和 pop 的操作数不大于 2 * 104。
 * 输入保证在调用 pop 之前堆栈中至少有一个元素。
 *
 * --------------------------------------------------------------
 * 思路：HashMap+栈
 * push()方法时：
 *      HashMap<Integer,Integer> numFreqMap用于存储元素的频率。并动态维护当前最高频率maxFreq；
 *      HashMap<Integer,Stack<Integer>> freqStkMap存储当前频率的所有元素。
 * pop()方法时：
 *      返回值是最高频率对应的栈顶元素,从Map<Integer,Stack<Integer>> freqStkMap中获得；
 *      如果栈顶元素出栈后，当前最高频率的栈为空, 说明最高频率需要更新 (更新为最高频率maxFreq减去1)
 * 多敲两遍
 */
public class LC_895_最大频率栈 {
    Map<Integer,Stack<Integer>> freqStkMap;
    Map<Integer,Integer> numFreqMap;
    int maxFreq;
    public LC_895_最大频率栈() {
        freqStkMap = new HashMap<>();// <K, V>: 每个频率 K 对应有一个栈 V，栈 V 中存放所有频率为 K 的数字
        numFreqMap = new HashMap<>();// <K, V>: 数字 K 的出现频率为 V
        maxFreq = 0;// 记录当前最高频率
    }

    public void push(int val) {
        // 记录数字出现的频率, 并更新当前最高频率的值
        int currFreq = numFreqMap.getOrDefault(val, 0) + 1;
        numFreqMap.put(val, currFreq);
        if (currFreq > maxFreq) {
            maxFreq = currFreq;
        }
        // 按频率不同, 建立栈. 存入出现过该频率的数字
        freqStkMap.putIfAbsent(currFreq, new Stack<>());//putIfAbsent缺席key则存入
        freqStkMap.get(currFreq).push(val);
    }

    public int pop() {
        // 找到并移除当前频率最高的数字
        int maxFreqNum = freqStkMap.get(maxFreq).pop();
        // 将该数字的频率减去 1
        numFreqMap.put(maxFreqNum, numFreqMap.get(maxFreqNum) - 1);
        // 如果当前最高频率的栈为空, 说明最高频率需要更新 (更新为最高频率maxFreq减去1)
        if (freqStkMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return maxFreqNum;
    }
}