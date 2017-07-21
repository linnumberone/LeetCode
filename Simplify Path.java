/*
Solution 2:
*/
public class Solution {
    public String simplifyPath(String path) {
        /*
        ./ => ignore
        ../ => pop
        */
        Stack<String> traverse = new Stack<String>();
        String[] token = path.split("/");
        for(String t : token) {
            if(".".equals(t) || "".equals(t) || ("..".equals(t) && traverse.empty()))
                continue;
            else if("..".equals(t))
                traverse.pop();
            else
                traverse.push(t);
        }
        
        String ans = "";
        while(!traverse.empty()) {
            ans = "/" + traverse.pop() + ans;
        }
        
        return "".equals(ans) ? "/" : ans;
    }
}

/*
Solution 1:
*/
public class Solution {
    public String simplifyPath(String path) {
        /*
        ./ => ignore
        ../ => pop
        */
        Stack<String> traverse = new Stack<String>();
        String[] token = path.split("/");
        for(String t : token) {
            if(".".equals(t) || "".equals(t) || ("..".equals(t) && traverse.empty()))
                continue;
            else if("..".equals(t))
                traverse.pop();
            else
                traverse.push(new StringBuilder(t).reverse().toString());
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!traverse.empty()) {
            sb.append(traverse.pop()).append("/");
        }
        
        return ("".equals(sb.toString())) ? "/" : sb.reverse().toString();
    }
}
