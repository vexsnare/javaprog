package algo.sorting;

import utils.PrintHelper;

public class MergeSort {
    /**
     *
     * @param ar
     * @param l left array leftIndex
     * @param k left array rightIndex
     * @param r right array rightIndex
     */
    private void merge(int[] ar, int l, int k, int r) {
        int n = r - l + 1;
        int[] tempAr = new int[n];
        int li = l;
        int ri = k + 1;
        int i = 0;
        while (li <= k && ri <= r) {
            if (ar[li] < ar[ri]) {
                tempAr[i++] = ar[li++];
            } else {
                tempAr[i++] = ar[ri++];
            }
        }
        while (li <= k) {
            tempAr[i++] = ar[li++];
        }
        while (ri <= r) {
            tempAr[i++] = ar[ri++];
        }
        for (i = 0; i < n; i++) {
            ar[l++] = tempAr[i];
        }
    }

    private void sort(int[] ar, int li, int ri) {
        if (ri <= li) return;
        int mid = (li + ri) / 2;
        sort(ar, li, mid);
        sort(ar, mid+1, ri);
        merge(ar, li, mid, ri);
    }

    public static void main(String[] args) {
        int ar[] = {12, 2, 3, 2, 1, 0, -12, 12, 4334, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(ar, 0, ar.length - 1);
        PrintHelper.printArray(ar);
    }
    
}
