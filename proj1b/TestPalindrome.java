import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue((palindrome.isPalindrome("")));
        assertTrue(palindrome.isPalindrome("abbbbbbbba"));
        assertFalse(palindrome.isPalindrome("ababba"));
        assertTrue(palindrome.isPalindrome("abccba"));
        assertFalse(palindrome.isPalindrome("aaabaa"));
        assertTrue(palindrome.isPalindrome("baccabtbaccab"));
        assertFalse(palindrome.isPalindrome("Aaaaa"));
        assertTrue(palindrome.isPalindrome("AaA"));
    }
    public void testIsOffByOne() {
        assertFalse(palindrome.isPalindrome("AaaAB", offByOne));
        assertTrue(palindrome.isPalindrome("aacbb", offByOne));
        assertTrue(palindrome.isPalindrome("aaaabbbb", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("&%", offByOne));
        assertFalse(palindrome.isPalindrome("abbbba", offByOne));
        assertFalse(palindrome.isPalindrome("Aa"));
    }


}
