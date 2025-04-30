public class Palindrome {
    /**
     * Break a stack into two, push the first half to one stack, then push
     * second half to a stack, then pop & push to a second stack.
     * If the string is odd, the middle element goes to both stacks (or neither!)
     * R A C E C A R
     * Stack 1: R A C E
     * Middle Letter: E
     * Stack 2: E C A R
     * Re-stack either the first or second stack and compare them.
     * @param s a string to test
     * @return true if they are the same
     */
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z]", "").toLowerCase();

        ArrayListStack<Character> original = new ArrayListStack<>();
        for (char c : s.toCharArray()) {
            original.push(c);
        }

        ArrayListStack<Character> firstHalf = new ArrayListStack<>();
        ArrayListStack<Character> secondHalf = new ArrayListStack<>();

        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            secondHalf.push(original.pop());
        }

        if (len % 2 != 0) {
            original.pop();
        }

        while (!original.empty()) {
            firstHalf.push(original.pop());
        }

        while (!firstHalf.empty() && !secondHalf.empty()) {
            if (firstHalf.pop().equals(secondHalf.pop())) {
                return true;
            }
        }
        return false;
    }

}
