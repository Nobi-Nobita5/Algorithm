import java.util.ArrayList;
public class FengYunLianXianTi {
    private static int[] keys = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
    private static int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private static int index = 0;
    //创建存放每一个键顶点的值顶点集合的集合
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        int index1 = 0;
        for (int i = 0; i <=values.length/3; i++) {//先让键顶点依次链接值顶点（值顶点不重复）
            solution1(i);
            index1 = i;
        }
        //上面的顶点（键顶点）在连接下面的顶点（值顶点）时，
        // 该键顶点的任意两个值顶点不能同时出现在之前任意一个键顶点的值顶点集合中
        for (int i = index; i <keys.length ; i++) {//紧接着后面执行连接操作,从key=6开始
            //遍历list1集合，递归操作
            ArrayList<Integer> list1 = new ArrayList<>();
            Solution(keys[i],list1,1,2);
        }
    }
    public static void solution1(int i){
        ArrayList<Integer> list1 = new ArrayList<>();
        if (index<values.length) {
            for (int j = 0; j < 3; j++) {
                list1 = new ArrayList<>();
                if (index<values.length) {
                    System.out.println(keys[i]+" -- "+values[index]);
                    list1.add(values[index]);
                    index++;
                }else break;
            }
        }
        list.add(list1);
    }

    public static void Solution(int a,ArrayList<Integer> list1,int i,int j){
        int index = 1;
        if (a>26||i>13) return;
        if (index>3){
            list.add(list1);
            return;
        }
        if (index==3) list.add(list1);
        boolean flag = false;
        /*
        递归思路：
            遍历list集合中的每一组数据（即之前任意一个键顶点的值顶点集合），
            如果键顶点的任意两个值顶点同时出现在之前任意一个键顶点的值顶点集合中，则此种连发不合适,
            i++后再次递归,
            重复上述操作。
         */
        for (int p = 0; p < list.size(); p++) {
            if (list.get(p).contains(i)&&list.get(p).contains(j)){
                flag=true;
            }
        }
        if (flag) {
            Solution(a,list1,i,j++);
        }else {
            System.out.println(a + " -- " + i);
            list1.add(i);
            index++;
        }
    }
}
