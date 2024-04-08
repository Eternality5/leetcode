package question3;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> usedLetters = new HashSet<>();
        Queue<Character> currentSubstring = new LinkedList<>();

        int maxLength = 0;

        for (char letter : s.toCharArray()) {
            while (usedLetters.contains(letter)) {
                char first = currentSubstring.poll();
                usedLetters.remove(first);
            }

            currentSubstring.add(letter);
            usedLetters.add(letter);
            maxLength = Math.max(maxLength, currentSubstring.size());
        }

        return maxLength;
    }
}
