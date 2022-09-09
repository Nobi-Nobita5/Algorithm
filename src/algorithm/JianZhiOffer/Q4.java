package algorithm.JianZhiOffer;
//重建二叉树
public class Q4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre.length==0||in.length==0){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (in[i]==pre[0]){
                int str1[] = new int[i];
                int str2[] = new int[i];
                System.arraycopy(pre,1,str1,0,i);//最后一个参数是长度
                System.arraycopy(in,0,str2,0,i);
                treeNode.left = reConstructBinaryTree(str1,str2);
                int str3[] = new int[pre.length-i-1];
                int str4[] = new int[in.length-i-1];
                System.arraycopy(pre,i+1,str3,0,pre.length-i-1);
                System.arraycopy(in,i+1,str4,0,in.length-i-1);
                treeNode.right = reConstructBinaryTree(str3,str4);
                break;
            }
        }

        return treeNode;
    }
}
