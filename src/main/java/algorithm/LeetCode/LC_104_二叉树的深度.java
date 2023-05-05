package algorithm.LeetCode;

import algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * 
 * 提示：
 * 节点总数 <= 10000
 * ----------------------
 * 思路：
 * 如果我们知道了左子树和右子树的最大深度l和r，那么该二叉树的最大深度即为max(l,r)+1。
 * 而左子树和右子树的最大深度又可以以同样的方式进行计算。因此我们可以用「深度优先搜索」的方法来计算二叉树的最大深度。
 * 具体而言，在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，然后在O(1) 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出。
 * ----------------------
 * 时间复杂度：O(N),N为二叉树节点的个数。每个节点在递归中只被遍历一次。
 * 空间复杂度：O(height),height表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度。
 */
public class LC_104_二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int l = maxDepth(root.left);
        int r= maxDepth(root.right);
        return Math.max(l,r) + 1;//O(1) 时间计算当前二叉树的最大深度
    }
}

class LC_104_二叉树的深度_广度优先搜索 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            ans+=1;
        }
        return ans;
    }
}
