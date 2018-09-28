package utils;

import java.util.ArrayList;

public class PrintHelper {
    
      public static void printArrayList(ArrayList<Integer> arrayList) {
          for (Integer e: arrayList) {
              System.out.print(e + " ");
          }
          System.out.println();
      }
}
