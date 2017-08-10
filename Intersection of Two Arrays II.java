public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> intersect = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                intersect.put(nums2[i], intersect.getOrDefault(nums2[i], 0) + 1);
                if(map.get(nums2[i]) == 1)
                    map.remove(nums2[i]);
                else
                    map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int val : intersect.keySet()) {
            int cnt = intersect.get(val);
            for(int j = 0; j < cnt; j++) {
                ans.add(val);
            }
        }
        
        int[] sol = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            sol[i] = ans.get(i);
        }
        
        return sol;
    }
}
