package psds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell, 1 representing a fresh orange, or 2 representing a rotten orange .
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */

// https://leetcode.com/problems/rotting-oranges/description/

public class RottingOranges {
    public int orangesRotting(int[][] ar) {
        int n = ar.length;
        if(n <= 0) return -1;
        int m = ar[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ar[i][j] == 2) {
                    q.add(new Pair(i,j));
                }
            }
        }


        int time = 0;
        while (!q.isEmpty()) {
            Queue<Pair> nextQ = new LinkedList<>();
            while (!q.isEmpty()) {
                Pair current = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ii = current.x + dx[i];
                    int jj = current.y + dy[i];
                    if (inRange(ii, jj, n, m) && ar[ii][jj] == 1) {
                        ar[ii][jj] = 2;
                        nextQ.add(new Pair(ii, jj));
                    }
                }
            }
            if(!nextQ.isEmpty()) {
                time++;
                q = nextQ;
            }
        }
        return isAnyUnRotten(ar, n, m) ? -1 : time;

    }

    static boolean isAnyUnRotten(int[][] ar, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ar[i][j] == 1) return true;
            }
        }
        return false;
    }

    static boolean inRange(int i, int j, int n, int m) {
        return i < n && i >= 0 && j >= 0 && j < m;
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
