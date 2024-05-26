package psds.graph;

/**
 * @author vinay.saini [STD]
 * Find: It determines in which subset a particular element is in and returns the representative of that particular set.
 * Union: It merges two different subsets, and the representative of one set becomes representative of another.
 */

// https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/

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
