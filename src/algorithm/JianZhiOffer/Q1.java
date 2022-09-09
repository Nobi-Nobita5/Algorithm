package algorithm.JianZhiOffer;

public class Q1 {
    public boolean Find(int target, int [][] array) {
        int x = 0;
        int y = array[0].length-1;
        while (x<array.length && y>=0){
            if (array[x][y]>target){
                y--;
            }else if (array[x][y]<target){
                x++;
            }else return true;
        }
        return false;
    }
}
