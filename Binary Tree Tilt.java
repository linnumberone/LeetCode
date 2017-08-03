/**
*/
public class Solution {
    
    int tilt = 0;
    
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        postorder(root);
        
        return tilt;
    }
    
    public int postorder(TreeNode node) {
        if(node == null) return 0;
        int left = postorder(node.left);
        int right = postorder(node.right);
        
        tilt += Math.abs(left - right);
        
        return node.val + left + right;
    }
}

/**
Solution 1:
思考方式是從上
*/
public class Solution {
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        
        int tilt = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            tilt += getTiltOfNode(cur);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        
        return tilt;
    }
    
    public int getTiltOfNode(TreeNode node) {
        if(node == null) return 0;
        return Math.abs(getSumOfNode(node.left) - getSumOfNode(node.right));
    }
    
    public int getSumOfNode(TreeNode node) {
        if(node == null) return 0;
        return node.val + getSumOfNode(node.left) + getSumOfNode(node.right);
    }
}
