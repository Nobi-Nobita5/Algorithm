package algorithm.LeetCode;

import java.util.*;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 *
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *  
 *
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 * ------------------------------------------------------
 * 本题是经典的拓扑排序：拓扑排序（Topological Sorting）是一种对有向无环图（DAG）进行排序的算法。
 * 拓扑排序：
 * 1.构建图(邻接表方式),数组indeg表示每个节点的入度
 * 2.先将入度为0的节点入队列
 * 3.再遍历他们的邻接表中节点（BFS），并将这些节点入度-1，若-1后入度为0，则可以加入队列
 * 4.若最后结果集res中节点数等于图中元素个数，则返回res。不等于则证明存在环，无解。
 *
 * 注：
 * 有向无环图使用ArrayList<List<Integer>>()作为辅助数据结构，没有用HashMap+List，因为ArrayList的下标就可以标识课程（0 到 numCourses - 1）。
 *
 * -------------------------------------------------------
 * 时间复杂度：O(m+n)，m是课程数，n为先修课程的要求数。
 * 空间复杂度：O(m+n)，m是课程数，n为先修课程的要求数。储存成邻接表的形式。我们还需要若干个O(m)储存节点的入度和最终答案等。故O(m+n)。
 */
public class LC_210_课程表II {
    //存储有向图
    List<List<Integer>> dag;
    //储存每个节点的入度
    int[] indeg;
    //存储答案
    int[] res;
    //答案下标
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        dag = new ArrayList<List<Integer>>();
        //创建numCourses个集合，每个集合存放一个课程的后继课程，集合顺序按照课程顺序排列
        for (int i = 0; i < numCourses; i++) {
            dag.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        res = new int[numCourses];
        index = 0;
        //遍历二维数组中每个一维数组，在第dag.get(info[1])个集合中添加该课程的后继课程info[0]
        //第dag.get(info[1])个集合在dag中的下标刚好也是课程编号，所以可以直接使用上述方法构建邻接表
        //这一步完成后，每个课程的入度会在indeg[]中统计完成
        for (int[] info :
                prerequisites) {
            dag.get(info[1]).add(info[0]);
            ++indeg[info[0]];//课程info[0]的入度+1
        }
        //把入度为0的课程i先加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            //从队首取出一个节点
            Integer poll = queue.poll();
            //放入答案中
            res[index++] = poll;
            //Bfs搜索该节点的邻居(后继)节点,其实就是遍历List<Integer> list = dag.get(poll)这个集合。
            //搜索邻居(后继)节点的顺序任意，所以可以使用foreach
            for (int v:dag.get(poll)) {
                //邻居节点（课程v）入度减一
                indeg[v]--;
                //减一之后如果入度为0，则加入队列
                if (indeg[v]==0) queue.offer(v);
                //TODO 拓扑排序不需要标记已访问，因为如果入度减1还有1，那么下次还是需要访问该节点，将其入度-1。
            }
        }
        if (index!=numCourses) return new int[0];//index!=numCourses证明始终不能将剩余课程的入度变为0，从而加入队列，放入res集合。即有向图存在环，无解。
        return res;
    }
}
