package psds.graph;

/**
 * @author vinay.saini
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 */
// https://leetcode.com/problems/number-of-islands/

public class NumberofIsland {

    int dx[] = {0, 0, 1, -1};
    int dy[] = {-1, 1, 0, 0};
    boolean[][] visited;
    int n;
    int m;
    private boolean inRange(int i, int j) {
        return i >= 0 && i < n && j >=0 && j < m;
    }

    private void go(int i, int j, char[][] grid) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            if(inRange(ii, jj) && !visited[ii][jj] && grid[ii][jj] == '1') {
                go(ii, jj, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        if(n <= 0) return 0;
        m = grid[0].length;
        visited = new boolean[n][m];

        int islands = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    go(i, j, grid);
                }
            }
        }
        return islands;
    }
}
