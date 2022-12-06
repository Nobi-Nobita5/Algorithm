package algorithm.JianZhiOffer;

public class Q58 {
    //对称的二叉树
    /*
    题目说如果二叉树的镜像跟他相同，那就是对称的；
    那我们就写一个递归函数，搞两个该二叉树作为参数，判断B是不是A的镜像就好了。
    注：如果递归函数只有一个参数，不好让L->left->val == R->right->val
                                    L->right->val == R->left->val
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)return true;
        return solve(pRoot,pRoot);
    }

    private boolean solve(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot==null&&pRoot1==null) return true;
        if (pRoot==null||pRoot1==null) return false;
        return pRoot.val==pRoot1.val&&solve(pRoot.left,pRoot1.right)&&solve(pRoot.right,pRoot1.left);
    }
}
