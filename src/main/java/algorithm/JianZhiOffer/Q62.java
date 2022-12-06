package algorithm.JianZhiOffer;

public class Q62 {
    /*
    private SuanFa.TreeNode target = null;
    private int k1 = 0;
    SuanFa.TreeNode KthNode(SuanFa.TreeNode pRoot, int k)
    {
        k1 = k;
        getKthNode(pRoot);
        return target;
    }

    private void getKthNode(SuanFa.TreeNode pRoot){
        if(pRoot == null || k1 <= 0){
            return;
        }
        getKthNode(pRoot.left);
        k1--;
        if(k1 == 0){
            target = pRoot;
            return;
        }
        getKthNode(pRoot.right);
    }
     */
    int index = 0;//定义index，不能直接用k，递归传递参数问题
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot!=null&&k>0) {

            TreeNode node1 = KthNode(pRoot.left, k);
            if (node1!= null) return node1;//将节点回溯,本题依据题意，只要index!=k，
                                            // 结点为空或不为空都需要向上回溯，继续统计index。
            index++;
            if (k == index) {
                return pRoot;//剪枝
            }
            TreeNode node2 = KthNode(pRoot.right, k);
            if (node2!= null) return node2;//将节点回溯
        }
        return null;
    }
}
