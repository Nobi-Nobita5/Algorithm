package algorithm.JianZhiOffer;

public class Q31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int m = i;//不能直接对i进行操作
            while (m>0){
                if (m%10==1) count++;
                m/=10;
            }
        }
        return count;
    }
}
