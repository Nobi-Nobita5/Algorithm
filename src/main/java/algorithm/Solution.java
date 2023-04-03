package algorithm;

import java.io.IOException;
import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()){
            while (curr.left != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            res.add(curr.val);
            while (curr.right != null){
                stack.push(curr.right);
                curr = curr.right;
            }
        }

        return res;
    }
}
