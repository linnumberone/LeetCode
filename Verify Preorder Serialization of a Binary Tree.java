public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<String>();
        String[] strs = preorder.split(",");
        for(String str : strs) {
            while("#".equals(str) && !stack.isEmpty() && str.equals(stack.peek())) {
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(str);
        }
        
        return stack.size() == 1 && "#".equals(stack.peek());
    }
}
