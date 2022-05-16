import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testIsPalindromeByOne() {
        assertFalse(palindrome.isPalindrome("Aaaaa", offByOne));
        assertTrue(palindrome.isPalindrome("aacbb", offByOne));
        assertTrue(palindrome.isPalindrome("aaaabbbb", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("&%", offByOne));
        assertFalse(palindrome.isPalindrome("abbbba", offByOne));
    }
    // Your tests go here.

}
