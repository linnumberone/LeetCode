public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(citations[mid] == len - mid)
                return citations[mid];
            else if(citations[mid] > len - mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return len - left;
    }
}
