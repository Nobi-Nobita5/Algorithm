package sort;

/**
 * @Author: Xionghx
 * @Date: 2022/06/22/14:49
 * @Version: 1.0
 */
public class Sort2_归并排序 {
    private static int[] temp;
    public static void sort(int[] a){
        temp = new int[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a,lo,hi);
    }
    //归并的分、合在数组排序中的体现
    private static void sort(int[] a,int lo, int hi){
        if (hi<=lo){
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //对lo到mid这组数据和mid到hi这组数据进行归并
        merge(a,lo,mid,hi);
    }

    private static void merge(int[] a,int lo,int mid,int hi){
        int i = lo; //指向temp
        int p1 = lo; //p1,p2指向这两组数据
        int p2 = mid+1;
//比较左边小组和右边小组中的元素大小，哪个小，就把哪个数据填充到assist数组中
        while (p1<=mid&&p2<=hi){
            if (a[p1]<=a[p2]){
                temp[i++]=a[p1++];
            }else {
                temp[i++]=a[p2++];
            }
        }
//上面的循环结束后，如果退出循环的条件是p1<=mid，则证明左边小组中的数据已经归并完毕，如果退 出循环的条件是p2<=hi,则证明右边小组的数据已经填充完毕；
//所以需要把未填充完毕的数据继续填充到assist中；1
//下面两个循环，只会执行其中的一个
        while (p1<=mid){
            temp[i++] = a[p1++];
        }
        while (p2<=hi){
            temp[i++] = a[p2++];
        }
//函数返回void，需要在每次合并时把合并好的对应位置元素替换到数组a中
        for (int index=lo;index<=hi;index++){ a[index]=temp[index]; }
    }
}
