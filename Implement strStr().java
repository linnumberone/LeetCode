public class Solution {
    // java string indexOf problem
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if(n == 0)
            return 0;
        for(int i = 0; i < m - n + 1; i++) {
            int j = 0;
            for(; j < n; j++) {
                if(haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if(j == n)
                return i;
        }
        return -1;
    }
}
