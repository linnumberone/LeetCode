public class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        StringBuilder sb = new StringBuilder();
        
        int i = len1 - 1, j = len2 - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) sum += (a.charAt(i--) - '0');
            if(j >= 0) sum += (b.charAt(j--) - '0');
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}