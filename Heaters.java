public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = 0;
        int i = 0;
        for(int house : houses) {
            while(i < heaters.length - 1 && heaters[i + 1] + heaters[i] <= 2 * house) {
                i++;
            }
            radius = Math.max(radius, Math.abs(house - heaters[i]));
        }
        return radius;
    }
}
