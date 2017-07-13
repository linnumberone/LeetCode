// Solution 1: use map (performance is better)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        
        for(int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if(position.containsKey(c)) {
                // other characters less than the repeating character are no long useful
                // if the string is "abcaabcd", when we look at 3rd 'a', all other characters before 2nd 'a' are not considered
                start = Math.max(start, position.get(c) + 1);
            }
            position.put(c, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}

// Solution 2: use set (solution is worse)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, max = 0;
        Set<Character> substring = new HashSet<Character>();
        
        while(end < s.length()) {
            if(!substring.contains(s.charAt(end))) {
                substring.add(s.charAt(end++));
                max = Math.max(max, substring.size());
            }
            else {
                substring.remove(s.charAt(start++));
            }
        }
        
        return max;
    }
}
