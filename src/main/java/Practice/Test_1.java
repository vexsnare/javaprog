package Practice;/*
 * Copyright: ThoughtSpot Inc. 2024
 */

/**
 * CLASS_DEFINITION_COMMENTS
 *
 * @author author_name (vinay.saini@thoughtspot.com)
 */
public class Test_1 {
    public static void main(String[] args) {
        //System.out.println("vinay");


        for (int i = 1; i < 100; i++) {

            // i = 2
            // 2 ... i-1
            // i-1, i-2, i-3.....2
            //
            boolean f = true;

            for(int x = 2; x < i-1; x++) {

                if(i % x == 0) {
                   f = false;
               }
            }

            if(f == true) {
                System.out.println(i);
            }


        }
    }
}
/*
i+=2
i = i + 2;
i = i + 2 + i

 */