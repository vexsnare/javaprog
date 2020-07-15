package algorithms.sorting;

import helpers.Aux;
import helpers.Printer;

public class BubbleSort {
    private void sort(int ar[]) {
        for (int i = ar.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (ar[j] < ar[j-1])
                    Aux.swap(ar, j-1, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 1, 3, 32, 0};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(ar);
        Printer.printArray(ar);
    }
}
