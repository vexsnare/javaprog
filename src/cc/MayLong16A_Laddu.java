package cc;

import java.util.Scanner;

/**
 * Created by vinaysaini on 5/7/16.
 */
class MayLong16A_Laddu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int activities = in.nextInt();
            String origin = in.nextLine().trim();
            int totalLaddus = 0;
            for (int i = 0; i < activities; i++) {
                String activity = in.nextLine();
                totalLaddus += getPoints(activity);
            }
            int months = redeemForMonths(totalLaddus, origin);
            System.out.println(months);
        }
    }
    static int getPoints(String activity) {
        int laddus = 0;
        if(activity.startsWith("CONTEST_WON")) {
            laddus += 300;
            int rank = Integer.parseInt(activity.split(" ")[1]);
            laddus += rank < 20 ? 20 - rank : 0;
        }
        else if (activity.startsWith("TOP_CONTRIBUTOR")) {
            laddus += 300;
        } else if(activity.startsWith("BUG_FOUND")) {
            laddus += Integer.parseInt(activity.split(" ")[1]);
        } else if(activity.startsWith("CONTEST_HOSTED")) {
            laddus += 50;
        }
        return laddus;
    }
    static int redeemForMonths(int laddus, String origin) {
        if(origin.equals("INDIAN")) {
            return laddus/200;
        } else {
            return laddus/400;
        }
    }
}
