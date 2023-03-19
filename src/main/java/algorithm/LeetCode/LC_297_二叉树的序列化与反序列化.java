package algorithm.LeetCode;

import algorithm.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * ---------------------------------
 * 方法一：深度优先（前序遍历）
 *
 * 思路：前序遍历（回溯）
 * 时间复杂度：在序列化和反序列化函数中，我们只访问每个节点一次，因此时间复杂度为 O(n)
 * 空间复杂度：在序列化和反序列化函数中，我们递归会使用栈空间，故渐进空间复杂度为 O(n)
 *
 * 要想实现回溯，可以显式地利用栈的先进后出特性，也可以采用递归的方式（因为递归本身就是基于方法调用栈来实现）
 * -------------------------------
 * 时间复杂度：O(n)，n是节点数，即树的大小。序列化和反序列化函数中，每一个节点至多只会被访问一次。
 * 空间复杂度：O(n)，主要为额外的深度优先搜索的栈帧开销。
 */
public class LC_297_二叉树的序列化与反序列化 {
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    //序列化为一个用逗号隔开的字符串
    public String rserialize(TreeNode root, String str) {//str作为参数，方便递归过程中修改
        if (root == null) {
            str += "None,";//None节点也要表示出来，方便反序列化
        } else {
            str += str.valueOf(root.val) + ",";//用逗号分割开
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));//序列化，反序列化都是前序遍历
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
}
