package algorithms;

import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 25/07/2020 - 8:38 PM
 */

/*
Union Find
Path compression
 */
public class UnionFind {
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
        if(P[x] == x) return x;
        int p = find(P[x]);
        P[x] = p;
        return p;
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(R[px] >= R[py]) {
            P[y] = px;
            R[px]++;
        } else {
            P[x] = py;
            R[py]++;
        }
    }
}
