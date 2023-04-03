package algorithm.LeetCode;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 方法一：dfs，递归实现
 * */
public class LC_94_二叉树的中序遍历 {
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}

/**
 * 方法二：dfs，非递归实现
 * 思路：
 * 1.新建一个空栈。
 * 2.由于中序遍历得先访问左子树，所以我们得新建一个指针curr。
 * 3.不断将'左子树节点'入栈，直到curr指针为空。
 * 4.此时栈中都是'左子树节点'，我们再弹出栈顶元素，并加入结果列表中。然后再将指针cur指向弹出的节点的右子树。
 * 5.重复2～4，直至栈为空 且 指针curr为空。
 * */
class LC_94_二叉树的中序遍历_方法二 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {//指针curr不为空 或 栈不为空时，都要继续循环
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //stack中已经保存了'左子树节点'，这块利用了栈，实现当curr指针为空时，回溯到curr上一个节点。
            cur = stack.pop();
            res.add(cur.val);//此处可以保证，每次添加都是遵循 左->根->右
            cur = cur.right;
        }
        return res;
    }
}