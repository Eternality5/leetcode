class Solution {
    public int myAtoi(String s) {
        // 1. Whitespace: Ignore any leading whitespace (" ").
        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        // 2. Signedness: Determine the sign by checking if the next character
        // is '-' or '+', assuming positivity if neither present.
        boolean isNegative = s.charAt(0) == '-';
        if (s.charAt(0) == '+' || isNegative) {
            s = s.substring(1);
        }

        // 3. Conversion: Read the integer by skipping leading zeros until a non-digit 
        // character is encountered or the end of the string is reached. If no digits 
        // were read, then the result is 0.
        while (s.length() > 0 && s.charAt(0) == '0') {
            s = s.substring(1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                s = s.substring(0, i);
                break; 
            }
        }

        if (s.length() == 0) {
            return 0;
        }

        // 4. Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], 
        // then round the integer to remain in the range. Specifically, integers less than -231 
        // should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
        if (s.length() > 10) {
            return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        long l = Long.valueOf(s);
        l = (isNegative) ? l * -1 : l;
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)l;
        }
    }
}