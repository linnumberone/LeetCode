class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        // record the last position of each digits in the buckets
        for(int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for(int i = 0; i < digits.length; i++) {
            for(int j = 9; j > digits[i] - '0'; j--) {
                if(buckets[j] > i) { // the larger value has later position
                    char tmp = digits[i];
                    digits[i] = digits[buckets[j]];
                    digits[buckets[j]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
