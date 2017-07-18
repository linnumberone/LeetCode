public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        char[] words = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(!vowels.contains(words[left]))
                left++;
            else if(!vowels.contains(words[right]))
                right--;
            else {
                char temp = words[left];
                words[left] = words[right];
                words[right] = temp;
                left++; right--;
            }
        }
        return new String(words);
    }
}
