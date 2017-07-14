/*
Solution 2:
*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(')
                chars.push(')');
            else if(c == '{')
                chars.push('}');
            else if(c == '[')
                chars.push(']');
            else if(chars.empty() || chars.pop() != c)
                return false;
        }
        return chars.empty();
    }
}

/*
Solution 1:
*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                chars.push(c);
            else {
                if(chars.empty())
                    return false;
                
                char left = chars.pop();
                if((c == ')' && left != '(') ||
                   (c == '}' && left != '{') ||
                   (c == ']' && left != '['))
                    return false;
            }
        }
        return chars.empty();
    }
}
