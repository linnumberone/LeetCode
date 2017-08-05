public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(target == nums[mid])
                return true;
            
            // if left part is sorted
            if(nums[left] < nums[mid]) {
                if(target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // if left part is unsorted
            else if(nums[mid] < nums[left]) {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else
                left++;
        
        }
        return false;
    }
}
