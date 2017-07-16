public class Solution {
    public String countAndSay(int n) {
        if(n < 1) return "";
        
        StringBuilder result = new StringBuilder();
        result.append("1");
        for(int i = 2; i <= n; i++) {
            StringBuilder str = new StringBuilder();
            char cur = result.charAt(0); // get first character
            int count = 0;
            for(int j = 0; j < result.length(); j++) {
                if(cur == result.charAt(j))
                    count++;
                else {
                    str.append(Integer.toString(count)).append(cur);
                    cur = result.charAt(j);
                    count = 1;
                }
            }
            str.append(Integer.toString(count)).append(cur);
            result = str;
        }
        return result.toString();
    }
}
