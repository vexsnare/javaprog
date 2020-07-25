package algorithms;

import commons.Graph;
import commons.Pair;
import commons.WeightedGraph;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vinay.saini
 * @created 25/07/2020 - 9:03 PM
 */
public class MST {

    class Edge {
        int u;
        int v;
        int w;
        Edge(int x, int y, int w) {
            this.u = x;
            this.v = y;
            this.w  = w;
        }

    }

    private PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.w - o2.w;
        }
    });

    public List<Pair<Integer, Integer>> findMst(WeightedGraph graph) {

        UnionFind unionFind = new UnionFind(graph.V);

        for (int i = 0; i < graph.adj.length; i++) {
            int u = i;
            for (int j = 0; j < graph.adj[i].size(); j++) {
                int v = graph.adj[i].get(j);
                pq.add(new Edge(u, v, graph.weight[u][v]));
            }
        }
        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(unionFind.find(edge.u) == unionFind.find(edge.v)) continue;
            ans.add(new Pair<>(edge.u, edge.v));
            unionFind.union(edge.u, edge.v);
        }

        return ans;

    }

}
