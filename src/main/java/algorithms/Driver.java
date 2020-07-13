package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vinay.saini
 * @created 13/07/2020 - 10:41 AM
 */
public class Driver {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.init(Arrays.asList(2,3,1, 4,51,61, 0));
        bst.display();
        System.out.println(bst.find(0));
    }
}
