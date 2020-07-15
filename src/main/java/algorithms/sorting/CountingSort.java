package algorithms.sorting;

import helpers.PrintHelper;

public class CountingSort {
    /**
     * Can only sort element in a known integer range
     */
    private int MAX = 100;

    private void sort(int[] ar) {
        int n = ar.length;
        int[] count = new int[MAX];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            count[ar[i]]++;
        }
        for (int i = 1; i < MAX; i++) {
            count[i] += count[i-1];
        }
        for (int i = 0; i < n; i++) {
            result[count[ar[i]]-1] = ar[i];
            count[ar[i]]--;
        }
        for (int i = 0; i < n; i++) {
            ar[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] ar = {2,3,4, 1, 11, 10, 1};
        CountingSort countingSort = new CountingSort();
        countingSort.sort(ar);
        PrintHelper.printArray(ar);

    }
}
