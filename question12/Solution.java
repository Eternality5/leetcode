class Solution {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 4; i > 0; i--) {
            stringBuilder.append(intToRoman(num, i));
        }
        return stringBuilder.toString();
    }
    
    public String intToRoman(int num, int magnitude) {
        num /= Math.pow(10, magnitude - 1);
        num %= 10;

        if (num == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder(); 

        if (num == 9 || num == 4) {
            if (magnitude == 1) {
                stringBuilder.append("I");
            } else if (magnitude == 2) {
                stringBuilder.append("X");
            } else if (magnitude == 3) {
                stringBuilder.append("C");
            } else if (magnitude == 4) {
                stringBuilder.append("M");
            }
        }

        if (num == 9) {
            num = 1;
            magnitude++;
        } else if (num == 4) {
            num = 5;
        }

        if (num / 5 != 0) {
            if (magnitude == 1) {
                stringBuilder.append("V");
            } else if (magnitude == 2) {
                stringBuilder.append("L");
            } else if (magnitude == 3) {
                stringBuilder.append("D");
            } 
        }
        
        int loopCount = num % 5;
        for (int i = 0; i < loopCount; i++) {
            if (magnitude == 1) {
                System.out.println("loop 5");
                stringBuilder.append("I");
            } else if (magnitude == 2) {
                stringBuilder.append("X");
            } else if (magnitude == 3) {
                stringBuilder.append("C");
            } else if (magnitude == 4) {
                stringBuilder.append("M");
            }
        }
        
        return stringBuilder.toString();
    }
}