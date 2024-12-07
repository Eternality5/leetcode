class Solution {
    public String longestPalindrome(String s) {
        String result;
        int rightIndex, leftIndex;

        if (s.length() <= 1) {
            return s;
        }

        result = s.substring(0, 1);
        int length = s.length();

        for (int i = 0; i < length - 1; i++) {
            rightIndex = i + 1;
            leftIndex = i - 1;

            // Case for 2 character palindrome
            while (rightIndex < length && s.charAt(i) == s.charAt(rightIndex)) {
                result = updatePalindromeString(result, s.substring(i, rightIndex+1));
                rightIndex++;
            }

            while(rightIndex < length 
                && leftIndex >= 0
                && s.charAt(rightIndex) == s.charAt(leftIndex)) {
                    result = updatePalindromeString(result, s.substring(leftIndex, rightIndex+1));
                    rightIndex++;
                    leftIndex--;
            }
        }

        return result;
    }

    private String updatePalindromeString(String result, String newResult) {
        return newResult.length() > result.length() 
                    ? newResult
                    : result;
    }
}