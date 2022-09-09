package algorithm.JianZhiOffer;

import java.util.ArrayList;

public class Q19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row1 = 0;
        int row2 = matrix.length - 1;
        int col1 = 0;
        int col2 = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        //计算出应该循环的圈数）
        int m = Math.min(row2 + 1, col2 + 1) % 2 == 0 ? Math.min(row2 + 1, col2 + 1) / 2 : Math.min(row2 + 1, col2 + 1) / 2 + 1;
        for (int j = 0; j < m; j++) {
            for (int i = col1; i <= col2; i++) {
                list.add(matrix[row1][i]);
            }
            for (int i = row1 + 1; i <= row2; i++) {
                list.add(matrix[i][col2]);
            }
            if (row1 < row2 && col1 < col2) {//只有一行或者一列，则没必要进行下面的循环
                for (int i = col2 - 1; i >= col1; i--) {
                    list.add(matrix[row2][i]);
                }
                for (int i = row2 - 1; i > row1; i--) {
                    list.add(matrix[i][col1]);
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }

        return list;
    }
}
