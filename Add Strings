class Solution {
    public String addStrings(String num1, String num2) {
        // reverse two string respectively
        // iterate each character of this two string at the same time
        // use variable(remain) to record whether
        // reverse the result
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int val1 = (i < 0) ? 0 : num1.charAt(i) - '0';
            int val2 = (j < 0) ? 0 : num2.charAt(j) - '0';
            
            sb.append((carry + val1 + val2) % 10);
            carry = (carry + val1 + val2) / 10;
        }
        
        return sb.reverse().toString();
    }
}
