package algo.sorting;

import helpers.PrintHelper;

public class HeapSort {
    /**
     *
     * @param ar array
     */
    private void sort(int[] ar) {
        int n = ar.length;

        // re-arrange
        for (int i = n/2-1; i >= 0; i--) {
            heapify(ar, i, n-1);
        }

        // pick and move to right
        for (int i = n-1; i >= 0; i--) {
            heapify(ar, 0, i);
            swap(ar, 0, i);
        }
    }

    /**
     *
     * @param ar
     * @param li left index of array
     * @param ri right index of array to heapify
     */
    private void heapify(int[] ar, int li, int ri) {
        int max = li;
        int left = 2*li + 1;
        int right = 2*li + 2;
        if( left <= ri && ar[left] > ar[max]) {
            max = left;
        } else if( right <= ri && ar[right] > ar[max]) {
            max = right;
        }
        if(max != li) {
            swap(ar, max, li);
            heapify(ar, max, ri);
        }
    }

    private void swap(int ar[], int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int ar[] = {1, 2, 3};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(ar);
        PrintHelper.printArray(ar);
    }
}
