/*
Solution 3:
binary search
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1)
            return "";
        
        int minLen = strs[0].length();
        for(int i = 1; i < strs.length; i++)
            minLen = Math.min(minLen, strs[i].length());
        
        int left = 0, right = minLen - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(isCommonPrefix(strs, middle)) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return strs[0].substring(0, (left + right + 1) / 2);
    }
    
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len + 1);
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].indexOf(prefix) != 0)
                return false;
        }
        return true;
    }
}

/*
Solution 2:
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1)
            return "";
        
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}

/*
Solution 1: 只想著直線進攻的笨方法
Complexity high
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1 || strs[0].length() < 1)
            return "";
        
        int minLen = strs[0].length();
        for(int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < strs[0].length() && i < minLen; i++) {
            char c = strs[0].charAt(idx);
            for(int j = 0; j < strs.length; j++) {
                if(c != strs[j].charAt(idx))
                    return sb.toString();
                else if(j == strs.length - 1)
                    sb.append(c);
            }
            idx++;
        }
        return sb.toString();
    }
}
