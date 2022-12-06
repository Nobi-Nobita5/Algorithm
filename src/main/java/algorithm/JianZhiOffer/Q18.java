package algorithm.JianZhiOffer;

public class Q18 {
    //二叉树的镜像
    /*
    每个节点的左子节点变为右子节点，右子节点变为左子节点
    那么用递归实现深度遍历二叉树就可以了
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot==null) return null;
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
