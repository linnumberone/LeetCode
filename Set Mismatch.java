class Solution {
    public int[] findErrorNums(int[] nums) {
        int max = nums.length;
        int duplicate = -1;
        Set<Integer> count = new HashSet<Integer>();
        for(int i = 0; i < max; i++) {
            if(count.contains(nums[i]))
                duplicate = nums[i];
            count.add(nums[i]);
        }
        int missing = -1;
        for(int i = 1; i <= max; i++) {
            if(!count.contains(i)) {
                missing = i;
                break;
            }
        }
        
        return new int[] {duplicate, missing};
    }
}
