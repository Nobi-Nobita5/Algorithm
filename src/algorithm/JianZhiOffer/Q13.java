package algorithm.JianZhiOffer;
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Q13 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
//    public int[] reOrderArray (int[] array) {
//        // write code here
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]%2==1){
//                list.add(array[i]);
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]%2==0){
//                list.add(array[i]);
//            }
//        }
//        //用(int[])list.toArray会报错，因为Integer[]数组不能直接转换为int[]数组
//        //通过JDK1.8的Stream流把Integer类型集合转换为int数组
//        return list.stream().mapToInt(Integer::intValue).toArray();
//    }

    /*
    思路二：用插入排序的思想
     */
    public int[] reOrderArray (int[] array) {
        // write code here
        //从当前元素依次循环遍历，与前面整理好奇偶顺序的数组挨个比较，用内层循环寻找合适的位置插入
        for (int i = 1; i <array.length ; i++) {
            for (int j = i; j>0; j--) {
                //如果当前数字是奇数，且前面的数字是偶数，就一直往前交换，直到找到第一个偶数，交换停止
                if (array[j]%2==1 && array[j-1]%2==0){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }else break;
            }
        }
        return array;
    }
}
