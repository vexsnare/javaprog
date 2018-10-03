package _practice;

import utils.ArrayHelper;
import utils.PrintHelper;

public class BubbleSort {
    private void sort(int ar[]) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i+1; j < ar.length; j++) {
                if (ar[i] > ar[j])
                    ArrayHelper.swap(ar, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 1, 3, 32, 0};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(ar);
        PrintHelper.printArray(ar);
    }
}
