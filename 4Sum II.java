public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> occurance = new HashMap<Integer, Integer>();
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                occurance.put(sum, occurance.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                res += occurance.getOrDefault(-sum, 0);
            }
        }
        return res;
    }
}
