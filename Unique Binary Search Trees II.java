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
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return new ArrayList<TreeNode>();
        return genTrees(1, n);
    }
    
    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();

        if(start > end) {
            ans.add(null);
            return ans;
        }
        
        if(start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        
        List<TreeNode> left, right;
        for(int i = start; i <= end; i++) {
            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);
            
            for(TreeNode ln : left) {
                for(TreeNode rn: right) {
                    TreeNode node = new TreeNode(i);
                    node.left = ln;
                    node.right = rn;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}
