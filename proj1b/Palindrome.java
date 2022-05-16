public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character cha = word.charAt(i);
            wordDeque.addLast(cha);

        }
        return wordDeque;
    }

    private boolean isPalindromeHelper(LinkedListDeque<Character> list) {
        if (list.isEmpty() || list.size() == 1) {
            return true;
        } else {
            Character first = list.removeFirst();
            Character last = list.removeLast();
            return first.equals(last) && isPalindromeHelper(list);
        }
    }
    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> pali = (LinkedListDeque<Character>) wordToDeque(word);
        return isPalindromeHelper(pali);

    }

    private boolean isPalindromeHelper(LinkedListDeque<Character> list, CharacterComparator cc) {
        if (list.isEmpty() || list.size() == 1) {
            return true;
        } else {
            char first = list.removeFirst();
            char last = list.removeLast();
            return cc.equalChars(first, last) && isPalindromeHelper(list, cc);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        LinkedListDeque<Character> pali = (LinkedListDeque<Character>) wordToDeque(word);
        return isPalindromeHelper(pali, cc);
    }
}
