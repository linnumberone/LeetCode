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
        boolean[] alreadyAdd = new boolean[intervals.size()];
       
        // java 8, anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        for(int i = 0; i < intervals.size(); ++i) {
            if(alreadyAdd[i])
                continue;
            
            alreadyAdd[i] = true;
            Interval toAdd = new Interval(intervals.get(i).start, intervals.get(i).end);
            for(int j = i + 1; j < intervals.size(); ++j) {
                if(alreadyAdd[j])
                    continue;
                
                // if overlapping
                if((toAdd.start >= intervals.get(j).start && toAdd.start <= intervals.get(j).end) ||
                   (toAdd.end <= intervals.get(j).end && toAdd.end >= intervals.get(j).start) ||
                   (toAdd.start <= intervals.get(j).start && toAdd.end >= intervals.get(j).end)) {
                    toAdd.start = Math.min(toAdd.start, intervals.get(j).start);
                    toAdd.end = Math.max(toAdd.end, intervals.get(j).end);
                    alreadyAdd[j] = true;
                }
            }
            result.add(toAdd);
        }
        return result;
    }
}
