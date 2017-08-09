public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        
        int maxLen = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for(int i = 0; i < nums.length; i++) {
            int curMaxLen = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    curMaxLen = Math.max(curMaxLen, dp[j]);
            }
            dp[i] = 1 + curMaxLen;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
