/**
Solution 1: Math solution
*/
class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}


/**
Solution 2: Timeout....
*/
class Solution {
    public int bulbSwitch(int n) {
        boolean[] bulbOn = new boolean[n + 1];
        Arrays.fill(bulbOn, true);
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; i * j <= n; j++) {
                bulbOn[i * j] ^= true;
            }
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(bulbOn[i])
                count++;
        }
        
        return count;
    }
}
