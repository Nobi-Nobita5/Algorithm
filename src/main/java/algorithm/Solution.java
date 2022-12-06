package algorithm;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] a  = new int[128];//ASCLL值的范围为[0,128)
        System.out.println(Integer.parseInt(""));
    }

    public String serialize(TreeNode root) {
        return rserialize(root);
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root) {//str作为参数，方便递归过程中修改
        String str = "";
        if (root == null) {
            str += "None,";//None节点也要表示出来，方便反序列化
        } else {
            str += str.valueOf(root.val) + ",";//用逗号分割开
            str += rserialize(root.left);
            str += rserialize(root.right);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
}
