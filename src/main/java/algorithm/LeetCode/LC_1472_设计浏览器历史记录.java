package algorithm.LeetCode;

import java.util.Stack;

/**
 * @Author: Xionghx
 * @Date: 2022/07/15/17:23
 * @Version: 1.0
 * 思路：栈实现
 */
public class LC_1472_设计浏览器历史记录 {
    private Stack<String> hisStack;
    private Stack<String> forwardStack;
    private String presentUrl;//记录当前网址

    //用 homepage 初始化浏览器类
    public LC_1472_设计浏览器历史记录(String homepage) {
        hisStack = new Stack<String>();
        forwardStack = new Stack<String>();
        presentUrl = homepage;
    }

    //从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
    public void visit(String url) {
        hisStack.push(presentUrl);
        presentUrl = url;
        while(!forwardStack.empty())  forwardStack.pop();
    }

    //在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，那么你只后退 x 步。
    //请返回后退 至多 steps 步以后的 url
    public String back(int steps) {
        while(steps-- > 0 && !hisStack.empty()){
            forwardStack.push(presentUrl);
            presentUrl = hisStack.peek();
            hisStack.pop();
        }
        return presentUrl;
    }

    //在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。
    //请返回前进 至多 steps步以后的 url 。
    public String forward(int steps) {
        while(steps-- > 0 && !forwardStack.empty()){
            hisStack.push(presentUrl);
            presentUrl = forwardStack.peek();
            forwardStack.pop();
        }
        return presentUrl;
    }
}
