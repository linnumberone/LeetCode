public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> category = new HashMap<String, List<String>>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedStr = String.valueOf(c);
            if(!category.containsKey(sortedStr))
                category.put(sortedStr, new ArrayList<String>());
            category.get(sortedStr).add(s);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> entry : category.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
