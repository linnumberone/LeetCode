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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> avgOfNode = new ArrayList<Double>();
        if(root == null) return avgOfNode;
        
        List<Integer> numOfNode = new ArrayList<Integer>();
        List<Double> sumOfNode = new ArrayList<Double>();
        preorder(root, 0, numOfNode, sumOfNode);
        
        for(int i = 0; i < numOfNode.size(); i++) {
            avgOfNode.add(sumOfNode.get(i) / numOfNode.get(i));
        }
        return avgOfNode;
    }
    
    public void preorder(TreeNode node, int depth, List<Integer> numOfNode, List<Double> sumOfNode) {
        if(depth >= numOfNode.size()) {
            numOfNode.add(1);
            sumOfNode.add((double) node.val);
        }
        else {
            numOfNode.set(depth, numOfNode.get(depth) + 1);
            sumOfNode.set(depth, sumOfNode.get(depth) + node.val);
        }
        if(node.left != null) preorder(node.left, depth + 1, numOfNode, sumOfNode);
        if(node.right != null) preorder(node.right, depth + 1, numOfNode, sumOfNode);
    }
}
