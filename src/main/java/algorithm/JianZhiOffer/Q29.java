package algorithm.JianZhiOffer;

import java.util.ArrayList;

public class Q29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //注意不和题意的输入
        if(k>input.length) return list;
        //插入排序
        for(int i = 1;i<input.length;i++){
            //从当前元素依次循环遍历与前面所有有序的元素挨个比较，找到合适的插入位置交换位置
            for(int j = i;j>0;j--){
                //如果后一个数比前面任何一个数小则交换，一直交换到合适的位置(这里是升序排序)
                //如果想要降序排序，则修改v为>即可
                if(input[j]<input[j-1]){
                    int t = input[j];
                    input[j]=input[j-1];
                    input[j-1] = t;
                }
            }
        }
        for(int i = 0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
}
