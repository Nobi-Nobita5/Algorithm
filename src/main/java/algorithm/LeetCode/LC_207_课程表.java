package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *  
 *
 * 提示：
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 *
 * -------------------------------------------
 * 更改自leetcode210（模板题）
 * 本题是经典的拓扑排序：输出有向无环图的序列
 * 拓扑排序：
 * 1.构建图(邻接表方式)
 * 2.先将入度为0的节点入队列
 * 3.再遍历他们的邻接表中节点（BFS），并将这些节点入度-1，若-1后入度为0，则可以加入队列
 * 4.若最后结果集res中节点数等于图中元素个数，则返回res，不等于证明存在环，则无解。
 */
public class LC_207_课程表 {
    //存储有向图
    List<List<Integer>> edges;
    //储存每个节点的入度
    int[] indeg;
    //存储答案数量
    int index ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        //创建numCourses个集合，每个集合存放一个课程的后继课程，集合顺序按照课程顺序排列
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        index = 0;
        //遍历二维数组中每个一维数组，在第info[1]个集合中添加该课程的后继课程info[0]
        for (int[] info :
                prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];//课程info[0]的入度+1
        }
        //把入度为0的课程先加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            //从队首取出一个节点
            Integer poll = queue.poll();
            //答案元素数量+1
            index++;
            //遍历该节点的邻居(后继)节点
            for (int v:edges.get(poll)) {
                //邻居节点入度减一
                indeg[v]--;
                //减一之后如果入度为0，则加入队列
                if (indeg[v]==0) queue.offer(v);
                //这里不需要标记已访问，因为如果入度减1还有1，那么下次还是需要访问该节点，将其入度-1。
            }
        }
        return index == numCourses;//若index!=numCourses证明始终不能将剩余课程的入度变为0，从而加入队列，放入res集合。即有向图存在环，无解。
    }
}
