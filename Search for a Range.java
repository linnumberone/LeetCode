public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int idx = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target <= nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
            
            if(target == nums[mid])
                idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int idx = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
            
            if(target == nums[mid])
                idx = mid;
        }
        return idx;
    }
}
