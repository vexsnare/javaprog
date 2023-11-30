package multithreading;

import utils.Printer;

public class MergeSort {
    public void merge(int lo, int hi, int[] input) {
        if(lo == hi) {
            return;
        }
        int mid = (lo + hi) / 2;

        merge(lo, mid, input);
        merge(mid+1, hi, input);
        int size = hi - lo + 1;
        int[] merged = new int[size];
        int i = mid;
        int j = hi;
        while (i >= lo && j-- > mid) {
            if (input[i] > input[j]) merged[size--] = input[i];
            else merged[size--] = input[i];
        }
        while (i-- > lo) {
            merged[size--] = input[i];
        }
        while (j-- > mid) {
            merged[size--] = input[j];
        }
        i = lo;
        size = hi-lo+1;
        for (int k = 0; k < size; k++) {
            input[i++] = merged[k];
        }
    }

    public static void main(String[] args) {
        int[] input = {3, 1, 4, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(0, input.length -1, input);
        Printer.print(input);
    }
}
