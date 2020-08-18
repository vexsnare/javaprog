package helpers;


import java.util.Arrays;
import java.util.List;

public class Printer {

    public static void print(List<Integer> list) {
        for (Integer item: list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void print(int[] arr) {
        for (int e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void print(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(boolean[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print((ar[i][j] ? "T" : "F") + " ");
            }
            System.out.println();
        }
    }
}
