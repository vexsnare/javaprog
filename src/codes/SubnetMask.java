package codes;

import java.util.Scanner;

/**
 * Created by vinaysaini on 10/8/16.
 */
public class SubnetMask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ar = {"3.34.14.1","3.3.1.2"};
        String[] toBin = new String[ar.length];
        for (int i = 0; i < ar.length; i++) {
            toBin[i] = ipToBinary(ar[i]);
        }
        String comPrefix = getPrefix(toBin);
        String ans  = binToIp(comPrefix);
        System.out.println(ans);

    }
    static String getPrefix(String ar[]) {
        String prefix = ar[0];
        for (int i = 1; i < ar.length; i++) {
            String str = ar[i];
            String newPrefix =  "";
            for (int j = 0; j < prefix.length(); j++) {
                if(prefix.charAt(j) == str.charAt(j)) newPrefix += prefix.charAt(j);
                else break;
            }
            prefix = newPrefix;
        }
        return prefix;
    }
    static String binToIp(String s) {
        String subnet = "";
        if(s.length() < 32) {
            while (s.length() < 32) s += "0";
        }
        for (int i = 0; i < 32; i+=8) {
            String x = s.substring(i, i + 8);
            int xtoi = Integer.parseInt(x,2);
            subnet += xtoi;
            if(i < 24) subnet += ".";
        }
        return subnet;
    }
    static String ipToBinary(String s) {
        String[] ar = s.split("\\.");
        String ret = "";
        for (int i = 0; i < 4; i++) {
            String x = ar[i];
            String bin = Integer.toBinaryString(Integer.parseInt(x));
            while (bin.length() < 8) {
                bin = "0" + bin;
            }
            ret += bin;
        }
        return ret;
    }
}

