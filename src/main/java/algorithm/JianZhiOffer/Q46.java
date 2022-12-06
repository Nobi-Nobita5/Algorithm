package algorithm.JianZhiOffer;

import java.util.ArrayList;

public class Q46 {
    public int LastRemaining_Solution(int n, int m) {
        if (n<=0||m<=0) return -1;//没有小朋友或者报数小于等于0，返回-1
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);//把小朋友的编号从0到n-1存储
        }
        int cur = -1;
        while (list.size()>1) {//保存list第一个编号，即为所求
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur == list.size()) cur = 0;//如果报的数等于list.size()则将cur指针置为0
            }
            list.remove(cur);//报数结束，删除这个小朋友
            cur--;//cur指针--的原因：list.remove()之后cur指向下一个元素，由于进入for循环cur++,所以要--。
        }
        return list.get(0);
    }
}
