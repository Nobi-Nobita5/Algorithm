package algorithm.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * --------------------------------
 * 方法一：标准做法，双堆求中位数
 */
public class LC_295_数据流的中位数 {

    private PriorityQueue<Integer> MaxQueue;//大根堆存放较小数据
    private PriorityQueue<Integer> minQueue;//小根堆存放较大数据
    public LC_295_数据流的中位数() {
        MaxQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minQueue = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(minQueue.size() == MaxQueue.size()){//size相等，则存放到大根堆（较小数据组）,用于分界
            //要保证大根堆中的数据都是较小的数，那就先进入小根堆，然后poll()出小根堆中最小的数，放入大根堆
            minQueue.add(num);
            MaxQueue.add(minQueue.poll());
        }else {//size不相等，则存放到小根堆(较大数据组),用于分界
            // 要保证小根堆中的数据都是较大的数，那就先进入大根堆，然后poll()出大根堆中最大的数，放入小根堆
            MaxQueue.add(num);
            minQueue.add(MaxQueue.poll());
        }
    }

    public double findMedian() {
        if (MaxQueue.size() == minQueue.size()){
            return (minQueue.peek() + MaxQueue.peek()) / 2.0;
        }else {
            return MaxQueue.peek();//奇数个，直接返回大根堆顶数，因为一开始是往大根堆插入数据的。大根堆存放较小数据
        }
    }
}
