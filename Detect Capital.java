/*
Solution 1:
*/
public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() < 2) return true;
        if(word.toUpperCase().equals(word)) return true; // all uppercase
        if(word.substring(1).toLowerCase().equals(word.substring(1))) return true; // all lowercase except first char
        return false;
    }
}

/*
Solution 2:
*/
public class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if(arr.length == 1) return true;
        
        for(int i = 1; i < arr.length; i++) {
            if(!isUppercase(arr[0]) && isUppercase(arr[i]))
                return false;
            else if(isUppercase(arr[0]) && !(isUppercase(arr[1]) == isUppercase(arr[i])))
                return false;
        }
        return true;
    }
    
    private boolean isUppercase(char c) {
        return (c - 'Z' <= 0);
    }
}
