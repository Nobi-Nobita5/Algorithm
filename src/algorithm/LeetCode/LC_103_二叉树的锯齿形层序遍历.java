package algorithm.LeetCode;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 *
 * -----------------------------------------
 * 方法一：广度优先遍历（双栈），还可以用双端队列实现
 *
 * “之”字型打印二叉树，即先从左往右，后从右往左；
 * 思路：
 * 用两个栈实现；
 * 1.根节点先入栈1，随后根节点出栈加入数组（栈1中所有节点出栈、加入数组），每个节点的子节点以“先左后右”的顺序进入栈2；
 * 2.栈2所有节点出栈、加入数组，每个节点的子节点以“先右后左”的顺序进入栈1；
 * 3.循环直至两个栈为空
 */
public class LC_103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list;
        if(root == null) return res;
        Stack<TreeNode> tmp = new Stack<>();
        Stack<TreeNode> tmp1 = new Stack<>();
        tmp.add(root);
        while(tmp.size() > 0 || tmp1.size() > 0) {
            list = new ArrayList<>();//每次新建
            //（栈1中所有节点出栈、加入数组），每个节点的子节点以“先左后右”的顺序进入栈2；
            if(tmp.size() > 0) {
                int size = tmp.size();
                for(int i=0; i<size; i++) {
                    TreeNode pop = tmp.pop();
                    list.add(pop.val);
                    if(pop.left != null) {
                        tmp1.add(pop.left);
                    }
                    if(pop.right != null) {
                        tmp1.add(pop.right);
                    }
                }
                res.add(list);
                continue;//必须直接进行下一次循环，因为list要重新创建
            }
            //栈2所有节点出栈、加入数组，每个节点的子节点以“先右后左”的顺序进入栈1；
            if(tmp1.size() > 0) {
                int size = tmp1.size();
                for(int i=0; i<size; i++) {
                    TreeNode pop = tmp1.pop();
                    list.add(pop.val);
                    if(pop.right != null) {
                        tmp.add(pop.right);
                    }
                    if(pop.left != null) {
                        tmp.add(pop.left);
                    }
                }
                res.add(list);
            }
        }
        return res;
    }
}
