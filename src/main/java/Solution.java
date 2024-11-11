import java.util.*;

abstract class Operation {}

class InsertAtEndOperation extends Operation {
    String charsToInsert;

    InsertAtEndOperation(String charsToInsert) {
        this.charsToInsert = charsToInsert;
    }
}

class DeleteFromEndOperation extends Operation {
    int numCharsToDelete;

    DeleteFromEndOperation(int numCharsToDelete) {
        this.numCharsToDelete = numCharsToDelete;
    }
}

class TextDocument {

    StringBuffer sb;
    Stack<Operation> undo;
    Stack<Operation> redo;
    Map<Operation, String> delMap;

    TextDocument() {
        this.sb = new StringBuffer();
        this.undo = new Stack<>();
        this.redo = new Stack<>();
    }

    private void insert(String s) {
        sb.insert(sb.length() - 1, s.toCharArray());
    }

    private void delete(int n) {
        sb.delete(sb.length() - n, sb.length() - 1);
    }


    public void applyOperation(Operation op) {
        if (op instanceof InsertAtEndOperation) {
            undo.add(op);
            insert(((InsertAtEndOperation) op).charsToInsert);
        } else if (op instanceof DeleteFromEndOperation) {
            undo.add(op);
            int n = ((DeleteFromEndOperation) op).numCharsToDelete;
            delMap.put(op, sb.substring(sb.length() - n - 1));
            delete(n);
        } else {
            System.out.println("Invalid operation");
        }
    }

    public void undoLast() {
        Operation op = undo.pop();
        redo.add(op);
        if (op instanceof InsertAtEndOperation) {
            delete(((InsertAtEndOperation) op).charsToInsert.length());
        } else if (op instanceof DeleteFromEndOperation) {
            insert(delMap.get(op));
        } else {
            System.out.println("Invalid operation");
        }
    }

    public void redoLast() {
        Operation op = redo.pop();
        applyOperation(op);
    }

    public String getCurrentContent() {
        return sb.toString();
    }
}

// Main class should be named 'Solution' and should not be public.
class Solution {

    public static void main(String[] args) {
        TextDocument doc = new TextDocument();
        assertEquals(doc.getCurrentContent(), "");

        doc.applyOperation(new InsertAtEndOperation("hello"));
        assertEquals(doc.getCurrentContent(), "hello");

        doc.applyOperation(new InsertAtEndOperation("world"));
        assertEquals(doc.getCurrentContent(), "helloworld");

        doc.applyOperation(new DeleteFromEndOperation(5));
        assertEquals(doc.getCurrentContent(), "hello");

        doc.undoLast();
        assertEquals(doc.getCurrentContent(), "helloworld");

        doc.redoLast();
        assertEquals(doc.getCurrentContent(), "hello");
    }

    private static void assertEquals(String actual, String expected) {
        assert expected.equals(actual) : "Values do not match: expected " + expected + " but got " + actual;
        System.out.println("Assertion passed, expected " + expected + " and actual is " + actual);
    }
}

/**
 Insert "a" - O1
 Insert "b" - o2
 Undo
 Undo


 Undo - StackA - o1

 Redo - StackB - o2

 "a"
 **/