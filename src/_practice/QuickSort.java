package _practice;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {

    void sort(ArrayList<Integer> arrayList, int li, int ri) {
        if(ri <= li) return;
        int pivot = arrayList.get(ri);
        int k = li-1;
        for (int i = li; i < ri; i++) {
            if(arrayList.get(i) < pivot) {
                swap(arrayList, i, k+1);
                k++;
            }
        }
        swap(arrayList, k+1, ri);
        sort(arrayList, li, k);
        sort(arrayList, k+2, ri);
    }
    void swap(ArrayList<Integer> arrayList, int i1, int i2) {
        Integer temp = arrayList.get(i1);
        arrayList.set(i1, arrayList.get(i2));
        arrayList.set(i2, temp);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextInt());
        }
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arrayList, 0, arrayList.size()-1);
        PrintHelper.printArrayList(arrayList);
    }

}
