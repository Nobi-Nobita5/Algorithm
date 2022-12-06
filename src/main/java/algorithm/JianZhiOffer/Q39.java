package algorithm.JianZhiOffer;

public class Q39 {
    /*
    //判断是否为平衡二叉树（为空树，或左右子树的高度差绝对值不超过1）
    //所以要计算子树的高度
    public boolean IsBalanced_Solution(SuanFa.TreeNode root) {
        return solve(root)!=-1;
    }

    private int solve(SuanFa.TreeNode root) {//定义以每个节点为根的树的高度的函数
        if (root==null) return 0;//直到某个节点为空则已经计算出了高度，在此算法中说明过程未出现不满足平衡二叉树的情况
        int left = solve(root.left);
        if (left==-1) return -1;
        int right = solve(root.right);
        if (right==-1) return -1;
        if (Math.abs(left-right)>1){
            return -1;
        }
        else return 1+Math.max(left,right);
    }
     */


    //判断是否为平衡二叉树（为空树，或左右子树的高度差绝对值不超过1）
    //所以要计算子树的高度,而且二叉树的左右两个子树都是一棵平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null) return true;
        return Math.abs(solve(root.left)-solve(root.right))<=1&&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

    private int solve(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(solve(root.left),solve(root.right));
    }

}
