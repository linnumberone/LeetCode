/*
Solution 2:
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        
        int len = s.length();
        for(int i = 0; i < 4 && i < len - 2; i++) {
            for(int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for(int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return result;
    }
    
    public boolean isValid(String s) {
        if(s.length() > 3 || s.length() == 0 || (s.startsWith("0") && s.length() > 1) || Integer.parseInt(s) > 255)
            return false;
        return true;
    }
}

/*
Solution 1:
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        generateIPs(s, result, "", 0, 0);
        return result;
    }
    
    public void generateIPs(String s, List<String> result, String ip, int idx, int count) {
        if(count > 4) return;
        if(count == 4 && idx == s.length()) {
            result.add(ip);
        }
        
        for(int i = 1; i < 4; i++) {
            if(idx + i > s.length()) break;
            String subStr = s.substring(idx, idx + i);
            if((subStr.startsWith("0") && subStr.length() > 1) || (i == 3 && Integer.parseInt(subStr) > 255)) continue;
            generateIPs(s, result, ip + subStr + (count == 3 ? "" : "."), idx + i, count + 1);
        }
    }
}
