package algorithm.LeetCode;

import com.sun.org.apache.bcel.internal.generic.IFGE;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *  
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 *
 *
 *
 * 思路：
 * 要求时间复杂度小于O(nlogn)，
 * 可以用一个hashmap存储每个数字和数字出现的次数；
 * 再建立一个小顶堆（大顶堆不可行，见代码注释），实时更新出现频次最高的数字；
 * 最后依次出栈k个元素即可
 *
 */
public class LC_347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:
             nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
                //Java默认是升序优先级队列->小根堆，要实现大顶堆需重写成o2[1] - o1[1]
                //寻找最大频次的前k个数就用小顶堆，offer至堆元素大于k后，会不断poll出最小频次的元素。
                //寻找最小频次的前k个数就用大顶堆，offer至堆元素大于k后，会不断poll出最大频次的元素。
            }
        });
        for (Map.Entry<Integer,Integer> entry://Map.Entry<Integer,Integer> entry要指定类型
             map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (pq.size() >= k){
                pq.offer(new int[]{num,count});
                pq.poll();
            }else {
                pq.offer(new int[]{num,count});
            }
        }
        /**
         * 遍历map集合时，队列的操作还有一种写法：先比较当前元素和对顶元素（这种方法感觉有点多此一举，没必要比较）
         * for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {//Map.Entry<Integer,Integer> entry要指定类型
         *             int num = entry.getKey(), count = entry.getValue();
         *             if (queue.size() == k) {
         *                 if (queue.peek()[1] < count) {
         *                    //建立大顶堆：如果堆顶元素次数更小，说明目前的k个元素的次数不是频次最高的，弹出栈顶频次第二高的！！！不合适，故还是要建立小顶堆
         *                     //建立小顶堆：如果堆顶元素更大，说明已经有k个元素次数大于当前元素的次数，所以舍弃当前元素；当堆顶元素更小时，弹出栈顶元素，操作堆加入当前元素
         *                     queue.poll();
         *                     queue.offer(new int[]{num, count});
         *                 }
         *             } else {
         *                 queue.offer(new int[]{num, count});
         *             }
         *         }
         */
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
