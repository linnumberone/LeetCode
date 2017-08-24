class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        
        int ans = 10; // n == 1
        int base = 9;
        for(int i = 2; i <= n && i <= 10; i++) {
            base = base * (11 - i);
            ans += base;
        }
        return ans;
    }
}
