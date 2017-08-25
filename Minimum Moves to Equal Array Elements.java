class Solution {
    public int minMoves(int[] nums) {
        if(nums.length <= 1) return 0;
        // 除了最大值，每個人向上走一格；換個角度想，其實就是最大值向下走一格
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        int steps = 0;
        for(int i = 0; i < nums.length; i++) {
            steps += nums[i] - min;
        }
        return steps;
    }
}
