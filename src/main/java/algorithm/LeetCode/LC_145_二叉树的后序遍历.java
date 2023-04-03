package algorithm.LeetCode;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
方法一：dfs，非递归实现

为什么能想到用两个栈实现后序遍历而不是一个栈？
    使用两个栈可以实现后序遍历的非递归算法，而使用一个栈不太容易实现，因为后序遍历是左右根的顺序，
    而在使用一个栈的情况下，我们不能先遍历右子树再遍历左子树，因为这样的话根节点会被遍历两次。
----------------------------------------
1.创建两个栈：栈1用来存放节点，栈2用来存放已经处理过的节点。
2.将根节点入栈1。
3.从栈1中弹出一个节点，将该节点的值入栈2。
4.将该节点的左子节点和右子节点（如果存在的话）依次入栈1。
5.重复步骤3和4，直到栈1为空。
6.弹出栈2中的节点即为后序遍历的结果。
--------------------------------
时间复杂度：O(N)
空间复杂度：O(N)
* */
public class LC_145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }

}
