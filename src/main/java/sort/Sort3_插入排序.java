package sort;

public class Sort3_插入排序 {
    public void sort(int[] a){
        for (int i = 1; i <a.length ; i++) {
            for(int j = i;j>0;j--){
                if (a[j-1]>a[j]){
                    int t = a[j-1];
                    a[j-1] = a[j];
                    a[j] =t;
                }else {
                    break;
                }
            }
        }
    }
}
