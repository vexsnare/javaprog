package helpers;

import java.util.Objects;

public class Tester {
    public static void assertEqual(Object o1, Object o2) {
        if(Objects.equals(o1, o2)) {
            System.out.println("PASSED");
        } else {
            System.out.println("--> FAILED");
        }
    }
}
