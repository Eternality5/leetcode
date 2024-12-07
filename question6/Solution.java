class Solution {
    public String convert(String s, int numRows) {

        StringBuilder resultBuilder = new StringBuilder();
        boolean zigging;
        int distanceToBottom, distanceToTop;

        if (numRows == 1 || s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + 2*(numRows-1)) {
                    resultBuilder.append(s.charAt(j));
                }
            } else {
                zigging = false;
                distanceToBottom = numRows - (i+1);
                distanceToTop = numRows - distanceToBottom - 1;

                for (
                    int j = i; 
                    j < s.length(); 
                    j = (zigging) 
                        ? (j + 2*distanceToBottom)
                        : (j + 2*distanceToTop) 
                ) {
                    zigging = !zigging;
                    resultBuilder.append(s.charAt(j));
                }
            }
        }

        return resultBuilder.toString();
    }
}