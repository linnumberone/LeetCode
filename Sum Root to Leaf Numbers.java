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
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    public int sumNumbersHelper(TreeNode root, int pre) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return pre * 10 + root.val;
        return sumNumbersHelper(root.left, pre * 10 + root.val) + sumNumbersHelper(root.right, pre * 10 + root.val);
    }
}
