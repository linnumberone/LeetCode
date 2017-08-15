public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int idx = Collections.binarySearch(arr, x);
        System.out.println(idx);
        if(idx < 0) idx = -(idx + 1);
        int i = idx - 1, j = idx;
        while(k-- > 0) {
            if(i < 0 || (j < arr.size() && Math.abs(arr.get(i) - x) > Math.abs(arr.get(j) - x)))
                j++;
            else
                i--;
        }
        return arr.subList(i + 1, j);
    }
}
