package algorithms.graph;

import java.util.*;

/**
 * @author vinay.saini
 * @created 23/08/2020 - 6:31 PM
 */
public class CloneUndirectedGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     }

     Map<Integer, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        List<UndirectedGraphNode> adj = new ArrayList<>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        visited.put(node.label, copy);
        for (int i = 0; i < node.neighbors.size(); i++) {
            UndirectedGraphNode nb = node.neighbors.get(i);
            if(visited.containsKey(nb.label)) {
                adj.add(visited.get(nb.label));
            } else {
                UndirectedGraphNode create = cloneGraph(nb);
                adj.add(create);
            }
        }
        copy.neighbors = adj;
        return copy;
    }
}
