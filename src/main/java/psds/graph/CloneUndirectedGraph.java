package psds.graph;

import java.util.*;

/**
 * @author vinay.saini
 * @created 23/08/2020 - 6:31 PM
 */
public class CloneUndirectedGraph {
    class Node {
        int val;
        List<Node> neighbors;
        Node(int x) { val = x; neighbors = new ArrayList<Node>(); }
     }

     Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return node;
        List<Node> adj = new ArrayList<>();
        Node copy = new Node(node.val);
        visited.put(node.val, copy);
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node nb = node.neighbors.get(i);
            if(visited.containsKey(nb.val)) {
                adj.add(visited.get(nb.val));
            } else {
                Node create = cloneGraph(nb);
                adj.add(create);
            }
        }
        copy.neighbors = adj;
        return copy;
    }
}
