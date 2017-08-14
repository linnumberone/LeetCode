/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // 1. use map to record the start point and its location
    // 2. use list to record the start, and sort it
    // 3. for each end, find leftmost start by using binary search
    // 4. get original location
    
    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, Integer> location = new HashMap<Integer, Integer>();
        List<Integer> starts = new ArrayList<Integer>();
        
        for(int i = 0; i < intervals.length; i++) {
            location.put(intervals[i].start, i);
            starts.add(intervals[i].start);
        }
        Collections.sort(starts);
        
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            int end = intervals[i].end;
            int leftmost = binarySearch(starts, intervals[i].end);
            if(leftmost < end)
                res[i] = -1;
            else
                res[i] = location.get(leftmost);
        }
        
        return res;
    }
    
    public int binarySearch(List<Integer> starts, int end) {
        int left = 0, right = starts.size() - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(starts.get(mid) < end)
                left = mid + 1;
            else
                right = mid;
        }
        return starts.get(left);
    }
}
