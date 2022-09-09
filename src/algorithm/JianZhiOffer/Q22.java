package algorithm.JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        } else return list;
        while (!queue.isEmpty()) {
            //循环使用newName将每个节点添加到queue中
            TreeNode newName = queue.poll();
            list.add(newName.val);
            if (newName.left != null) {
                queue.add(newName.left);
            }
            if (newName.right != null) {
                queue.add(newName.right);
            }
        }
        return list;
    }
}
