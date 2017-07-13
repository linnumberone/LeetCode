public class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
            
        int idx = 0; // trace the whole s
        while(idx < len) {
            for(int i = 0; i < numRows && idx < len; i++) {
                rows[i].append(c[idx++]);
            }
            for(int i = numRows - 2; i >= 1 && idx < len; i--) {
                rows[i].append(c[idx++]);
            }
        }
        for(int i = 1; i < numRows; i++) {
            rows[0].append(rows[i]);
        }
        return rows[0].toString();
    }
}
