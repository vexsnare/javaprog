package algorithms.app;
import java.util.*;

public class SearchAutoComplete {

    Map<String, Integer> m = new HashMap<>();

    class Node {
        Map<Character, Node> nodes;
        List<String> top3;
        Node() {
            this.top3 = new ArrayList<>();
            this.nodes = new HashMap<>();
        }
        public void insert(String s) {
            if(!top3.contains(s)) top3.add(s);
            Collections.sort(top3, (s1, s2) -> m.get(s1) == m.get(s2) ? s1.compareTo(s2) : m.get(s2) - m.get(s1) );
            if(top3.size() > 3) top3.remove(top3.size() - 1);
        }
    }

    Node root = new Node();

    private void record(String s) {
        int i = 0;
        Node temp = root;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(!temp.nodes.containsKey(c)) {
                temp.nodes.put(c, new Node());
            };
            temp = temp.nodes.get(c);
            temp.insert(s);
            i++;
        }
    }

    public SearchAutoComplete(String[] sentences, int[] times) {
        for(int i = 0; i < sentences.length; i++) {
            m.put(sentences[i], times[i]);
            record(sentences[i]);
        }

    }
    String str = "";
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if(c == '#') {
            m.put(str, m.getOrDefault(str, 0) + 1);
            record(str);
            str = "";
            return result;
        }
        Node temp = root;
        int i = 0;
        str += c;
        while(i < str.length()) {
            if(temp.nodes.containsKey(str.charAt(i))) temp = temp.nodes.get(str.charAt(i));
            else break;
            i++;
        }
        if(i == str.length()) {
            result = temp.top3;
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */