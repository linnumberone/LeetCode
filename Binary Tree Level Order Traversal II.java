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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelMaker(root, res, 0);
        return res;
    }
    
    public void levelMaker(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null) return;
        if(level >= res.size())
            res.add(0, new ArrayList<Integer>());
        
        res.get(res.size() - level - 1).add(node.val);
        levelMaker(node.left, res, level + 1);
        levelMaker(node.right, res, level + 1);
    }
}
