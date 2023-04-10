package sort;

public class Sort5_希尔排序 {
    public static void sort(int[] a) {
        int h= 1;
        while(h<a.length/2){
            h=h*2+1;
        }
        while (h>=1){
            //找到待插入的值
            for (int i = h; i <a.length ; i++) {
                //a[i]就是待插入的元素
                // 把a[i]插入到a[i-h],a[i-2h],a[i-3h]...序列中
                for (int j =i;j>=h;j-=h){//a[j]就是待插入元素，依次和a[j-h],a[j-2h],a[j-3h]进行比较，如果a[j]小，那么 交换位置，如果不小于，a[j]大，则插入完成。
                    if (a[j-h]>a[j]){
                        int t = a[j-h];
                        a[j-h] = a[j];
                        a[j] = t;
                    }else {
                        break;
                    }
                }
            }
            h=h/2;
        }
    }
}
