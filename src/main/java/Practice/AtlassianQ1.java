package Practice;

import java.util.*;

public class AtlassianQ1 {
    Set<String> positiveEvents;
    final String PURCHASE = "PURCHASE";
    AtlassianQ1(String[] positiveEvents) {
        this.positiveEvents = new HashSet<>();
        for (int i = 0; i < positiveEvents.length; i++) {
            this.positiveEvents.add(positiveEvents[i]);
        }
    }

    List<List<String>> findLongestValidEvents(List<String> events) {

        List<List<String>> result = new ArrayList<>();

        List<String> longest = new ArrayList<>();
        Stack<String> current = new Stack<>();

        for (int i = 0; i < events.size(); i++) {
            if(positiveEvents.contains(events.get(i))) {
                current.add(events.get(i));
            } else {
                while (!current.isEmpty() && !current.peek().equals(PURCHASE)) {
                    current.pop();
                }
                if(current.isEmpty() ) continue;
                List<String> valid = new ArrayList<>(current);
                result.add(valid);
                current = new Stack<>();
            }
        }
        while (!current.isEmpty() && !current.peek().equals(PURCHASE)) {
            current.pop();
        }
        if(!current.isEmpty()) result.add(new ArrayList<>(current));
        return result;
    }

    public static void main(String[] args) {
        String[] posEvents = {"VIEW_PRODUCT", "ADD_TO_CART", "PURCHASE"};

        AtlassianQ1 eventReporting = new AtlassianQ1(posEvents);

        String[] events = {"PURCHASE", "VIEW_PRODUCT", "ADD_TO_CART", "REMOVE_FROM_CART", "VIEW_PRODUCT",  "ADD_TO_CART", "VIEW_PRODUCT", "PURCHASE", "LOGOUT", "ADD_TO_CART", "VIEW_PRODUCT", "PURCHASE", "ADD_TO_CART", "PURCHASE", "VIEW_PRODUCT"};

        String[] validEventTypes = { "LOGIN", "LOGOUT", "PURCHASE", "ADD_TO_CART", "REMOVE_FROM_CART", "VIEW_PRODUCT"};

        List<String> eventList = new ArrayList<>();
        for (int i = 0; i < events.length; i++) {
            eventList.add(events[i]);
        }
        List<List<String>> longestAll = eventReporting.findLongestValidEvents(eventList);
        for (int i = 0; i < longestAll.size(); i++) {
            for (int j = 0; j < longestAll.get(i).size(); j++) {
                System.out.print(longestAll.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
