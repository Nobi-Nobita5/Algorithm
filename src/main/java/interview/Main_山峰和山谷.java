package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
思路：用队列实现广度优先搜索算法
1.按顺序对地图进行遍历，用广搜找每个节点的连通区域（即数字相同的区域），默认每个区域既是山峰又是山谷，在广搜的过程中如果
邻近的节点（包括已访问的节点）大于或者小于该节点，则分别取消这个区域的山峰或山谷标志，如果相等（只能是未访问的节点）则加入队列
中继续广搜，如果山峰山谷标志都已取消则提前结束广搜
 */

public class Main_山峰和山谷 {
    static int[][] map;//存放每个坐标上的值
    static boolean[][] visit;//表示每个坐标是否已经被访问过（已经成了别的山峰或山谷）
    static int[][] move = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};//用于得到周围8个点的横纵坐标
    static int n;
    static boolean hight,low;//用于判断当前连通区域是否是山峰或山谷
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = in.nextInt();
            }
        }
        int hightNum=0,lowNum=0;
        for(int i=0;i<n;i++) {//从每个点开始分别广搜
            for(int j=0;j<n;j++) {
                if(!visit[i][j]) {//如果此坐标已经被访问过（已经成了别的山峰或山谷），不进行下面操作
                    hight=true;low=true;//每次循环给high和low赋值
                    BFS(i,j);
                    if(hight)
                        hightNum++;
                    if(low)
                        lowNum++;
                }
            }
        }
        System.out.print(hightNum + " " + lowNum);
    }

    public static void BFS(int x,int y) {
        Queue<Node> queue = new LinkedList<Node>();
        Node start = new Node(x,y);
        queue.offer(start);
        visit[x][y]=true;//每一个存放坐标点的Node入队列后，把对应坐标点的visit值设为true
        while(!queue.isEmpty()) {
            Node next = queue.poll();
            for(int i=0;i<8;i++) {//遍历周围的8个坐标点的值
                if(!hight && !low)//如果遍历到某个坐标high和low都为false，就返回退出
                    return;
                x=next.x+move[i][0];//得到周围8个点的横坐标
                y=next.y+move[i][1];//得到周围8个点的纵坐标
                if(x>=0 && x<n && y>=0 && y<n) {
                    if(map[x][y]<map[next.x][next.y]) {//如果遍历到某个坐标在map里存放的值比当前较小，那此次遍历的连通区域不是山谷
                        low=false;
                    }
                    else if(map[x][y]>map[next.x][next.y]){//如果遍历到某个坐标在map里存放的值比当前较大，那此次遍历的连通区域不是山峰
                        hight=false;
                    }
                    else if(!visit[x][y]){//如果遍历到某个坐标在map里存放的值与当前一样大，且未访问过，那么入队列
                        queue.offer(new Node(x,y));
                        visit[x][y]=true;
                    }
                }
            }
        }
    }
}

class Node{//这个类定义了存放横纵坐标的数据结构，队列里存放的就是这个类的对象
    int x;
    int y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}


