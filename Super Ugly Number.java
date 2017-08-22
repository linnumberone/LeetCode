class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] idx = new int[primes.length];
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        
        for(int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * res.get(idx[j]));
            }
            for(int j = 0; j < primes.length; j++) {
                if(min == primes[j] * res.get(idx[j]))
                    idx[j]++;
            }
            res.add(min);
        }
        return res.get(res.size() - 1);
    }
}
