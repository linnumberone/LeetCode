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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        createEachLv(root, res, 0);
        return res;

    }
    public void createEachLv(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null) return;
        
        if(level < res.size())
            res.get(level).add(node.val);
        else {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(node.val);
            res.add(temp);
        }
        
        createEachLv(node.left, res, level + 1);
        createEachLv(node.right, res, level + 1);
    }
}
