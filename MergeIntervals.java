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
    public List<Interval> merge(List<Interval> intervals) {        
        List<Interval> result = new ArrayList<Interval>();
        
        if(intervals.size() < 1)
            return result;
        
        // java 8, anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        int curStart = intervals.get(0).start;
        int curEnd = intervals.get(0).end;
        
        for(Interval iter : intervals) {
            // overlapping
            if(iter.start <= curEnd) {
                curEnd = Math.max(curEnd, iter.end);
            }
            else {
                result.add(new Interval(curStart, curEnd));
                curStart = iter.start;
                curEnd = iter.end;
            }
        }
        // add the last result
        result.add(new Interval(curStart, curEnd));
        return result;
    }
}
