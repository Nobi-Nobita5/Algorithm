package algorithm.JianZhiOffer;
//判断一个序列是不是某个二叉搜索树的后序遍历序列
//递归求解
//二叉搜索树的左子树都比根节点小，右子树都比根节点大
//所以数组中start到end-1的元素只能存在
//1.比end小的一串元素和比end大的一串元素；
//2.或比end小的一串元素
//3.或比end大的一串元素
public class Q23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0||sequence==null) return false;
        return solve(sequence,0,sequence.length-1);
    }

    private boolean solve(int[] sequence, int start, int end) {//strat和end作为递归关键参数
        if (start>=end) return true;
        int i = start;
        int j = end;
        while (sequence[i]<sequence[j]){
            i++;
        }
        int mid = i;
        while (sequence[i]>sequence[j]){
            i++;
        }
        while (sequence[i]<sequence[j]){
            return false;
        }
        return solve(sequence,start,mid-1)&&solve(sequence,mid,end-1);
    }
}
