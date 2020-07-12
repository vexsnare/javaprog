package algo.sorting;

import helpers.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    private void sort(List<Integer> list, int li, int ri) {
        if(ri <= li) return;
        int pivot = list.get(ri);
        int k = li-1;
        for (int i = li; i < ri; i++) {
            if(list.get(i) < pivot) {
                swap(list, i, k+1);
                k++;
            }
        }
        swap(list, k+1, ri);
        sort(list, li, k);
        sort(list, k+2, ri);
    }
    private void swap(List<Integer> list, int i1, int i2) {
        Integer temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
    
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};
        List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toCollection(ArrayList::new));
        QuickSort quickSort = new QuickSort();
        quickSort.sort(list, 0, list.size()-1);
        new PrintHelper<Integer>().printList(list, ",");
    }
}
