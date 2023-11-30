package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BP {
    static Map<String, Set<String>> reachableNodes = new HashMap<>();
    static Map<String, String> map = new HashMap<>();
    static class Pair {
        String node;
        int edgeCount;
        Pair(String n, int e) {
            this.node = n;
            this.edgeCount = e;
        }

    }


    private static String[] parseNodesConnectivity(String line) {
        int index = line.indexOf("-");
        String from = line.substring(0, index);
        String to = line.substring(index + 2);
        System.out.println(from + " -> " + to);
        String[] connect = new String[2];
        connect[0] = from;
        connect[1] = to;
        return connect;
    }
    public static boolean isIntersect(String line) {
        String[] nodes = line.split(",");
        // checking for all the nodes
        boolean ans = false;
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i] + " ");
            int count = 0;
            for (String node: reachableNodes.keySet()) {
                if(reachableNodes.containsKey(nodes[i])) {
                    count++;
                    if(count > 1) {
                        ans = true;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        reachableNodes = new HashMap<>();
        Map<String, List<String>> reverseGraph = new HashMap<>();

        while ((line = in.readLine()) != null) {
           // System.out.println(line);
            if(line.contains(",")) {
                boolean result = isIntersect(line);
                System.out.println(result ? "True" : "False");
            } else if (line.contains("-")){
                String[] connect = parseNodesConnectivity(line);

                String k = connect[1];
                String v = connect[0];
                map.put(k, v);
                if(reverseGraph.containsKey(k)) {
                    reverseGraph.get(k).add(v);
                } else {
                    List<String> nb = new ArrayList<>();
                    nb.add(v);
                    reverseGraph.put(k, nb);
                }
            }
            List<Pair> nodes = new ArrayList<>();

            for (String k: reverseGraph.keySet()) {
                if(reverseGraph.get(k).size() > 1)
                nodes.add(new Pair(k, reverseGraph.get(k).size()));
            }
            Collections.sort(nodes, (x, y) -> y.edgeCount - x.edgeCount);
            for(Pair p: nodes) {
                Set<String> linked = new HashSet<>();
                List<String> nb = reverseGraph.get(p.node);
                for (int i = 0; i < nb.size(); i++) {
                    String cur = nb.get(i);
                    while (map.containsKey(cur)) {
                        if (linked.contains(cur)) throw new IOException();
                        linked.add(cur);
                        cur = map.get(cur);
                    }
                }
                reachableNodes.put(p.node, linked);
            }
        }
    }

}
