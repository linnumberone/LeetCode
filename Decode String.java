/**
Solution 2:
*/
public class Solution {
    public String decodeString(String s) {
        Stack<String> resStack = new Stack<String>();
        Stack<Integer> cntStack = new Stack<Integer>();
        
        int i = 0;
        resStack.push("");
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int count = 0;
                while(Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                cntStack.push(count);
            }
            else if('[' == s.charAt(i)) {
                resStack.push("");
                i++;
            }
            else if(']' == s.charAt(i)) {
                String temp = resStack.pop();
                StringBuilder sb = new StringBuilder();
                int repeatTimes = cntStack.pop();
                for(int j = 0; j < repeatTimes; j++) {
                    sb.append(temp);
                }
                resStack.push(resStack.pop() + sb.toString());
                i++;
            }
            else {
                resStack.push(resStack.pop() + s.charAt(i));
                i++;
            }
        }
        return resStack.pop();
    }
}

/**
Solution 1:
*/
public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<String> resStack = new Stack<String>();
        Stack<Integer> cntStack = new Stack<Integer>();
        
        int i = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int count = 0;
                while(Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                cntStack.push(count);
            }
            else if('[' == s.charAt(i)) {
                resStack.push(res.toString());
                res = "";
                i++;
            }
            else if(']' == s.charAt(i)) {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = cntStack.pop();
                for(int j = 0; j < repeatTimes; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            }
            else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }
}
