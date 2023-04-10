package sort;

public class Sort4_选择排序 {
    public void sort(int[] a){
        for (int i = 0; i <a.length-1; i++) {
            int min = i;
            for(int j = i+1;j<a.length;j++){
                if (a[j]<a[min]){
                    int t = a[j];
                    a[j] = a[min];
                    a[min] = t;
                }
            }
        }
    }
}
