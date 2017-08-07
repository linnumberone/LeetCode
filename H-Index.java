public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0) return 0;
        
        int[] arr = new int[len + 1];
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len) arr[len]++;
            else arr[citations[i]]++;
        }
        
        int total = 0;
        for(int i = len; i >= 0; i--) {
            total += arr[i];
            if(total >= i) return i;
        }
        
        return 0;
    }
}

public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        
        Arrays.sort(citations);
        int hIdx = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(hIdx + 1 > citations[i])
                break;
            else
                hIdx++;
        }
        return hIdx;
    }
}
