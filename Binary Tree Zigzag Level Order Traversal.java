/**
Solution 2:簡潔的版本
*/
public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
        
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        insertToList(root, 0);
        return res;
    }
    
    private void insertToList(TreeNode node, int level) {
        if(node == null)
            return;
        
        // initialize an empty array
        if(level >= res.size())
            res.add(new ArrayList<Integer>());
        
        if(level % 2 == 0)
            res.get(level).add(node.val);
        else // add value to the start of the list
            res.get(level).add(0, node.val);
        
        insertToList(node.left, level + 1);
        insertToList(node.right, level + 1);
    }
}

/**
Solution 1:
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
        
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        insertToList(root, 0);
        
        for(int i = 0; i < res.size(); i++) {
            if(i % 2 == 1)
                Collections.reverse(res.get(i));
        }
        
        return res;
    }
    
    private void insertToList(TreeNode node, int level) {
        if(node == null)
            return;
        
        // initialize an empty array
        if(level >= res.size())
            res.add(new ArrayList<Integer>());
        
        res.get(level).add(node.val);
        
        insertToList(node.left, level + 1);
        insertToList(node.right, level + 1);
    }
}
