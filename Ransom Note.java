/*
Solution 2:
*/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for(char c : ransomNote.toCharArray()) {
            if(--arr[c - 'a'] < 0)
                return false;
        }
        
        return true;
    }
}

/*
Solution 1:
*/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {       
        Map<Character, Integer> noteFreq = new HashMap<Character, Integer>();
        Map<Character, Integer> magzFreq = new HashMap<Character, Integer>();
        
        for(char c : ransomNote.toCharArray()) {
            noteFreq.put(c, noteFreq.getOrDefault(c, 0) + 1);
        }
        for(char c : magazine.toCharArray()) {
            magzFreq.put(c, magzFreq.getOrDefault(c, 0) + 1);
        }
        
        for(Character c : noteFreq.keySet()) {
            if(!magzFreq.containsKey(c) || noteFreq.get(c) > magzFreq.get(c))
                return false;
        }
        return true;
    }
}
