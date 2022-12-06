package algorithm;

import java.util.*;


public class JiSuanBiaoDaShi {
    public static void main(String[] args) {
        JiSuanBiaoDaShi solution = new JiSuanBiaoDaShi();
        String s = "(3+4)*5-6";
        System.out.println(solution.solve(s));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve (String s) {
        // write code here
        return solution(s);
    }
    //转后缀表达式
    public int solution(String infix){
        //用hashmap设置一个优先级
        Map<String,Integer> basic = new HashMap<String, Integer>();
        basic.put("-",1);
        basic.put("+",1);
        basic.put("*",2);
        basic.put("/",2);
        basic.put("(",0);
        Stack<String> stack1 = new Stack<String>();

        List<String> list = new ArrayList<String>();
        String[] arr = infix.split("");
        for(int i = 0;i<arr.length;i++){
            String c =arr[i];
            if(c.equals("(")){
                stack1.push(c);
            }else if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")){
                if (!stack1.isEmpty()) {
                    while (!stack1.isEmpty()&&basic.get(stack1.peek()) >= basic.get(c)) {
                        list.add(stack1.pop());
                    }
                }
                stack1.push(c);
            }else if(c.equals(")")){
                while (!stack1.peek().equals("(")){
                    list.add(stack1.pop());
                }
                stack1.pop();
            }else list.add(c);
        }
        while (!stack1.isEmpty()) list.add(stack1.pop());


        Stack<Integer> stack2=new Stack<Integer>();

        int a,b;
        for(int i=0;i<list.size();i++){
            String c=list.get(i);
            if(c.equals("+")){
                a=stack2.pop();
                b=stack2.pop();
                stack2.add(b+a);
            }
            else if(c.equals("-")){
                a=stack2.pop();
                b=stack2.pop();
                stack2.add(b-a);
            }
            else if(c.equals("*")){
                a=stack2.pop();
                b=stack2.pop();
                stack2.add(b*a);
            }
            else if(c.equals("/")){
                a=stack2.pop();
                b=stack2.pop();
                stack2.add(b/a);
            }
            else{
                stack2.add(Integer.parseInt(c));
            }
        }
        return stack2.peek();
    }
}
