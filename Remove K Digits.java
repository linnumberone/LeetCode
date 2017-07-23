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
