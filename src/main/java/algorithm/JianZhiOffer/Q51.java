package algorithm.JianZhiOffer;

import java.util.Arrays;

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class Q51 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = multiply(a);
        System.out.println(Arrays.toString(b));
    }
    public static int[] multiply(int[] A) {
        int m = A.length;
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <m; j++) {
                if (j==i){
                    continue;
                }else b[i] = b[i]*A[j];
            }
        }
        return b;
    }
}
