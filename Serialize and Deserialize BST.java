/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static final String SEP = ",";
    public static final String NULL = "";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NULL;
        
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(SEP);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL)) return null;
        
        String[] vals = data.split(SEP);
        Queue<Integer> queue = new LinkedList<Integer>();
        for(String val : vals) {
            queue.offer(Integer.valueOf(val));
        }
        return getNode(queue);
    }
    
    public TreeNode getNode(Queue<Integer> queue) {
        if(queue.isEmpty()) return null;
        
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallQueue = new LinkedList<Integer>();
        while(!queue.isEmpty() && queue.peek() < root.val) {
            smallQueue.offer(queue.poll());
        }
        root.left = getNode(smallQueue);
        root.right = getNode(queue);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
