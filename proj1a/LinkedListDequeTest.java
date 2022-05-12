/** Performs some basic linked list tests. */
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }


    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    @Test
    public void testaddFirst() {
        LinkedListDeque<Integer> a = new LinkedListDeque<Integer>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        int actual = a.removeLast();
        assertEquals(1, actual);
        actual = a.removeLast();
        assertEquals(2, actual);
        actual = a.removeLast();
        assertEquals(3, actual);

        assertEquals(null, a.removeLast());

    }

    @Test
    public void testaddLast() {
        LinkedListDeque<Integer> a = new LinkedListDeque<Integer>();
        a.addLast(0);
        a.addLast(1);
        a.addLast(2);
        int actual = a.removeLast();
        assertEquals(2, actual);
        actual = a.size();
        assertEquals(2, actual);
        actual = a.removeFirst();
        assertEquals(0, actual);
        actual = a.removeFirst();
        assertEquals(1, actual);
    }

    @Test
    public void isEmptyTest() {
        LinkedListDeque<Integer> a = new LinkedListDeque<Integer>();
        a.addLast(0);
        a.addLast(1);
        int actual = a.removeLast();
        assertEquals(1, actual);
        assertEquals(false, a.isEmpty());
    }
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }

}
