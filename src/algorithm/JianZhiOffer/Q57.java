package algorithm.JianZhiOffer;
/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
//如果有右子树，打印右子树的最左节点
//如果没有右子树，且是父节点的左节点，打印父节点
//如果没有右子树，且是父节点的左节点，则一直向上找，直到上级是上上级的左孩子，打印上上级
public class Q57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)return null;//异常判断
        if(pNode.right != null){//如果节点有右分支
            TreeLinkNode p = pNode.right;
            while(p.left != null)p = p.left;
            return p;
        }else{
            TreeLinkNode parent = pNode.next;
            if(parent==null || parent.left == pNode)return parent;//如果节点无右子树，但是是其父节点的左子树或者父节点为空
            else{
                TreeLinkNode  pparent = parent.next;//如果节点无右子树，但是是其父节点的右子树
                while(pparent != null && pparent.left != parent){
                    parent = pparent;
                    pparent = pparent.next;
                }
                return pparent;
            }
        }

    }
}
