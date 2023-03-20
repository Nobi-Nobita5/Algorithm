package algorithm.LeetCode;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 * --------------------------------------------
 * 方法一：广度优先搜索
 * 思路：
 * 广度优先搜索，用队列实现：
 * 1.根(父)节点先入队列；
 * 2.根(父)节点出队列，加入数组；
 * 3.每一个父节点出队列，其左右子节点就要加入队列
 * 注：由于需要把当前层节点放在一个集合中，所以当前层有几个父节点，就要操作几次（父节点出队列，左右子节点入队列算一次操作）
 *
 * ---------------------------------------------
 * 时间复杂度：O(n),n是二叉树的节点个数。每个节点只会访问一次。
 * 空间复杂度：O(n),n是二叉树的节点个数。队列的开销。
 *
 */


import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LC_102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();//结果集
        List<Integer> list;//存放每层的父节点
        Deque<TreeNode> queue = new LinkedList<>();//队列实现广度优先遍历
        if (root==null) return res;
        queue.offer(root);//根节点先入队列
        while (!queue.isEmpty()){
            list = new ArrayList<>();
            //由于需要把当前层节点放在一个集合中，所以当前层有几个父节点，就要操作几次（父节点出队列，左右子节点入队列算一次操作）
            //改造BFS，固定queue.size()，用一个for循环实现层序遍历。
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    list.add(poll.val);
                }
                //每一个父节点出队列，其左右子节点就要加入队列
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            //for循环结束，遍历完一层后，将list加入结果集合
            res.add(list);
        }
        return res;
    }
}
