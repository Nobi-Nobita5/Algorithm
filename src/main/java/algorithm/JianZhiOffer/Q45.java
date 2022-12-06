package algorithm.JianZhiOffer;

import java.util.TreeSet;
/*
可以这么理解，简单来说就是要是5个数字，
最大和最小差值小于5，并且没有重复数值。

方法：
用一个set来填充数据，0不要放进去。
set的大小加上0的个数必须为5个。
此外set中数值差值在5以内。
 */
public class Q45 {
    public boolean IsContinuous(int [] numbers) {
        //set集合会自动去重，自动排序。另只能通过遍历迭代等访问集合内元素
        //TreeSet可以使用first（）last（）方法访问头尾元素
        TreeSet<Integer> set = new TreeSet<Integer>();
        int num = 0;
        //把抽到的牌除了大小王（0）都放进去
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==0){
                num++;
            }else {
                set.add(numbers[i]);
            }
        }
        //首先set.size（）加上0的个数一定要等于5
        if ((set.size()+num)!=5) return false;
        //set自动排序，判断set中最大差值是否在5以内
        if (set.last()-set.first()>=5) return false;
        return true;
    }
}
