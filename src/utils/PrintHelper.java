package utils;


import java.util.List;

public class PrintHelper {
    
      public static void printList(List<Integer> list) {
          for (Integer e: list) {
              System.out.print(e + " ");
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
