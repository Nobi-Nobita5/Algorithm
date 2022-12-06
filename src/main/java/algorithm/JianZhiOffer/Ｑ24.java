package algorithm.JianZhiOffer;

import java.util.ArrayList;

public class Ｑ24 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        dfs(root, target, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int target, ArrayList<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(list));//res.add(list)是不行的，因为list是一直在变的
        else {
            dfs(root.left, target, list);
            dfs(root.right, target, list);
        }
        list.remove(list.size() - 1);//res.add(new ArrayList<>(list))之后向上回溯找另外一条路径，要把当前节点删除
    }
}
