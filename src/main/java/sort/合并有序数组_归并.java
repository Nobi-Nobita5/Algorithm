package sort;

import java.util.Arrays;

public class 合并有序数组_归并 {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        merge(A,3,B,3);
        System.out.println(Arrays.toString(A));
    }
    public static void merge(int[] A, int m, int[] B, int n) {
        // 先将A右移到末尾
        System.arraycopy(A, 0, A, n, m);

        int indexA = A.length-m;
        int indexB = 0;
        int i = 0;
        while (indexA<=A.length-1 && indexB<=B.length-1){
            if(A[indexA]<=B[indexB]){
                A[i] = A[indexA];
                i++;
                indexA++;
            }else {
                A[i] = B[indexB];
                i++;
                indexB++;
            }
        }
        while (indexA<=A.length-1){
            A[i] = A[indexA];
            i++;
            indexA++;
        }
        while (indexB<=B.length-1){
            A[i] = B[indexB];
            i++;
            indexB++;
        }
    }
}
