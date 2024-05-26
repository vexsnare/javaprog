package psds.graph;

import java.util.*;

/**
 * Given a un-directed graph with weights find the shortest path between u & v
 */

// https://www.geeksforgeeks.org/introduction-to-dijkstras-shortest-path-algorithm/

public class Dijkshtra {
    private static int n;
    private static int m;
    static List<Integer>[] adj;
    static int[][] weight;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        weight = new int[n][n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v= in.nextInt();
            int w = in.nextInt();
            adj[u].add(v);
            adj[v].add(u);
            weight[u][v] = w;
            weight[v][u] = w;
        }
        int originV = in.nextInt();
        int destV = in.nextInt();
        int shortestDist = getShortestPath(originV,destV);
        System.out.println(shortestDist);
    }

    static int getShortestPath(int u, int v) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        boolean[] visited = new boolean[n];
        pq.add(new Node(u,0));
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            int current_v = node.v;
            int current_dist = node.dist;
            if(current_v == v) return node.dist;
            if(visited[current_v]) continue;
            visited[current_v] = true;
            for (int i = 0; i < adj[current_v].size(); i++) {
                pq.add(new Node(adj[current_v].get(i), current_dist + weight[current_v][adj[current_v].get(i)]));
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        int v;
        int dist;

        Node(int v, int d) {
            this.v = v;
            this.dist = d;
        }
        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}


