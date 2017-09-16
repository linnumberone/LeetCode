class Solution {
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        int sum = 0;
        int f = 0;
        for(int i = 0; i < len; i++) {
            f += i * A[i];
            sum += A[i];
        }
        
        int max = f;
        for(int i = 1; i < len; i++) {
            f = f + sum - len * A[len - i];
            max = Math.max(f, max);
        }
        
        return max;
    }
}
