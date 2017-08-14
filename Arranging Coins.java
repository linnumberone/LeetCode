public class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(n >= 0.5 * mid + 0.5 * mid * mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left - 1;
    }
}
