package algorithm.JianZhiOffer;

public class Q32 {
    public String PrintMinNumber(int [] numbers) {
        //每两个个元素之间都进行一次比较，怎么组合小就怎么排
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                int x = Integer.parseInt(numbers[i]+""+numbers[j]);
                int y = Integer.parseInt(numbers[j]+""+numbers[i]);
                if (y<x){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
                //操作之后数组就变成最小排列的数组了
            }
        }
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str +=numbers[i];
        }
        return str;
    }
}
