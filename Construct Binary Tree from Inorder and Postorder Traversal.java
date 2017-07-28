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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // (value, position)
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);
    }
    
    public TreeNode buildTreeHelper(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        
        if(inStart > inEnd || postStart < 0) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int idx = map.get(root.val);
        
        root.right = buildTreeHelper(postStart - 1, idx + 1, inEnd, inorder, postorder, map);
        root.left = buildTreeHelper(postStart - (inEnd - idx) - 1, inStart, idx - 1, inorder, postorder, map);
        
        return root;
    }
}
