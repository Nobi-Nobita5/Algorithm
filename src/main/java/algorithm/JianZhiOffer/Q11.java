package algorithm.JianZhiOffer;

public class Q11 {
    public int NumberOf1(int n) {
        //1000...000在int范围中表示最小值-2147483648，二进制有1个1，但是算出来只有0个。这是一种不满足的情况
        //还有很多数据都不满足情况
//        int res = 0;
//        while (n!=0){
//            if (n%2==1){
//                res++;
//            }
//            n /=2;
//        }
//        return res;












        //直接将整数看成二进制，然后采用移位的方法。
        /*
        右移时：
            正数：高位补0；
            负数：高位补1；
        左移时：
            正数：低位补0；(最终会变为0)
            负数：低位补0；(最终会变为0)
        注：位运算有时会改变数字正负
         */
        int flag = 1;
        int res = 0;
        while (flag!=0){
            if ((flag & n)!=0){
                res ++;
            }
            flag<<=1;
        }
        return res;
    }
}
