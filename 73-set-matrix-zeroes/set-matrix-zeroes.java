import java.util.ArrayList;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> zeroRows = new ArrayList<>();
        ArrayList<Integer> zeroCols = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (!zeroRows.contains(i)) {
                        zeroRows.add(i);
                    }
                    if (!zeroCols.contains(j)) {
                        zeroCols.add(j);
                    }
                }
            }
        }
        for (int row : zeroRows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
        for (int col : zeroCols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
