package interviews;

/*
[
  {BASIC, 9.99},
  {STANDARD, 49.99},
  {PREMIUM, 249.99}
]

Customer -> C1
Product ->
 Name -> Jira
 Subscription -> [ BASIC, "2022-03-10”  ]


 => [0 ,0 ,0, 0, ] - 365 days
 =>
 */


import java.util.*;


public class AtlassianQ2 {

    static class Subscription {
        String productName;
        String customerId;

        String subscriptionType;

        String date;

        Subscription(String customerId, String productName, String subscriptionType, String startDate) {
            this.customerId = customerId;
            this.productName = productName;
            this.date = startDate;
            this.subscriptionType = subscriptionType;
        }
    }
    Map<String, Double> pricing;

    Map<String, List<Subscription>> subscriptions;
    Map<String, List<Double>> costsMap;
    AtlassianQ2() {
        subscriptions = new HashMap<>();
        costsMap = new HashMap<>();
        pricing = new HashMap<>();

        pricing.put("BASIC", 9.99);
        pricing.put("STANDARD", 49.99);
        pricing.put("PREMIUM", 249.99);

    };


    int covertDate(String date) {
        String[] dates = date.split("-");
        int month =  Integer.parseInt(dates[1]);
        int day =  Integer.parseInt(dates[2]);
        return month * 30 + day;
    }
    public void addSubscription(Subscription subscription) {
        if(subscriptions.containsKey(subscription.customerId)) {
            subscriptions.get(subscription.customerId).add(subscription);
        } else {
            List<Subscription> subscriptions1 = new ArrayList<>();
            subscriptions1.add(subscription);
            subscriptions.put(subscription.customerId, subscriptions1);
        }
    }

    private void compute(String customerId) {
        Integer days = 365;
        List<Double> costs = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            costs.add(0.0);
        }
        List<Subscription> subscriptionList = subscriptions.get(customerId);
        for (int i = 0; i < subscriptionList.size(); i++) {

            String subscriptionType = subscriptionList.get(i).subscriptionType;
            double pricing = this.pricing.get(subscriptionType) / 30;
            int startDayIndex = covertDate(subscriptionList.get(i).date);
            for (int j = startDayIndex; j < days; j++) {
                costs.set(j, costs.get(j) + pricing);
            }
        }
        this.costsMap.put(customerId, costs);
    }

    List<Double> monthlyBills(String customerId) {
        List<Double> costs = costsMap.get(customerId);
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            double c = 0.0;
            for(int j = i*30; j < i*30 + 30; j++) {
                c += costs.get(j);
            }
            ans.add(c);
        }
        return ans;
    }

    public static void main(String[] args) {
        Subscription subscription = new Subscription("A", "Jira", "BASIC", "2022-03-15");
        Subscription subscription2 = new Subscription("A", "Jira2", "STANDARD", "2022-02-15");
        AtlassianQ2 atlassian = new AtlassianQ2();
        atlassian.addSubscription(subscription);
        atlassian.addSubscription(subscription2);
        atlassian.compute("A");
        List<Double> r = atlassian.monthlyBills("A");
        Double annual = 0.0;
        for (int i = 0; i < r.size(); i++) {
            annual += r.get(i);
            System.out.println(r.get(i) + " ");
        }
        System.out.println(annual);
    }
}
