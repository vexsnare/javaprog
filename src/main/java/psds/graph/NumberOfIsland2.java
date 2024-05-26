package psds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a grid of size m x n. The grid represents a map where 0's represent water and 1's represent land.
 * We may perform an add_land (i,j) operation which turns the water at position into a land. (0->1)
 * You are given positions[][] array, where position (ri, ci) at which we should perform add_land operation on ith step.
 * Return an array of integers where answer[i] is the number of islands after turning the cell (ri, ci) into a land.
 */

// https://algo.monster/liteproblems/305

public class NumberOfIsland2 {

    int[] dirX = {-1, 0, 1, 0};
    int[] dirY = {0, 1, 0, -1};

    boolean inRange(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        UnionFind unionFind = new UnionFind(n*m);

        int[][] grid = new int[n][m]; // Grid to maintain the state of the land and water.

        int islandCount = 0;
        List<Integer> answer = new ArrayList<>();

        // position[][] has many rows and 2 columns 0,1
        for (int[] pos : positions) {
            int i = pos[0], j = pos[1];
            int index = i * n + j; // Flatten the 2D position to 1D

            // land is already present
            if (grid[i][j] == 1) {
                answer.add(islandCount);
                continue;
            }
            grid[i][j] = 1;

            for (int k = 0; k < 4; ++k) {
                int x = i + dirX[k];
                int y = j + dirY[k];
                int adjIndex = x * m + y;

                if (inRange(x, y, n, m) && grid[x][y] == 1 && unionFind.find(adjIndex) != unionFind.find(index)) {
                    unionFind.union(adjIndex, index); // Union the two cells.
                    islandCount--;
                }
            }

            answer.add(islandCount);
        }

        return answer;
    }


    static class UnionFind {
        int[] P;
        int[] R;

        UnionFind(int n) {
            P = new int[n];
            R = new int[n];
            for (int i = 0; i < n; i++) {
                P[i] = i;
            }
        }

        public int find(int x) {
            if (P[x] == x) return x;
            int p = find(P[x]);
            P[x] = p;
            return p;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (R[px] >= R[py]) {
                P[y] = px;
                R[px]++;
            } else {
                P[x] = py;
                R[py]++;
            }
        }
    }

}
