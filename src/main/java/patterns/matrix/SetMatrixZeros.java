package patterns.matrix;

import helpers.Printer;

public class SetMatrixZeros {
    public int[][] solve(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
       // Printer.print(mat);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(row[i] == 1|| col[j] == 1) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][]mat = {{1 ,1, 0, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}};
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        setMatrixZeros.solve(mat);
        Printer.print(mat);
    }
}
