package commons;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 25/07/2020 - 9:10 PM
 */
public class Graph {
    public int V;
    public int E;
    public List<Integer>[] adj;
    Graph(int v, int e, int[][]mat, boolean biDirection) {
        this.V = v;
        this.E = e;
        this.adj = new List[V];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            adj[mat[i][0]].add(mat[i][1]);
            if(biDirection) {
                adj[mat[i][1]].add(mat[i][0]);
            }
        }
    }
}
