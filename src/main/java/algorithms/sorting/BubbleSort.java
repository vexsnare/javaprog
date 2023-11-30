package algorithms.sorting;

import utils.Printer;

public class BubbleSort {
    private void sort(int ar[]) {
        for (int i = ar.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (ar[j] < ar[j-1]) {
                    int t = ar[j - 1];
                    ar[j - 1] = ar[j];
                    ar[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 1, 3, 32, 0};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(ar);
        Printer.print(ar);
    }
}