package interviewbit.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author vinay.saini
 * @created 31/03/2020 - 12:03 AM
 */
public class Merge2SortedList2 {
    public class Solution {
        public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
            int ptr1 = a.size() - 1;
            int ptr2 = b.size() - 1;
            a.addAll(b);
            int index = a.size() - 1;
            while(ptr1 >= 0 || ptr2 >= 0) {
                if(ptr1 >= 0 && ptr2 >= 0) {
                    if(a.get(ptr1) > b.get(ptr2)) {
                        a.set(index, a.get(ptr1));
                        ptr1--;
                    } else {
                        a.set(index, b.get(ptr2));
                        ptr2--;
                    }
                } else if(ptr1 >= 0) {
                    a.set(index, a.get(ptr1));
                    ptr1--;
                } else {
                    a.set(index, b.get(ptr2));
                    ptr2--;
                }
                index--;
            }
        }
    }
}
