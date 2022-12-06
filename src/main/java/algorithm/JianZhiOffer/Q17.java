package algorithm.JianZhiOffer;

public class Q17 {
    /*
    要么两个树完全相同，要么A树的左子树跟B树相同，要么A树的右子树跟B树相同
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null||root2==null) return false;//规定的B树为空树的话，其不是任何树的子树
        return dfs(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }



    /*
    判断两个树是否完全相同的dfs
     */
    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root2==null) return true;
        if (root1==null) return false;
        return root1.val == root2.val && dfs(root1.left,root2.left) &&dfs(root1.right,root2.right);
    }
}
