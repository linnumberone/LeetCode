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
