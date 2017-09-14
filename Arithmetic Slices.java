/**
Solution 1: Trivial solution:
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // map X
        if(A.length < 3) return 0;
        
        int result = 0;
        for(int i = 0; i < A.length - 2; i++) {
            int diff = A[i + 1] - A[i];
            for(int j = i + 2; j < A.length; j++) {
                if(A[j] - A[j - 1] == diff) result++;
                else break;
            }
        }
        return result;
    }
}

/**
Solution 2: Use some trick
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0, cur = 0;
        
        for(int i = 2; i < A.length; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
                sum += cur;
            }
            else
                cur = 0;
        }
        return sum;
    }
}
