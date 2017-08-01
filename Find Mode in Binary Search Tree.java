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
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max = 0;
    
    public int[] findMode(TreeNode root) {
        preorder(root);
        
        List<Integer> maxList = new ArrayList<Integer>();
        for(int key : map.keySet()) {
            if(map.get(key) == max)
                maxList.add(key);
        }
        
        int[] res = new int[maxList.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = maxList.get(i);
        
        return res;
    }
    
    public void preorder(TreeNode node) {
        if(node == null) return;
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, map.get(node.val));
        preorder(node.left);
        preorder(node.right);
    }
}
