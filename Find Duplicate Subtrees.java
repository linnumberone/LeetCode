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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        postorder(root, new HashMap<>(), res);
        return res;
    }
    
    public String postorder(TreeNode node, Map<String, Integer> shown, List<TreeNode> res) {
        if(node == null) return "#";
        String path = node.val + "," + postorder(node.left, shown, res) + "," + postorder(node.right, shown, res);
        if(shown.getOrDefault(path, 0) == 1)
            res.add(node);
        shown.put(path, shown.getOrDefault(path, 0) + 1);
        return path;
    }
}
