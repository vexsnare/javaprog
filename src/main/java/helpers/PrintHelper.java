package helpers;


import java.util.List;

public class PrintHelper <T>{

    public void printList(List<T> list, String delim) {
        for (T item: list) {
            System.out.print(item + " " + delim);
        }
        System.out.println();
    }
    public static void printArray(int[] arr) {
        for (int e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
