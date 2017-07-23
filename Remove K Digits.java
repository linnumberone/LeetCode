public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        int i = 0;
        
        if(k == len) return "0";
        
        Stack<Character> stack = new Stack<Character>(); 
        while(i < len) {
            while(k > 0 && !stack.empty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i));
            i++;
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}


public class Solution {
    public String removeKdigits(String num, int k) {
        while(k > 0) {
            int i = 0;
            int len = num.length();
            
            while(i + 1 < len && num.charAt(i) <= num.charAt(i + 1))
                i++;
            
            if(i + 1 < len)
                num = num.substring(0, i) + num.substring(i + 1);
            else
                num = num.substring(0, i);
            
            k--;
        }
        
        int s = 0;
        while(s < num.length() && num.charAt(s) == '0') s++;
        num = num.substring(s); 
        
        return "".equals(num) ? "0" : num;
        
    }
}
