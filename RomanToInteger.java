/*
1. 必須要知道羅馬數字所代表的意思
2. 要知道羅馬數字的解讀必須從後往前看，再配合加減前面的值
*/

public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch(c) {
                case 'I': // 1
                    result += (result >= 5 ? -1 : 1);
                    break;
                case 'V': // 5
                    result += 5;
                    break;
                case 'X': // 10
                    result += 10 * (result >= 50 ? -1 : 1);
                    break;
                case 'L': // 50
                    result += 50;
                    break;
                case 'C': // 100
                    result += 100 * (result >= 500 ? -1 : 1);
                    break;
                case 'D': // 500
                    result += 500;
                    break;
                case 'M': // 1000
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}
