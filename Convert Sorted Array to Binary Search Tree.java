/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return buildTreeHelper(0, nums.length - 1, nums);

    }
    
    public TreeNode buildTreeHelper(int start, int end, int[] nums) {
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTreeHelper(start, mid - 1, nums);
        root.right = buildTreeHelper(mid + 1, end, nums);
        return root;
    }
}
