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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        pathSumHelper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void pathSumHelper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if(root == null) return;
        
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            res.add(path);
            return;
        }
        pathSumHelper(root.left, sum - root.val, new ArrayList<Integer>(path), res);
        pathSumHelper(root.right, sum - root.val, new ArrayList<Integer>(path), res);
    }
}
