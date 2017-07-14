/*
1. 必須知道 900, 400... 這些值也是必須考慮的 case
2. 由最大的值開始減
*/

public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        while(num > 0) {
            if(num >= values[idx]) {
                num -= values[idx];
                sb.append(strs[idx]);
            }
            else
                idx++;
        }
        return sb.toString();
    }
}
