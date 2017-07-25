/**
Solution 2:
*/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(--k == 0) break;
            cur = cur.right;
        }
        return cur.val;
    }
}

/**
Solution 1:
*/
public class Solution {
    int value = 0;
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        smallestHelper(root);
        return value;
    }
    
    private void smallestHelper(TreeNode node) {
        if(node.left != null) smallestHelper(node.left);
        count--;
        if(count == 0) {
            value = node.val;
            return;
        }
        if(count < 0) return;
        if(node.right != null) smallestHelper(node.right);
    }
}
