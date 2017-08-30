class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> climbWays = new HashMap<Integer, Integer>();
        climbWays.put(1, 1);
        climbWays.put(2, 2);
        for(int i = 3; i <= n; i++) {
            int ways = climbWays.get(i - 2) + climbWays.get(i - 1);
                //climbWays.getOrDefault(i - 2, 1) + climbWays.getOrDefault(i - 1, 1);
            climbWays.put(i, ways);
        }
        return climbWays.get(n);
    }
