class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyNums = new ArrayList<Integer>();
        uglyNums.add(1);
        int i = 0, j = 0, k = 0; // i for 2, j for 3, k for 5
        while(n-- > 1) {
            int min = Math.min(uglyNums.get(i) * 2, Math.min(uglyNums.get(j) * 3, uglyNums.get(k) * 5));
            uglyNums.add(min);
            
            if(min == uglyNums.get(i) * 2) i++;
            if(min == uglyNums.get(j) * 3) j++;
            if(min == uglyNums.get(k) * 5) k++;
        }
        return uglyNums.get(uglyNums.size() - 1);
    }
}
