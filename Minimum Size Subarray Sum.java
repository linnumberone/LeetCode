public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        
        int minLen = nums.length + 1;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum >= s) {
                while(left <= i && (sum - nums[left] >= s)) {
                    sum -= nums[left];
                    left++;
                }
                minLen = Math.min(minLen, i - left + 1);
            }
        }
        return (minLen > nums.length) ? 0 : minLen;
    }
}
