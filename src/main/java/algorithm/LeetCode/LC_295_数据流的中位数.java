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
 * 我们要保证：大根堆存放较小数据，小根堆存放较大数据。
 *
 * 添加一个整数到设计好的数据结构中时：
 * 1.两个堆的size相等时（包括大小都为0），我们向大顶堆中添加元素。
 * 2.当大顶堆的size大于小顶堆的size时，我们向小顶堆中添加元素。
 * 注：这种做法，不会出现大顶堆的size 小于 小顶堆的size。
 *    TODO 向堆1中添加元素前，我们都要先向堆2中添加元素，将堆2经过排序后的堆顶元素弹出，再添加进堆1。
 *
 * 返回值：
 * 1. 如果执行完添加操作之后，两个堆size不相等，直接返回大顶堆的堆顶元素，必然是中位数。
 *    这是因为在对小顶堆执行完添加操作后，小顶堆自动升序排序，弹出堆顶元素到大顶堆，大顶堆自动降序排序。
 *    TODO 经过这两次堆排序操作之后，大顶堆弹出的【较小数据组的最大元素】，必然是两个堆包含的数据流的中位数。
 * 2. 如果执行完添加操作之后，两个堆size相等，直接返回【(minQueue.peek() + MaxQueue.peek()) / 2.0】即可。
 * --------------------------------
 * 时间复杂度：O(logn),n是数据流的长度。（本题只需要添加一个元素到设计好的数据结构中，所以是O(logn)）
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
        minQueue = new PriorityQueue<Integer>();//默认即是升序，小顶堆。
    }

    public void addNum(int num) {
        if(minQueue.size() == MaxQueue.size()){//两堆size都为0，size相等，则存放到大根堆（较小数据组）
            //要保证大根堆中的数据都是较小的数，那就先进入小根堆，然后poll()出小根堆中最小的数，放入大根堆
            minQueue.add(num);
            MaxQueue.add(minQueue.poll());
        }else {//size不相等，则存放到小根堆(较大数据组)
            // 要保证小根堆中的数据都是较大的数，那就先进入大根堆，然后poll()出大根堆中最大的数，放入小根堆
            MaxQueue.add(num);
            minQueue.add(MaxQueue.poll());
        }
    }

    public double findMedian() {
        if (MaxQueue.size() == minQueue.size()){
            return (minQueue.peek() + MaxQueue.peek()) / 2.0;
        }else {
            return MaxQueue.peek();//size不相等，直接返回大根堆顶数
        }
    }
}
