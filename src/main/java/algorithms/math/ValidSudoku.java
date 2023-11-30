package algorithms.math;

/**
 * @author vinay.saini
 * @created 23/08/2020 - 5:27 PM
 */
public class ValidSudoku {
    int[][] rows = new int[9][9];
    int[][] columns = new int[9][9];
    int[][] grids = new int[9][9];

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') continue;
                int value = (board[i][j] - '0') - 1;
                rows[i][value]++;
                if(rows[i][value] > 1) return false;
                columns[j][value]++;
                if(columns[j][value] > 1) return false;
                int g = 3*(i/3) + (j/3);
                grids[g][value]++;
                if(grids[g][value] > 1) return false;
            }
        }
        return true;
    }
}
