class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length < 1) return result;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // pick up the max index
        int maxIdx = 0;
        for(int i = 1; i < nums.length; i++) {
            maxIdx = (dp[i] > dp[maxIdx]) ? i : maxIdx;
        }
        
        // get each element
        int temp = nums[maxIdx];
        int curDp = dp[maxIdx];
        for(int i = maxIdx; i >= 0; i--) {
            if(temp % nums[i] == 0 && curDp == dp[i]) {
                result.add(nums[i]);
                temp = nums[i];
                curDp--;
            }
        }
        return result;
    }
}
