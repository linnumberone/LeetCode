/**
Solution 2:
 */
public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        
        helper(t, sb);
        return sb.toString();
    }
    
    public void helper(TreeNode t, StringBuilder sb) {
        if(t == null) return;
        
        sb.append(t.val);
        if(t.left != null || t.right != null) {
            sb.append("(");
            helper(t.left, sb);
            sb.append(")");
            if(t.right != null) {
                sb.append("(");
                helper(t.right, sb);
                sb.append(")");
            }
        }
    }
}

/**
Solution 1:
 */
public class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        
        String root = String.valueOf(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if("".equals(left) && "".equals(right))
            return root;
        else if("".equals(left))
            return root + "()" + "(" + right + ")";
        else if("".equals(right))
            return root + "(" + left + ")";
        else
            return root + "(" + left + ")" + "(" + right + ")";
    }
}
