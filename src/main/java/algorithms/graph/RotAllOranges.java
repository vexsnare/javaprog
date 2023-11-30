package algorithms.graph; /**
 * Created by vinaysaini on 7/4/16.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 */
public class RotAllOranges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = in.nextInt();
            }
        }
        System.out.println(solve(ar, n, m));

    }
    static int solve(int[][] ar, int n, int m) {
        Queue<Pair> q = new LinkedList<Pair>();
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ar[i][j] == 2) {
                    q.add(new Pair(i,j));
                }
            }
        }
        q.add(new Pair(-1, -1));


        int ans = 0;
        boolean flag = true;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            if(current.x == -1 && current.y == -1) {
                if (!q.isEmpty()) q.add(new Pair(-1,-1));
                flag = true;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int ii = current.x + dx[i];
                int jj = current.y + dy[i];
                if(inRange(ii, jj, n, m) && ar[ii][jj] == 1) {
                    ar[ii][jj] = 2;
                    q.add(new Pair(ii, jj));
                    if (flag == true) {
                        ans++;
                        flag = false;
                    }
                }
            }
        }
        return isAnyUnRotten(ar, n, m) ? -1 : ans;

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
