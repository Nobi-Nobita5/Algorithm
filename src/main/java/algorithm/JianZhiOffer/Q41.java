package algorithm.JianZhiOffer;

import java.util.ArrayList;

public class Q41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int p1=1,p2=2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum <= 1) return res;

        while(p1 != sum/2+1){//p1不能大于等于中间值
            int tmp  = (p1+p2)*(p2-p1+1)/2; // 求和公式
            if(tmp == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=p1;i<=p2;i++) list.add(i);
                res.add(list);
                p2++;
            }else if(tmp < sum){
                p2++;//小了就加一个右边的数
            }else {
                p1++;//大了就减一个左边的数
            }
        }
        return res;
    }
}
