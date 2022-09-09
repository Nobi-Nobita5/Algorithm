package algorithm.JianZhiOffer;
/*

写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

思路：用异或可以代替加法，比如0010^0001=0011，但是进位问题不能解决，比如01^01=00，但01+01 = 10；
    所以我们用逻辑与运算&，与运算再向左位移一个单位<<1，得到进位，01&01=01，01<<1=10

    然后再把他们相加

    即循环上面的异或和逻辑与两步过程，直到进位为0。
 */
public class Q48 {
    public int Add(int num1,int num2) {
        int res = 0;
        int carry = 0;
        do{
            res = num1 ^ num2;//先异或
            carry = (num1&num2)<<1;//再与运算求进位，循环该操作
            num1 = res;
            num2 = carry;
        }while (carry!=0);
        return res;
    }
}
