package algorithm.LeetCode;

import algorithm.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 方法一：dfs，递归实现
 * */
public class LC_144二叉树的前序遍历 {
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

/**
 * 方法一：dfs，非递归实现
 * 思路：
 * 1.如果根节点为空，返回空链表
 * 2.初始化一个栈，将根节点压入栈中
 * 3.循环直到栈为空：
 *      1.弹出栈顶元素，并将其加入结果列表中
 *      2.如果该元素存在右子节点，将其压入栈中。
 *      3.如果该元素存在左子节点，将其压入栈中。
 *      注意：在前序遍历中，需要先访问根节点，再访问左子树和右子树，因此在入栈时需要先将右子节点压入栈中，再将左子节点压入栈中，以保证出栈顺序是先左后右。
 * 4.返回结果列表
 * */
class LC_144二叉树的前序遍历_方法二 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null){
                stack.push(pop.left);
            }
        }
        return res;
    }
}