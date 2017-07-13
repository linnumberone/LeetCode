public class Solution {
    private int lo = 0, maxLen = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(i, i, s); // assume the length of result is odd
            extendPalindrome(i, i + 1, s); // assume the length of result is even
        }
        return s.substring(lo, lo + maxLen); // [start, end)
    }
    
    public void extendPalindrome(int j, int k, String s) {
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
    
}
